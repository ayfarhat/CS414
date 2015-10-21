import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.GridBagLayout;

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

import systemCode.Manager;
import systemCode.MenuItem;
import systemCode.dataStorage;
import systemCode.itemCategory;


public class MenuModify extends JFrame {

	private JPanel contentPane;
	private JPanel lowerPane;
	private JPanel buttonMenu;
	private JLabel lblMenuTitle;
	public ArrayList<MenuItem> pizza = new ArrayList<MenuItem>();
	public ArrayList<MenuItem> specials = new ArrayList<MenuItem>();
	public ArrayList<MenuItem> extras = new ArrayList<MenuItem>();
	public ArrayList<MenuItem> drinks = new ArrayList<MenuItem>();
	public ArrayList<MenuItem> desserts = new ArrayList<MenuItem>();
	public JPanel pizzaPanel;
	public boolean addMenuItem = false;
	NewMenuItem newMenu;
	static MenuModify frame;

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
		setLayout(new GridLayout(2,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 401);
		contentPane = new JPanel();
		lowerPane = new JPanel();
		lowerPane.setLayout(new FlowLayout());
		buttonMenu = new JPanel();
		buttonMenu.setLayout(new GridLayout(0,5));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnAddNewMenu = new JButton("Add New Menu Item");
		btnAddNewMenu.setBounds(10, 80, 144, 23);
		btnAddNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMenuItem = true;
				System.out.println(addMenuItem);
				newMenu = new NewMenuItem();

				newMenu.setVisible(true);

				//System.out.println(addMenuItem);
				///////////////Issue with count of items//////////////////			
				if(newMenu.getSizeofItems() >= 0){
					System.out.println(newMenu.getSizeofItems());
					int n = dataStorage.menu.items.size();
					System.out.println(n);
					for(int i = 0; i < n; i++){
						itemCategory category = dataStorage.menu.items.get(i).cat;
						if(category.equals(itemCategory.pizza)){
							pizza.add(dataStorage.menu.items.get(i));
						}
						else if(category.equals(itemCategory.special)){
							specials.add(dataStorage.menu.items.get(i));
						}
						else if(category.equals(itemCategory.drinks)){
							drinks.add(dataStorage.menu.items.get(i));
						}
						else if(category.equals(itemCategory.extras)){
							extras.add(dataStorage.menu.items.get(i));
						}
						else if(category.equals(itemCategory.desserts)){
							desserts.add(dataStorage.menu.items.get(i));
						}

					}
					if(pizza.size() != 0){
						
						pizzaPanel = new JPanel(new GridLayout(pizza.size(),1));
						for(int i = 0; i < pizza.size(); i++){
							System.out.println("in pizza");
							
							//pizzaPanel.add(new JButton(pizza.get(i).name));
							//pizzaPanel.setBounds(127, 230, 58, 51);
							buttonMenu.add(new JButton(pizza.get(i).name));
							lowerPane.updateUI();
						}
					}
					else if(specials.size() != 0){

					}
					else if(drinks.size() != 0){

					}
					else if(extras.size() != 0){

					}
					else if(desserts.size() != 0){

					}

				}

			}

		});

		contentPane.setLayout(new GridLayout(2,1));
		
		contentPane.add(btnAddNewMenu);
		//add(contentPane);
		lowerPane.add(buttonMenu);
		add(lowerPane);
		
		
		//contentPane.add(lowerPane,GridLayout());
		//contentPane.add(pizzaPanel);
		
		
	}
	public void setMyTitle(String title){
		System.out.println(title);
		lblMenuTitle = new JLabel(title);
		lblMenuTitle.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMenuTitle.setBounds(185, 11, 129, 38);
		contentPane.add(lblMenuTitle);
	}
}
