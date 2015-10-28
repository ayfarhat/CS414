package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;

import functionality.dataStorage;
import functionality.itemCategory;
import gui.MenuModify.MenuHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.FlowLayout;

import javax.swing.JRadioButton;


public class CreateOrder extends JFrame {

	private JPanel contentPane;
	private JPanel lowerPane;
	private JPanel southPane;
	private int counter;
	static CreateOrder frame;
	
	JRadioButton rdbtnDelivery;
	JRadioButton rdbtnTakeout;
	
	public JPanel pizzaPanel;
	public JPanel specialsPanel;
	public JPanel drinksPanel;
	public JPanel dessertsPanel;
	public JPanel extrasPanel;
	public JPanel labelPanel;
	private JLabel lblName;
	public static JTextField nameField;
	private JLabel lblOrderType;
	private static JTextField addressField;
	private JButton btnCheckout;
	private JLabel lblPhone;
	private JTextField phoneField;
	private JButton btnCancel;
	private MenuHandler handler;
	public static functionality.Order order;

	
	public static boolean orderCreated;


	/**
	 * Create the frame.
	 */
	public CreateOrder() {
		orderCreated = false;
		getContentPane().setLayout(new GridLayout(2,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 607);
		contentPane = new JPanel();
		//contentPane.setBounds(0,0, 607, 200);
		
		handler = new MenuHandler();
		
		lowerPane = new JPanel();
		
		southPane = new JPanel();
		//southPane.setBounds(0,210,607,407);
		southPane.setLayout(new GridLayout(2,1));
		labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(1,5));
		
		pizzaPanel = new JPanel();
		pizzaPanel.setBounds(0, 70, 100, 300);
		pizzaPanel.setLayout(new GridLayout(0,1));
		//contentPane.add(pizzaPanel);
		
		JLabel lblPizza = new JLabel("Pizza");
		lblPizza.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//pizzaPanel.add(lblPizza);
		lblPizza.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.add(lblPizza);
		specialsPanel = new JPanel();
		specialsPanel.setLayout(new GridLayout(0,1));
		
		specialsPanel.setBounds(100, 130, 100, 300);
		//contentPane.add(specialsPanel);
		
		JLabel lblNewLabel = new JLabel("Special");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//specialsPanel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.add(lblNewLabel);
		
		drinksPanel = new JPanel();
		drinksPanel.setBounds(200, 130, 100, 300);
		drinksPanel.setLayout(new GridLayout(0,1));
		//contentPane.add(drinksPanel);
		
		
		JLabel lblDrinks = new JLabel("Drinks");
		lblDrinks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//drinksPanel.add(lblDrinks);
		lblDrinks.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.add(lblDrinks);
		
		extrasPanel = new JPanel();
		extrasPanel.setBounds(300, 130, 100, 300);
		extrasPanel.setLayout(new GridLayout(0,1));
		
		//contentPane.add(extrasPanel);
		
		JLabel lblExtras = new JLabel("Extras");
		lblExtras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//extrasPanel.add(lblExtras);
		lblExtras.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.add(lblExtras);
		
		dessertsPanel = new JPanel();
		dessertsPanel.setBounds(400, 130, 100, 300);
		dessertsPanel.setLayout(new GridLayout(0,1));
		//contentPane.add(dessertsPanel);
		
		JLabel lblDessert = new JLabel("Dessert");
		lblDessert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//dessertsPanel.add(lblDessert);
		lblDessert.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.add(lblDessert);
		
		JLabel lblItemsInCart = new JLabel("Items in Cart");
		lblItemsInCart.setBounds(379, 11, 93, 14);
		contentPane.add(lblItemsInCart);
		
		lowerPane.setLayout(new GridLayout(1, 5));
		//lowerPane.setLocation();
		//add(contentPane);
		//lowerPane.add(labelPanel);
		lowerPane.add(pizzaPanel);
		lowerPane.add(specialsPanel);
		lowerPane.add(drinksPanel);
		lowerPane.add(extrasPanel);
		lowerPane.add(dessertsPanel);
		
		//for testing purposes
		functionality.dataStorage.initializeTestMenu();
		buildMenu("Test");
		getContentPane().add(contentPane, BorderLayout.NORTH);
		contentPane.setLayout(null);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(10, 23, 100, 14);
		contentPane.add(lblName);
		
		nameField = new JTextField();
		nameField.setBounds(110, 20, 155, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		lblOrderType = new JLabel("Order Type");
		lblOrderType.setBounds(10, 72, 100, 14);
		contentPane.add(lblOrderType);
		
		rdbtnDelivery = new JRadioButton("Delivery");
		rdbtnDelivery.setBounds(28, 91, 100, 23);
		contentPane.add(rdbtnDelivery);
		
		rdbtnTakeout = new JRadioButton("Takeout");
		rdbtnTakeout.setSelected(true);
		rdbtnTakeout.setBounds(130, 91, 100, 23);
		contentPane.add(rdbtnTakeout);
		
		 ButtonGroup group = new ButtonGroup();
		 group.add(rdbtnDelivery);
		 group.add(rdbtnTakeout);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 121, 100, 14);
		contentPane.add(lblAddress);
		
		addressField = new JTextField();
		addressField.setBounds(110, 121, 284, 20);
		contentPane.add(addressField);
		addressField.setColumns(10);
		
		btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(370, 147, 100, 23);
		contentPane.add(btnCheckout);
		btnCheckout.addActionListener(handler);
		
		lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(10, 48, 100, 14);
		contentPane.add(lblPhone);
		
		phoneField = new JTextField();
		phoneField.setBounds(110, 48, 103, 20);
		contentPane.add(phoneField);
		phoneField.setColumns(10);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(handler);
		btnCancel.setBounds(10, 147, 100, 23);
		contentPane.add(btnCancel);
		southPane.add(labelPanel);
		southPane.add(lowerPane);
		
		getContentPane().add(southPane, BorderLayout.SOUTH);

	}
	
