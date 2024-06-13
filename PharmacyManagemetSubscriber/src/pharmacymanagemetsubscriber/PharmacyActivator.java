package pharmacymanagemetsubscriber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import pharmacymanagementpublisher.PharmacyPublisher;

public class PharmacyActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	public void start(BundleContext context) throws Exception {
		
		serviceReference = context.getServiceReference(PharmacyPublisher.class.getName());
		PharmacyPublisher pharmacyPublisher = (PharmacyPublisher) context.getService(serviceReference);
		
		System.out.println("Start Pharmacy Subscriber Service");
		Scanner sc = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//Get the details from user
		System.out.println("======Enter Patient Details======");
		
		System.out.println("\nEnter Patient Name");
		String pName = sc.nextLine();
		
		System.out.println("Enter Patient ID(Nic or Any Other Acceptable ID)");
		String pID = sc.nextLine();
		
		System.out.println("Enter Patient Gender(F/M)");
		String gender = sc.nextLine();
		
		
		System.out.println("Enter Patient Age");
		String Age = sc.nextLine();
		
		System.out.println("Enter Patient Phone Number");
		String pNum = sc.nextLine();
		
		String productName="";
		
		System.out.println("======Enter Product Details======");
		
		System.out.println("\n*******If you want to exit put the blank line in to the Product name*****");
		
		while(true) {
			
			System.out.println("Enter Product Name");
			productName = in.readLine();
			
			if(productName.length() == 0) {
				break;
			}
			else {
				System.out.println("Enter Product ID");
				String productID= in.readLine();
				
				System.out.println("Enter Price");
				int price= sc.nextInt();
				
				System.out.println("Enter Quantity of Items");
				int quantity= sc.nextInt();
				
				System.out.println();
				
				if(pName != null && pID != null) {
					pharmacyPublisher.setPatientDetails(pName, pID, gender, Age, pNum);
				}
				//call the addProduct method and pass the arguments
				pharmacyPublisher.addProduct(productName, productID, quantity, price);
				
				//call the total method and pass the arguments
				pharmacyPublisher.total(price, quantity);
			}
		}
		System.out.println("\n Total Cost For All Product :" + pharmacyPublisher.sum() +"\n");
		
		System.out.println("Enter Paid Amount");
		int paidAmount = sc.nextInt();
		
		//pass the paid amount to calculatebill method
		pharmacyPublisher.calculateBill(paidAmount, pharmacyPublisher.sum());
		
		System.out.println("\n\n------------------------------------------------");
		
		System.out.println("------------------------------------------------");
		
		System.out.println("\tNexa Pharmacy By J3H43R");
		
		System.out.println("------------------------------------------------");
		//Call the getPatientDetails() method to display the details of patient
		System.out.println(pharmacyPublisher.getPatientDetails());
		
		System.out.println("-----------------------------------------------");
		
		System.out.println("\n\t#### Billing Information ####");
		
		//System.out.println(pharmacyPublisher.dislpayDetails());
		
		//Calling the method getBill() to calculate the balance and show other details
		System.out.println(pharmacyPublisher.getBill() + "\n\n");
		
		System.out.println("-----------------------------------------------");
		
		pharmacyPublisher.clearList();
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stop Pharmacy Subscriber");
		context.ungetService(serviceReference);
	}

}
