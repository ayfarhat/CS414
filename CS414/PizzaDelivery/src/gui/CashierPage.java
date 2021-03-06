package gui;

import gui.CheckOut.MenuHandler;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CashierPage extends JFrame {

	private JPanel contentPane;
	static CashierPage frame;
	public static CreateOrder create;
	public static ChangeOrder change;
	JButton btnCreateOrder;
	JButton btnChangeOrder;
	JButton btnLogout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CashierPage();
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
	public CashierPage() {
		create = null;
		change = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCashier = new JLabel("Cashier");
		lblCashier.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCashier.setBounds(174, 11, 70, 37);
		contentPane.add(lblCashier);
		
		btnCreateOrder = new JButton("Create Order");
		
		btnCreateOrder.setBounds(38, 66, 121, 23);
		contentPane.add(btnCreateOrder);
		
		btnChangeOrder = new JButton("Change Order");
		btnChangeOrder.setBounds(267, 66, 121, 23);
		contentPane.add(btnChangeOrder);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLogout.setBounds(10, 325, 89, 23);
		contentPane.add(btnLogout);
		MenuHandler handler = new MenuHandler();
		btnCreateOrder.addActionListener(handler);
		btnChangeOrder.addActionListener(handler);
		btnLogout.addActionListener(handler);
		
	}
	
	public class MenuHandler implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			Object source = event.getSource();

			if(source ==  btnCreateOrder)
			{
				create = new CreateOrder();
				create.setVisible(true);
			}
			if(source == btnChangeOrder)
			{
				change = new ChangeOrder();
				change.setVisible(true);
			}
			if(source ==  btnLogout)
			{
				SplashScreen.employeeLogin.setVisible(true);
				SplashScreen.employeeLogin.access = false;
				dispose();
			}
		}
	}

}