	public void buildMenu(String menuName){
		//TODO add functionality to buttons
		System.out.println("Build menu called");
		if(menuName.equals("Test")){
			System.out.println("Inside test");
			ArrayList<functionality.MenuItem> items = functionality.dataStorage.testMenu.items;
			System.out.println(items.size());
			for(int i = 0; i<items.size(); i++){
				JButton tempButton;
				if(items.get(i).cat == itemCategory.pizza){
					tempButton = new JButton(items.get(i).name);
					pizzaPanel.add(tempButton);
				}else if(items.get(i).cat == itemCategory.drinks){
					tempButton = new JButton(items.get(i).name);
					drinksPanel.add(tempButton);
				}else if(items.get(i).cat == itemCategory.extras){
					tempButton = new JButton(items.get(i).name);
					extrasPanel.add(tempButton);
				}else if(items.get(i).cat == itemCategory.desserts){
					tempButton = new JButton(items.get(i).name);
					dessertsPanel.add(tempButton);
				}else{//has to be special
					tempButton = new JButton(items.get(i).name);
					specialsPanel.add(tempButton);
				}
				tempButton.addActionListener(handler);
			}
			contentPane.updateUI();
		}
	}
	public class MenuHandler implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			Object source = event.getSource();

			if(source ==  btnCheckout)
			{
				if(orderCreated){
					
					CheckOut checkout = new CheckOut(order);
					setVisible(false);
					checkout.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please add items to your order");
				}
			}else if(source == btnCancel){
				
				//orderCreated = false;
				SplashScreen.employeeLogin.cashier.setVisible(true);
				dispose();
			}else{//some item button pressed
				
				if(!nameField.getText().isEmpty())
				{
					
					if(orderCreated == false)
					{
						JButton pressed = (JButton)source;
						functionality.MenuItem item = findMenuItemByName(pressed.getText());
						if(rdbtnDelivery.isSelected())
						{
							
							
							if(!addressField.getText().isEmpty())
							{
								dataStorage.cashier.createOrder(item, "Takeout", nameField.getText());
								order = dataStorage.currentOrders.get(dataStorage.currentOrders.size()-1);
								//order = new functionality.Order(item, "Delivery", nameField.getText());
								orderCreated = true;
							}
							else
							{
								JOptionPane.showMessageDialog(new JFrame(), "Please enter a delivery address");
							}
							
						}
						else if(rdbtnTakeout.isSelected())
						{
							
							dataStorage.cashier.createOrder(item, "Takeout", nameField.getText());
							order = dataStorage.currentOrders.get(dataStorage.currentOrders.size()-1);
							//order = new functionality.Order(item, "Takeout", nameField.getText());
							
							orderCreated = true;
						}
					}
					else
					{//order already exists, add to order
						
						JButton pressed = (JButton)source;
						functionality.MenuItem item = findMenuItemByName(pressed.getText());
						order.addItem(item);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please a name to start your order");
				}
			}
		}
	}
	
	public functionality.MenuItem findMenuItemByName(String name){//change back to menu
		for(functionality.MenuItem item : functionality.dataStorage.testMenu.items){
			if(item.name.equals(name)){
				return item;
			}
		}
		return null;
	}
}