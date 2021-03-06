package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import functionality.dataStorage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CustomerPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	CreateOrder newOrder;
	JButton btnCreateOrder;
	JButton btnViewOrder;
	JButton btnBack;
	String name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerPage frame = new CustomerPage();
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
	public CustomerPage() {
		
		newOrder = null;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPleaseEnterYour = new JLabel("Please Enter Your Name:");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPleaseEnterYour.setBounds(92, 45, 190, 20);
		contentPane.add(lblPleaseEnterYour);

		textField = new JTextField();
		textField.setBounds(292, 47, 140, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		Handler handler = new Handler();
		
		btnCreateOrder = new JButton("Create Order");
		btnCreateOrder.addActionListener(handler);
		
		btnCreateOrder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCreateOrder.setBounds(79, 117, 116, 23);
		contentPane.add(btnCreateOrder);

		btnViewOrder = new JButton("View Order");
		btnViewOrder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnViewOrder.setBounds(367, 117, 108, 23);
		contentPane.add(btnViewOrder);

		btnViewOrder.addActionListener(handler);
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SplashScreen.splash.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 535, 89, 23);
		contentPane.add(btnBack);
	}


	public class Handler implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			Object source = event.getSource();

			if(source ==  btnCreateOrder)
			{
				name = textField.getText();
				newOrder = new CreateOrder();
				if(!name.isEmpty())
				{	
					newOrder.nameField.setText(name);
				}
				
				newOrder.setVisible(true);
			}
			
			if(source == btnViewOrder)
			{
				boolean found = false;
				name = textField.getText();
				if(!name.isEmpty())
				{	
					for(int i =0; i<dataStorage.currentOrders.size(); i++)
					{
						if(dataStorage.currentOrders.get(i).customerName.equals(name))
						{
							CheckOut order = new CheckOut(dataStorage.currentOrders.get(i));
							order.setVisible(true);
							found = true;
						}
					}
					if(!found)
					{
						JOptionPane.showMessageDialog(new JFrame(), "You don't have an order under that name");
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please eneter the order name");
				}
				
			}
		}
	}
}