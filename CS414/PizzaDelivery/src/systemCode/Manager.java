package systemCode;


public class Manager {
	public String name;
	public String id;
	private boolean menuCreated = false;
	//#####
	
	public Manager(String Name, String ID){
		name = Name;
		id = ID;
	}
	
	public void createWorker(String workerName, String workerID, String workerType){
		if(workerType.equals("Cashier")){
			dataStorage.workers.add(new Cashier(workerName, workerID));
		}else if(workerType.equals("Chef")){
			dataStorage.workers.add(new Chef(workerName, workerID));
		}
	}
	
	public void createMenu(String name){
		dataStorage.menu = new Menu(name);
		menuCreated = true;
	}
	
	// added a category parameter
	public void createMenuItem(String name, double price, itemCategory category){
		if(menuCreated){
			//TODO
			MenuItem item = new MenuItem(price, name, category);
			// if the item does not already exist in the menu
			if(!dataStorage.menu.items.contains(item)){
				dataStorage.menu.items.add(item);
			}
		}
	}
	
	public void createDailySpecial(String name, double price){
		if(menuCreated)
		{
			MenuItem item = new MenuItem(price, name, itemCategory.special);
			// if the item does not already exist in the menu
			if(!dataStorage.menu.items.contains(item))
				dataStorage.menu.items.add(item);
		}
	}
	
	public void changeItemPrice(int index, double price){
		if(menuCreated){
			if(index < dataStorage.menu.items.size()){
				dataStorage.menu.items.get(index).price = price;
			}
		}
	}
	
	public void changeItemName(int index, String name){
		//TODO index will be used to access menu item in menu
		if(menuCreated){
			if(index < dataStorage.menu.items.size()){//make sure it's a valid index
				MenuItem item = dataStorage.menu.items.get(index);
				MenuItem temp = item;
				temp.name = name;
				if(!dataStorage.menu.items.contains(temp)){
					dataStorage.menu.items.get(index).name = name;
				}
			}
		}
	}
}
