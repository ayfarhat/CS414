package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;

import functionality.itemCategory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class CreateOrder extends JFrame {

	private JPanel contentPane;
	private JPanel lowerPane;
	private JPanel southPane;
	private JTextField textField;
	private JTextField textField_1;
	private int counter;
	static CreateOrder frame;
	
	public JPanel pizzaPanel;
	public JPanel specialsPanel;
	public JPanel drinksPanel;
	public JPanel dessertsPanel;
	public JPanel extrasPanel;
	public JPanel labelPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CreateOrder();
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
	public CreateOrder() {
		getContentPane().setLayout(new GridLayout(2,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 401);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		
		lowerPane = new JPanel();
		
		southPane = new JPanel();
		southPane.setLayout(new GridLayout(2,1));
		labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(1,5));
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(10, 26, 56, 26);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(67, 31, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCategory = new JLabel("Phone:");
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategory.setBounds(10, 79, 69, 20);
		contentPane.add(lblCategory);
		
		textField_1 = new JTextField();
		textField_1.setBounds(67, 81, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMenu.setBounds(215, 110, 46, 14);
		contentPane.add(lblMenu);
		
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
		
		specialsPanel.setBounds(100, 130, 100, 300);
		//contentPane.add(specialsPanel);
		
		JLabel lblNewLabel = new JLabel("Special");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//specialsPanel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.add(lblNewLabel);
		
		drinksPanel = new JPanel();
		drinksPanel.setBounds(200, 130, 100, 300);
		//contentPane.add(drinksPanel);
		
		
		JLabel lblDrinks = new JLabel("Drinks");
		lblDrinks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//drinksPanel.add(lblDrinks);
		lblDrinks.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.add(lblDrinks);
		
		extrasPanel = new JPanel();
		extrasPanel.setBounds(300, 130, 100, 300);
		
		//contentPane.add(extrasPanel);
		
		JLabel lblExtras = new JLabel("Extras");
		lblExtras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//extrasPanel.add(lblExtras);
		lblExtras.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.add(lblExtras);
		
		dessertsPanel = new JPanel();
		dessertsPanel.setBounds(400, 130, 100, 300);
		//contentPane.add(dessertsPanel);
		
		JLabel lblDessert = new JLabel("Dessert");
		lblDessert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//dessertsPanel.add(lblDessert);
		lblDessert.setHorizontalAlignment(JLabel.CENTER);
		labelPanel.add(lblDessert);
		
		JLabel lblItemsInCart = new JLabel("Items in Cart");
		lblItemsInCart.setBounds(379, 11, 93, 14);
		contentPane.add(lblItemsInCart);
		
		final JEditorPane itemCounter = new JEditorPane();
		itemCounter.setBounds(389, 26, 40, 20);

		contentPane.add(itemCounter);
		
		JButton btnCheckout = new JButton("Checkout");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewOrder checkout = new ViewOrder();
				checkout.setVisible(true);
				frame.dispose();
			}
		});
		btnCheckout.setBounds(383, 333, 89, 23);
		contentPane.add(btnCheckout);
		
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
		add(contentPane, BorderLayout.NORTH);
		southPane.add(labelPanel);
		southPane.add(lowerPane);
		
		add(southPane, BorderLayout.SOUTH);
//		
//		JLabel label = new JLabel("");
//		label.setBounds(331, 84, 46, 14);
//		contentPane.add(label);
		//contentPane.add(CreateMenu.newMenu.lowerPane);
		//contentPane.updateUI();
	}
	
	public void buildMenu(String menuName){
		//TODO add functionality to buttons
		System.out.println("Build menu called");
		if(menuName.equals("Test")){
			System.out.println("Inside test");
			ArrayList<functionality.MenuItem> items = functionality.dataStorage.menu.items;
			System.out.println(items.size());
			for(int i = 0; i<items.size(); i++){
				if(items.get(i).cat == itemCategory.pizza){
					pizzaPanel.add(new JButton(items.get(i).name));
				}else if(items.get(i).cat == itemCategory.drinks){
					drinksPanel.add(new JButton(items.get(i).name));
				}else if(items.get(i).cat == itemCategory.extras){
					extrasPanel.add(new JButton(items.get(i).name));
				}else if(items.get(i).cat == itemCategory.desserts){
					dessertsPanel.add(new JButton(items.get(i).name));
				}else if(items.get(i).cat == itemCategory.special){
					specialsPanel.add(new JButton(items.get(i).name));
				}
			}
			contentPane.updateUI();
		}
	}

}
