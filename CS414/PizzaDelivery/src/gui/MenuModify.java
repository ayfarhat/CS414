package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.GridBagLayout;

//import MenuModify.MenuHandler;



import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.FlowLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JEditorPane;
import javax.swing.JButton;









import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import functionality.Manager;
import functionality.MenuItem;
import functionality.dataStorage;
import functionality.itemCategory;


public class MenuModify extends JFrame {
	private JPanel contentPane;
	public static JPanel lowerPane;
	//private JPanel buttonMenu;
	private JLabel lblMenuTitle;
	public ArrayList<MenuItem> pizza = new ArrayList<MenuItem>();
	public ArrayList<MenuItem> specials = new ArrayList<MenuItem>();
	public ArrayList<MenuItem> extras = new ArrayList<MenuItem>();
	public ArrayList<MenuItem> drinks = new ArrayList<MenuItem>();
	public ArrayList<MenuItem> desserts = new ArrayList<MenuItem>();
	public ArrayList<JButton> buttons = new ArrayList<JButton>();
	public JPanel pizzaPanel;
	public JPanel specialsPanel;
	public JPanel drinksPanel;
	public JPanel dessertsPanel;
	public JPanel extrasPanel;
	public JPanel labelPanel;
	public boolean addMenuItem = false;
	int pizzaCount = 0;
	int specialsCount = 0;
	int drinksCount = 0;
	int dessertsCount = 0;
	int extrasCount = 0;
	static MenuModify frame;
	private JTextField name;
	private JTextField price;
	JComboBox comboBox;
	JButton backButton; 
	JButton btnAddNewMenu;
	JTextField itemName;
	JTextField itemPrice;
	JTextField itemCat;
	JButton pressed;
	int index =0;
	JFrame frameModify;
	private JPanel southPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MenuModify();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuModify() {
		//frame = new MenuModify();
		//frame.setVisible(true);
		System.out.println("MenuModify top");
		getContentPane().setLayout(new GridLayout(2,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 401);
		contentPane = new JPanel();
		lowerPane = new JPanel();
		pizzaPanel = new JPanel();
		pizzaPanel.setLayout(new GridLayout(0,1));
		specialsPanel = new JPanel();
		specialsPanel.setLayout(new GridLayout(0,1));
		drinksPanel = new JPanel();
		drinksPanel.setLayout(new GridLayout(0,1));
		extrasPanel = new JPanel();
		extrasPanel.setLayout(new GridLayout(0,1));
		dessertsPanel = new JPanel();
		dessertsPanel.setLayout(new GridLayout(0,1));

		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 61, 46, 14);
		contentPane.add(lblName);

		name = new JTextField();
		name.setBounds(80, 58, 86, 20);
		contentPane.add(name);
		name.setColumns(10);

		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(10, 89, 46, 14);
		contentPane.add(lblPrice);

		price = new JTextField();
		price.setBounds(80, 86, 86, 20);
		contentPane.add(price);
		price.setColumns(10);

		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(10, 114, 64, 14);
		contentPane.add(lblCategory);

		comboBox = new JComboBox(itemCategory.values());
		comboBox.setBounds(80, 117, 86, 20);
		contentPane.add(comboBox);

		backButton = new JButton("Submit");


		MenuHandler handler = new MenuHandler();
		btnAddNewMenu = new JButton("Add New Menu Item");
		btnAddNewMenu.setBounds(10, 80, 144, 23);
		btnAddNewMenu.addActionListener(handler);
		backButton.addActionListener(handler);
		/*btnAddNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMenuItem = true;
				//System.out.println(addMenuItem);
				//newMenu = new NewMenuItem();

				//newMenu.setVisible(true);

				//System.out.println(addMenuItem);
				///////////////Issue with count of items//////////////////	
				String n = name.getText();
				String p = price.getText();

				if(n.isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter an item name");
				}

				else if(p.isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter an item price");
				}

				else if(p.equals("0"))
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter an item price");
				}
				else
				{
					int value = Integer.parseInt(price.getText());
					dataStorage.mananger.createMenuItem(n, value, (itemCategory) comboBox.getSelectedItem()); 
				}
				updatePanels();
			}

		});*/

		//contentPane.setLayout(new GridLayout(2,1));
		contentPane.setLayout(new BorderLayout());
		
		JLabel lblPizza = new JLabel("Pizza");
		JLabel lblNewLabel = new JLabel("Special");
		JLabel lblDrinks = new JLabel("Drinks");
		JLabel lblExtras = new JLabel("Extras");
		JLabel lblDessert = new JLabel("Dessert");
		labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(1,5));
		lblPizza.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.add(lblPizza);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.add(lblNewLabel);
		lblDrinks.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.add(lblDrinks);
		lblExtras.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.add(lblExtras);
		lblDessert.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.add(lblDessert);

		
		southPane = new JPanel();
		southPane.setLayout(new GridLayout(2,1));
		
