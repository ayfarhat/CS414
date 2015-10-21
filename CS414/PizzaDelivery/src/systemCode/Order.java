package systemCode;

import java.util.ArrayList;
import java.util.Scanner;


public class Order {
	Scanner input = new Scanner(System.in);
	public String customerName;
	public String orderType;//Delivery or Pickup
	public double totalCost;
	public orderStatus os;
	public ArrayList<MenuItem> orderContents = new ArrayList<MenuItem>();
	
	public Order(MenuItem item, String OrderType, String CustomerName){
		totalCost = item.price;
		os = orderStatus.beingBuilt;
		orderContents.add(item);
		orderType = OrderType;
		customerName = CustomerName;
	}
	
	public void addItem(MenuItem item){
		totalCost += item.price;
		orderContents.add(item);
	}
	
	public void removeItem(MenuItem item){
		totalCost -= item.price;
		orderContents.add(item);
	}
	
	// finish order takes payment and send order
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
	// toString method used by chef to view order
	public String toString()
	{
		String s ="";
		for(int i =0; i<orderContents.size(); i++ )
		{
			MenuItem item = orderContents.get(i);
			s+= item.name +"\n";
		}
		return s;
		
	}
}
