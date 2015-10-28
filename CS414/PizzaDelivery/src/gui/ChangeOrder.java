package gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import functionality.MenuItem;
import functionality.Order;
import functionality.dataStorage;

public class ChangeOrder extends JFrame {
	
	public static JPanel contentPane;
	public static JPanel labelPanel;
	public static JPanel buttonPanel;
	JButton btnBack;
	
	public ChangeOrder()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 607);

		
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.setBounds(0, 0, 607, 607);
		//add(contentPane);
		labelPanel = new JPanel();
		labelPanel.setBounds(0,50,200,300);
		labelPanel.setLayout(new GridLayout(0,1));
		contentPane.add(labelPanel);
		buttonPanel = new JPanel();
		buttonPanel.setBounds(210,50,100,300);
		buttonPanel.setLayout(new GridLayout(0,1));
		contentPane.add(buttonPanel);
		
		
		JLabel lblYourOrder = new JLabel("Order List:");
		lblYourOrder.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblYourOrder.setBounds(30, 11, 108, 14);
		contentPane.add(lblYourOrder);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(480, 500, 100, 23);
		contentPane.add(btnBack);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						SplashScreen.employeeLogin.cashier.setVisible(true);
						dispose();
								
							}
				});
		
		fillPanels();
	}
	
	public void fillPanels(){
		
		
		
			for(int i = 0; i<dataStorage.currentOrders.size(); i++){
				final Order order = dataStorage.currentOrders.get(i);
				JLabel l = new JLabel(order.customerName);
				labelPanel.add(l);
				JButton b = new JButton("View");
				final String tempName = order.customerName;
				//final MenuItem item = order.orderContents.get(i);
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
								CheckOut checkout = new CheckOut(order);
								checkout.setVisible(true);
								
							}
						  
						
				});
				buttonPanel.add(b);
			
		
		contentPane.updateUI();
			
	}
	}
		

}
