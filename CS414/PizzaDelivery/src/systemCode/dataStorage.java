package systemCode;

import java.util.ArrayList;


public class dataStorage {
	public static ArrayList<Order> currentOrders = new ArrayList<Order>();
	public static Menu menu;
	public static ArrayList<Worker> workers = new ArrayList<Worker>();
	public static ArrayList<Customer> customers = new ArrayList<Customer>();
	public static Manager maanger = new Manager("Bob", "12345");
}
