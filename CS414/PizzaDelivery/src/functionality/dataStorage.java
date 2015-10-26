package functionality;
import java.util.ArrayList;


public class dataStorage {
	public static ArrayList<Order> currentOrders = new ArrayList<Order>();
	public static Menu menu;
	public static ArrayList<Worker> workers = new ArrayList<Worker>();
	public static ArrayList<Customer> customers = new ArrayList<Customer>();
	public static Manager mananger = new Manager("Bob", "12345");
	
	public static Menu testMenu;
	
	public static void initializeTestMenu(){
		testMenu = new Menu("Test");
		testMenu.items.add(new MenuItem(1.0, "Cheese", itemCategory.pizza));
		testMenu.items.add(new MenuItem(1.0, "Pepperoni", itemCategory.pizza));
		testMenu.items.add(new MenuItem(1.0, "Sausage", itemCategory.pizza));
		testMenu.items.add(new MenuItem(1.0, "Hawaiian", itemCategory.special));
		testMenu.items.add(new MenuItem(1.0, "Coke", itemCategory.drinks));
		testMenu.items.add(new MenuItem(1.0, "Sprite", itemCategory.drinks));
		testMenu.items.add(new MenuItem(1.0, "Mr. Pibb", itemCategory.drinks));
		testMenu.items.add(new MenuItem(1.0, "Diet Coke", itemCategory.drinks));
		testMenu.items.add(new MenuItem(1.0, "Lemonade", itemCategory.drinks));
		testMenu.items.add(new MenuItem(1.0, "Knots", itemCategory.extras));
		testMenu.items.add(new MenuItem(1.0, "Breadsticks", itemCategory.extras));
		testMenu.items.add(new MenuItem(1.0, "Salad", itemCategory.extras));
		testMenu.items.add(new MenuItem(1.0, "Pasta", itemCategory.extras));
		testMenu.items.add(new MenuItem(1.0, "Cake", itemCategory.desserts));
		testMenu.items.add(new MenuItem(1.0, "Brownies", itemCategory.desserts));
	}
}
