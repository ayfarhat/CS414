
public class Chef extends Worker {

	public Chef(String Name, String ID) {
		super(Name, ID);
	}

	public Order viewOrder(int orderID){
		return dataStorage.currentOrders.get(orderID);
	}
	
	public void completeOrder(int orderID){
		dataStorage.currentOrders.get(orderID).os = orderStatus.completed;
	}
}
