package functionality;

public class Cashier extends Worker {

	public Cashier(String Name, String ID) {
		super(Name, ID);
	}
	
	// added a parameter MenuItem based on Order constructor
	public void createOrder(MenuItem item, String OrderType, String CustomerName){
		Order o = new Order(item, OrderType, CustomerName);
		dataStorage.currentOrders.add(o);
	}

}
