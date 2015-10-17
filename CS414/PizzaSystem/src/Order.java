import java.util.ArrayList;
import java.util.Scanner;


public class Order {
	Scanner input = new Scanner(System.in);
	public double totalCost;
	public orderStatus os;
	public ArrayList<MenuItem> orderContents = new ArrayList<MenuItem>();
	
	public Order(MenuItem item){
		totalCost = item.price;
		os = orderStatus.beingBuilt;
		orderContents.add(item);
	}
	
	public void addItem(MenuItem item){
		totalCost += item.price;
		orderContents.add(item);
	}
	
	public void removeItem(MenuItem item){
		totalCost -= item.price;
		orderContents.add(item);
	}
	
	// finish order take payment and send order
	// change print statements
	
	public void finish()
	{
		System.out.println("Enter payment type");
		System.out.print("Credit card\nCash");
		String s = input.next();
		if(s.equalsIgnoreCase("Credit card"))
		{
			System.out.println("Enter credit card number:");
			this.os = orderStatus.inProgress;
		}
		else
		{
			this.os = orderStatus.inProgress;
		}
	}
}
