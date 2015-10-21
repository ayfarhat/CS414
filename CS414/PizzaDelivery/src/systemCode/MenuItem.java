package systemCode;


public class MenuItem {
	public double price;
	public String name;
	public itemCategory cat;
	
	public MenuItem(double Price, String Name, itemCategory Cat){
		price = Price;
		name = Name;
		cat = Cat;
	}
	//#######
	public boolean equals(Object o)
	{
		if (!o.getClass().equals(this.getClass()))
		{
			return false;
		}
		MenuItem item = (MenuItem) o;
		if(item.name.equals(this.name))
		{
			return true;
		}
		else return false;
	}
}
