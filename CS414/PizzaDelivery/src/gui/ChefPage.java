package gui;

import gui.CashierPage.MenuHandler;

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


public class ChefPage extends JFrame {

	private JPanel contentPane;
	JButton btnViewOrder;
	JButton btnLogout;
	JButton btnCompleteOrder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChefPage frame = new ChefPage();
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
	public ChefPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChef = new JLabel("Chef");
		lblChef.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblChef.setBounds(183, 11, 44, 22);
		contentPane.add(lblChef);
		
		btnViewOrder = new JButton("View Order");
		btnViewOrder.setBounds(39, 64, 89, 23);
		contentPane.add(btnViewOrder);
		
		btnCompleteOrder = new JButton("Complete Order");
		btnCompleteOrder.setBounds(249, 64, 117, 23);
		contentPane.add(btnCompleteOrder);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setBounds(10, 325, 89, 23);
		contentPane.add(btnLogout);
		MenuHandler handler = new MenuHandler();
		btnLogout.addActionListener(handler);
		btnViewOrder.addActionListener(handler);
		btnCompleteOrder.addActionListener(handler);
	}
	
	public class MenuHandler implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			Object source = event.getSource();

			if(source ==  btnViewOrder)
			{
				ViewOrder view = new ViewOrder();
				view.setVisible(true);
			}
			if(source ==  btnCompleteOrder)
			{
				CompleteOrder complete = new CompleteOrder();
				complete.setVisible(true);
			}
			if(source == btnLogout)
			{
				SplashScreen.employeeLogin.setVisible(true);
				SplashScreen.employeeLogin.access = false;
				dispose();
			}
			
		}
	}

}