		//contentPane.add(btnAddNewMenu,BorderLayout.SOUTH);
		//contentPane.add(backButton,BorderLayout.EAST);
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1,2));
		buttons.add(btnAddNewMenu);
		buttons.add(backButton);
		contentPane.add(buttons,BorderLayout.SOUTH);
		lowerPane.setLayout(new GridLayout(1, 5));
		//lowerPane.setLocation();
		//add(contentPane);
		lowerPane.add(pizzaPanel);
		lowerPane.add(specialsPanel);
		lowerPane.add(drinksPanel);
		lowerPane.add(extrasPanel);
		lowerPane.add(dessertsPanel);
		add(contentPane, BorderLayout.NORTH);
		//add(lowerPane,BorderLayout.SOUTH);
		southPane.add(labelPanel);
		southPane.add(lowerPane);
		
		add(southPane, BorderLayout.SOUTH);
		
		//getContentPane().add(lowerPane,BorderLayout.SOUTH);


		//contentPane.add(lowerPane,GridLayout());
		//contentPane.add(pizzaPanel);


	}
	public void setMyTitle(String title){

		lblMenuTitle = new JLabel(title);
		lblMenuTitle.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMenuTitle.setBounds(185, 11, 129, 38);
		contentPane.add(lblMenuTitle,BorderLayout.NORTH);
	}
