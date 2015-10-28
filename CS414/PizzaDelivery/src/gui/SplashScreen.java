package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class SplashScreen extends JFrame {

	private JPanel contentPane;
	static SplashScreen splash;
	static PizzaDeliverGUI employeeLogin;
	static CustomerPage customer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					splash = new SplashScreen();
					splash.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to Pizza City! \r\n");
		lblWelcome.setBounds(131, 11, 344, 94);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 31));
		contentPane.add(lblWelcome);
		
		JLabel lblWeHaveThe = new JLabel("We have the best pizza in town!");
		lblWeHaveThe.setBounds(148, 86, 293, 42);
		lblWeHaveThe.setFont(new Font("Tahoma", Font.PLAIN, 19));
		contentPane.add(lblWeHaveThe);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customer = new CustomerPage();
				customer.setVisible(true); 
				setVisible(false);
			}
		});
		btnCustomer.setBounds(220, 320, 139, 23);
		btnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnCustomer);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeeLogin = new PizzaDeliverGUI();
				employeeLogin.setVisible(true);
				setVisible(false);
			}
		});
		btnEmployee.setBounds(220, 378, 139, 23);
		btnEmployee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnEmployee);
		
		JLabel lblWouldYouLike = new JLabel("Would you like to enter as a customer or employee?");
		lblWouldYouLike.setBounds(102, 272, 411, 23);
		lblWouldYouLike.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(lblWouldYouLike);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shannon\\Documents\\CS414\\chicago-pizza-city.jpg"));
		lblNewLabel.setBounds(42, 454, 500, 115);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Shannon\\Documents\\CS414\\pizza-city.jpg"));
		lblNewLabel_1.setBounds(202, 116, 196, 120);
		contentPane.add(lblNewLabel_1);
	}

}