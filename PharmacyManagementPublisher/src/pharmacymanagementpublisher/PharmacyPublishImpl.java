package pharmacymanagementpublisher;

import java.util.ArrayList;
import java.util.Formatter;

public class PharmacyPublishImpl implements PharmacyPublisher {
	//Creating a Variables for storing a patient details
	String pName;
	String pID;
	String gender;
	String Age;
	String pNum;
	
	//variables for billing  
	int total;
	int paidAmount;
	int balance;
	
	//Create  an array list for store product details
	ArrayList<String> productList = new ArrayList<String>();
	ArrayList<String> productIDList = new ArrayList<String>();
	ArrayList<Integer> quantityList = new ArrayList<Integer>();
	ArrayList<Integer> priceList = new ArrayList<Integer>();
	ArrayList<Integer> totalproductList = new ArrayList<Integer>();
	
	//Method to setPatientDetails
	@Override
	public void setPatientDetails(String pName, String pID, String gender, String Age, String pNum) {
		this.pName=pName;
		this.pID=pID;
		this.gender=gender;
		this.Age=Age;
		this.pNum=pNum;
		
	}
	
	//Method to get patient details
	@Override
	public String getPatientDetails() {
		
		String msg = "=================== Patient Details=============";
		
		msg = msg + "\nEnter Patient Name  	: " + this.pName + "\n" + "Patient ID  	:	 " + this.pID + "\n" + "Enter Age  	:	 "+ this.Age + "\n" +"Enter Gender  	:	 "+this.gender + "\n" +"Enter Phone Num :	 " + this.pNum + "\n";
		
		return msg;
	}
	

	//Method to add product to the pharmacy inventory
	@Override
	public void addProduct(String productName, String productID, int quantity, int price) {
		productList.add(productName);
		productIDList.add(productID);
		quantityList.add(quantity);
		priceList.add(price);
		
		
		
		
	}

	@Override
	public void total(int price, int quantity) {
		// TODO Auto-generated method stub
		//int total = price * quantity;
		Integer total = price * quantity;
		
		totalproductList.add(total);
		
	}

	

	@Override
	public int sum() {
		//int sum =0;
		Integer sum = 0;
		for (int i = 0 ; i < productList.size(); i ++) {
			sum = sum + totalproductList.get(i);
		}
		return sum;
		
				
	}
	//Method to display formatted details using table
	/*@Override
	public Formatter dislpayDetails() {
		// TODO Auto-generated method stub
		Formatter fmt = new Formatter();
		
		fmt.format("%28s %22s %22 %20 *%35\n","Product Name" , "ProductID" ,"Quantity", "Price" , "Total price \n");
		
		String msg = "";
		
		for (int i=0 ; i<productList.size(); i++ ) {
			fmt.format("%27s %20s %16s.00 %22 *%25s.00\n", productList.get(i), productIDList.get(i), quantityList.get(i), priceList.get(i), totalproductList.get(i));
		}
		return fmt;
	}
*/
	
	@Override
	public void clearList() {
		productList.clear();
		productIDList.clear();
		quantityList.clear();
		priceList.clear();
		totalproductList.clear();
		
		
	}
	
	@Override
	public void calculateBill(int paidAmount, int total) {
		this.total=total;
		this.paidAmount=paidAmount;
		balance =paidAmount- total;
		
	}
	

	@Override
	public String getBill() {
		// TODO Auto-generated method stub
		String msg;
		msg= "Total For All Products =" + total + "\n" + "Paid Ammount = " + paidAmount + "\n" + "Balace =" +balance  ;
		return msg;
	}

	

}
