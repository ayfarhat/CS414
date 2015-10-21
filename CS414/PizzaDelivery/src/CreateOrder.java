import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CreateOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private int counter;
	static CreateOrder frame;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		lblMenu.setBounds(215, 123, 46, 14);
		contentPane.add(lblMenu);
		
		JLabel lblPizza = new JLabel("Pizza");
		lblPizza.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPizza.setBounds(38, 166, 46, 14);
		contentPane.add(lblPizza);
		
		JLabel lblNewLabel = new JLabel("Daily Special");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(38, 265, 86, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblDessert = new JLabel("Dessert");
		lblDessert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDessert.setBounds(331, 166, 46, 14);
		contentPane.add(lblDessert);
		
		JLabel lblDrinks = new JLabel("Drinks");
		lblDrinks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDrinks.setBounds(181, 166, 46, 14);
		contentPane.add(lblDrinks);
		
		JLabel lblExtras = new JLabel("Extras");
		lblExtras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblExtras.setBounds(181, 264, 46, 14);
		contentPane.add(lblExtras);
		
		
		
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
		
		
//		
//		JLabel label = new JLabel("");
//		label.setBounds(331, 84, 46, 14);
//		contentPane.add(label);
	}

}
