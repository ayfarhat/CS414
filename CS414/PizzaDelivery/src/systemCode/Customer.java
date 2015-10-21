package systemCode;


public class Customer {
	public String name;
	public String address;
	
	public Customer(String Name, String Address){
		name = Name;
		address = Address;
	}
	
	public void createOrder(MenuItem item, String OrderType, String CustomerName){
		Order o = new Order(item, OrderType, CustomerName);
		dataStorage.currentOrders.add(o);
	}
}