/*	public void updatePanels(){
		//if(newMenu.getSizeofItems() > 0){
		System.out.println("inside");
		if (pizzaPanel.getComponentCount() == 0){
			pizzaPanel.add(new JLabel("Pizza: "));
		}
		if (specialsPanel.getComponentCount() == 0){
			specialsPanel.add(new JLabel("Specials: "));
		}
		if (drinksPanel.getComponentCount() == 0){
			drinksPanel.add(new JLabel("Drinks: "));
		}
		if (extrasPanel.getComponentCount() == 0){
			extrasPanel.add(new JLabel("Extras: "));
		}
		if (dessertsPanel.getComponentCount() == 0){
			dessertsPanel.add(new JLabel("Desserts: "));
		}
		int n = dataStorage.menu.items.size();

		for(int i = 0; i < n; i++){
			itemCategory category = dataStorage.menu.items.get(i).cat;
			if(category.equals(itemCategory.pizza)){
				if(!pizza.contains(dataStorage.menu.items.get(i)))
				{
					pizza.add(dataStorage.menu.items.get(i));
					System.out.println("adding" + dataStorage.menu.items.get(i).name);
				}
			}
			else if(category.equals(itemCategory.special)){
				if(!specials.contains(dataStorage.menu.items.get(i)))
				{
					specials.add(dataStorage.menu.items.get(i));
					System.out.println("adding" + dataStorage.menu.items.get(i).name);
				}
			}
			else if(category.equals(itemCategory.drinks)){
				if(!drinks.contains(dataStorage.menu.items.get(i)))
				{
					drinks.add(dataStorage.menu.items.get(i));
					System.out.println("adding" + dataStorage.menu.items.get(i).name);
				}
			}
			else if(category.equals(itemCategory.extras)){
				if(!extras.contains(dataStorage.menu.items.get(i)))
				{
					extras.add(dataStorage.menu.items.get(i));
					System.out.println("adding" + dataStorage.menu.items.get(i).name);
				}
			}
			else if(category.equals(itemCategory.desserts)){
				if(!desserts.contains(dataStorage.menu.items.get(i)))
				{
					desserts.add(dataStorage.menu.items.get(i));
					System.out.println("adding" + dataStorage.menu.items.get(i).name);
				}
			}

			//}
			//lowerPane.removeAll();
			if(pizza.size() > pizzaCount){
				String name = pizza.get(pizza.size() -1).name;
				JButton b = new JButton(name);
				pizzaCount++;
				pizzaPanel.add(b);
				pizzaPanel.updateUI();
			}
			if(specials.size() > specialsCount){
				String name = specials.get(specials.size() - 1).name;
				JButton b = new JButton(name);
				specialsCount++;
				specialsPanel.add(b);
				specialsPanel.updateUI();
			}
			if(drinks.size() > drinksCount){
				String name = drinks.get(drinks.size() - 1).name;
				JButton b = new JButton(name);
				drinksCount++;
				drinksPanel.add(b);
				drinksPanel.updateUI();
			}
			if(extras.size() > extrasCount){
				String name = extras.get(extras.size() - 1).name;
				JButton b = new JButton(name);
				extrasCount++;
				extrasPanel.add(b);
				extrasPanel.updateUI();
			}
			if(desserts.size() > dessertsCount){
				String name = desserts.get(desserts.size() - 1).name;
				JButton b = new JButton(name);
				dessertsCount++;
				dessertsPanel.add(b);
				dessertsPanel.updateUI();
			}

		}

	}*/

	public class MenuHandler implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			Object source = event.getSource();

			if(source ==  btnAddNewMenu)
			{
				addMenuItem = true;
				//System.out.println(addMenuItem);
				//newMenu = new NewMenuItem();

				//newMenu.setVisible(true);

				//System.out.println(addMenuItem);
				///////////////Issue with count of items//////////////////	
				String n = name.getText();
				String p = price.getText();

				if(n.isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter an item name");
				}

				else if(p.isEmpty())
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter an item price");
				}

				else if(p.equals("0"))
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please enter an item price");
				}
				else
				{
					double value = Double.parseDouble((price.getText()));
					dataStorage.mananger.createMenuItem(n, value, (itemCategory) comboBox.getSelectedItem()); 
				}

				/*if (pizzaPanel.getComponentCount() == 0){
					pizzaPanel.add(new JLabel("Pizza: "));
				}
				if (specialsPanel.getComponentCount() == 0){
					specialsPanel.add(new JLabel("Specials: "));
				}
				if (drinksPanel.getComponentCount() == 0){
					drinksPanel.add(new JLabel("Drinks: "));
				}
				if (extrasPanel.getComponentCount() == 0){
					extrasPanel.add(new JLabel("Extras: "));
				}
				if (dessertsPanel.getComponentCount() == 0){
					dessertsPanel.add(new JLabel("Desserts: "));
				}*/
				int m = dataStorage.menu.items.size();

				for(int i = 0; i < m; i++){
					itemCategory category = dataStorage.menu.items.get(i).cat;
					if(category.equals(itemCategory.pizza)){
						if(!pizza.contains(dataStorage.menu.items.get(i)))
						{
							pizza.add(dataStorage.menu.items.get(i));
							System.out.println("adding" + dataStorage.menu.items.get(i).name);
						}
					}
					else if(category.equals(itemCategory.special)){
						if(!specials.contains(dataStorage.menu.items.get(i)))
						{
							specials.add(dataStorage.menu.items.get(i));
							System.out.println("adding" + dataStorage.menu.items.get(i).name);
						}
					}
					else if(category.equals(itemCategory.drinks)){
						if(!drinks.contains(dataStorage.menu.items.get(i)))
						{
							drinks.add(dataStorage.menu.items.get(i));
							System.out.println("adding" + dataStorage.menu.items.get(i).name);
						}
					}
					else if(category.equals(itemCategory.extras)){
						if(!extras.contains(dataStorage.menu.items.get(i)))
						{
							extras.add(dataStorage.menu.items.get(i));
							System.out.println("adding" + dataStorage.menu.items.get(i).name);
						}
					}
					else if(category.equals(itemCategory.desserts)){
						if(!desserts.contains(dataStorage.menu.items.get(i)))
						{
							desserts.add(dataStorage.menu.items.get(i));
							System.out.println("adding" + dataStorage.menu.items.get(i).name);
						}
					}

					//}
					//lowerPane.removeAll();
					if(pizza.size() > pizzaCount){
						String name = pizza.get(pizza.size() -1).name;
						JButton b = new JButton(name);
						buttons.add(b);
						b.addActionListener(this);
						System.out.print(buttons.contains(b));
						pizzaCount++;
						pizzaPanel.add(b);
						pizzaPanel.updateUI();
					}
					if(specials.size() > specialsCount){
						String name = specials.get(specials.size() - 1).name;
						JButton b = new JButton(name);
						specialsCount++;
						specialsPanel.add(b);
						specialsPanel.updateUI();
					}
					if(drinks.size() > drinksCount){
						String name = drinks.get(drinks.size() - 1).name;
						JButton b = new JButton(name);
						drinksCount++;
						drinksPanel.add(b);
						drinksPanel.updateUI();
					}
					if(extras.size() > extrasCount){
						String name = extras.get(extras.size() - 1).name;
						JButton b = new JButton(name);
						extrasCount++;
						extrasPanel.add(b);
						extrasPanel.updateUI();
					}
					if(desserts.size() > dessertsCount){
						String name = desserts.get(desserts.size() - 1).name;
						JButton b = new JButton(name);
						dessertsCount++;
						dessertsPanel.add(b);
						dessertsPanel.updateUI();
					}

				}

				name.setText("");
				price.setText("");
			}
			if(source ==  backButton)
			{
				PizzaDeliverGUI.manager.setVisible(true);
				//dispose();
				//setVisible(false);
			}
			if(buttons.contains(source))
			{

				pressed = (JButton) source;
				String name = pressed.getText();
				double price = 0;
				String cat = "";
				for (int i =0; i<dataStorage.menu.items.size(); i++)
				{
					if(dataStorage.menu.items.get(i).name.equals(name));
					{
						index = i;
						price = (double)dataStorage.menu.items.get(i).price;
						cat = dataStorage.menu.items.get(i).cat.name();
					}
				}
				frameModify = new JFrame();
				frameModify.setLayout(new GridLayout(2,1));
				JLabel lblname = new JLabel("Name:");
				JLabel lblprice = new JLabel("Price");
				JLabel lblcat = new JLabel("Category");
				itemName = new JTextField(name);
				itemPrice = new JTextField(""+price);
				itemCat = new JTextField(cat);

				JPanel panel = new JPanel();
				panel.setLayout(new GridLayout(3,2));
				panel.add(lblname);
				panel.add(itemName);
				panel.add(lblprice);
				panel.add(itemPrice);
				panel.add(lblcat);
				panel.add(itemCat);
				frameModify.setBounds(100, 100, 485, 401);
				frameModify.add(panel);

				JButton save = new JButton("save");
				frameModify.add(save);

				frameModify.setVisible(true);
				save.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println(pressed.getText());
						String name = itemName.getText();
						double price = Double.parseDouble(itemPrice.getText());
						String cat = itemCat.getText();
						//int p = buttons.indexOf(pressed);
						//pressed.setName(name);
						
						//pressed.setName("test");
						pressed.setText(name);
						//pizzaPanel.remove(pressed);
						
						dataStorage.mananger.changeItemName(index, name);
						dataStorage.mananger.changeItemPrice(index, price);
						System.out.print(buttons.get(index).getName());
						
						frameModify.dispose();





					}});



			}
		}
	}
}
