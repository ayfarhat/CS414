package functionality;
import java.util.ArrayList;


public class Menu {
	String name;
	public ArrayList<MenuItem> items = new ArrayList<MenuItem>();
	
	//##############
	public Menu(String name)
	{
		this.name = name;
	}
	//#################
	ArrayList<MenuItem> viewMenu()
	{
		return items;
	}

}
