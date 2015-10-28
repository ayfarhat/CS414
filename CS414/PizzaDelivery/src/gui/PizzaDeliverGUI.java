package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PizzaDeliverGUI extends JFrame {

	private JPanel contentPane;
	private JTextField codeInput;
	JLabel lblPleaseEnterYour;
	static PizzaDeliverGUI login;
	String managerID,chefID,cashierID;
	boolean access = false;
	public static ManagerPage manager;
	public static CashierPage cashier;
	public static ChefPage chef;


	/**
	 * Create the frame.
	 */
	public PizzaDeliverGUI() {
		managerID = "1111";
		chefID = "2222";
		cashierID = "3333";
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Employee Login\r\n");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(157, 11, 174, 54);
		contentPane.add(lblLogin);
		
		JLabel lblPleaseSelectYour = new JLabel("Please Select Your Position");
		lblPleaseSelectYour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPleaseSelectYour.setBounds(146, 62, 174, 20);
		contentPane.add(lblPleaseSelectYour);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Manager", "Cashier", "Chef"}));
		comboBox.setBounds(173, 93, 94, 20);
		contentPane.add(comboBox);
		
		lblPleaseEnterYour = new JLabel("Please Enter Your Employee Code");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPleaseEnterYour.setBounds(133, 145, 219, 20);
		contentPane.add(lblPleaseEnterYour);
		
		codeInput = new JTextField();
		codeInput.setBounds(181, 170, 86, 20);
		contentPane.add(codeInput);
		codeInput.setColumns(10);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = comboBox.getSelectedItem();
				System.out.println(codeInput.getText());
				if("Manager".equals(item) && codeInput.getText().equals(managerID)){
					access = true;
					manager = new ManagerPage();
					manager.setVisible(true);
					
				}

				if("Cashier".equals(item) && codeInput.getText().equals(cashierID)){
					access = true;
					cashier = new CashierPage();
					cashier.setVisible(true);
				
				}
				if("Chef".equals(item) && codeInput.getText().equals(chefID)){
					access = true;
					chef = new ChefPage();
					chef.setVisible(true);
				
				}
				if(access == false){
					JOptionPane.showMessageDialog(new JFrame(), "You do not have access");
				}

			}
			
		});
		btnContinue.setBounds(181, 217, 89, 23);
		contentPane.add(btnContinue);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SplashScreen.splash.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 325, 89, 23);
		contentPane.add(btnBack);
		
		
		
		
		
		
//		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shannon\\Documents\\CS414\\smallPizza2.jpg"));
//		lblNewLabel.setBounds(-54, 11, 533, 348);
//		contentPane.add(lblNewLabel);

		
		
		
		
	}
}