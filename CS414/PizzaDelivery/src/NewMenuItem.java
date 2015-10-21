import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import systemCode.Manager;
import systemCode.MenuItem;
import systemCode.dataStorage;
import systemCode.itemCategory;


public class NewMenuItem extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField price;
	JComboBox comboBox;
	static NewMenuItem frame;
	private String nameString, priceString, categoryString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new NewMenuItem();
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
	public NewMenuItem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JButton btnAddItem = new JButton("Add Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					
					// the manager has to create the item
					
					dataStorage.maanger.createMenuItem(n, value, (itemCategory) comboBox.getSelectedItem()); 
					//System.out.println(dataStorage.menu.items.size());
					//MenuModify menu = new MenuModify();
					//menu.setVisible(true);
					dispose();
					
				}
				
			}
		});
		btnAddItem.setBounds(77, 153, 89, 23);
		contentPane.add(btnAddItem);
		
	}
	public int getSizeofItems(){
		int size = dataStorage.menu.items.size();
		return size;
	}

}

