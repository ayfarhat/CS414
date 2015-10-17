
public class Manager {
	public String name;
	public String id;
	private boolean menuCreated = false;
	//#####
	Menu menu;
	public Manager(String Name, String ID){
		name = Name;
		id = ID;
	}
	
	// I think we should return menu, so everyone can view it
	public void createMenu(String name){
		//TODO
		Menu menu = new Menu(name);
		menuCreated = true;
		this.menu = menu;
	}
	
	// added a category parameter
	public void createMenuItem(String name, double price, itemCategory category){
		if(menuCreated){
			//TODO
			MenuItem item = new MenuItem(price, name, category);
			// if the item does not already exist in the menu
			if(!menu.items.contains(item))
			menu.items.add(item);
		}
	}
	
	public void createDailySpecial(String name, double price){
		//TODO if statement, and there can be more than one dailyspecial
		if(menuCreated)
		{
			MenuItem item = new MenuItem(price, name, itemCategory.special);
			// if the item does not already exist in the menu
			if(!menu.items.contains(item))
			menu.items.add(item);
		}
	}
	
	public void changeItemPrice(int index, double price){
		//TODO index will be used to access menu item in menu
		MenuItem item = menu.items.get(index);
		item.price= price;
	}
	
	public void changeItemName(int index, String name){
		//TODO index will be used to access menu item in menu
		MenuItem item = menu.items.get(index);
		boolean exist = false;
		
		for(int i =0; i<menu.items.size(); i++)
		{
			MenuItem item2 = menu.items.get(i);
			if(item.equals(item2))
			{
				exist = true;
			}
		}
		if(!exist)
		{
			item.name = name;
		}
	}
}
