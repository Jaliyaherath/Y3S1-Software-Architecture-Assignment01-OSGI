package pharmacymanagementpublisher;

import java.util.Formatter;

public interface PharmacyPublisher {
	
	public void setPatientDetails(String pName, String pID,String gender, String Age, String pNum );
	
	public String getPatientDetails();
	
	public void addProduct(String productName, String productID, int quantity, int price);
	
	public void total(int price, int quantity);
	
	//public Formatter dislpayDetails();
	
	public int sum();
	
	public void calculateBill(int paidAmount ,int total);
	
	public String getBill();
	
	public void clearList();

}
