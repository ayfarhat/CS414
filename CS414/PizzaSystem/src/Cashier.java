
public class Cashier extends Worker {

	public Cashier(String Name, String ID) {
		super(Name, ID);
		// TODO Auto-generated constructor stub
	}
	
	// added a parameter MenuItem based on Order constructor
	// We need to return the order so it can be accessed after creation
	public void createOrder(MenuItem item){
		//TODO
		Order o = new Order(item);
		//return o;
	}

}
