package gui;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import functionality.Order;
import functionality.dataStorage;

public class ViewOrder extends JFrame 
{
	public static JPanel contentPane;
	public static JPanel labelPanel;
	public static JPanel buttonPanel;
	public static JPanel labels;
	public static JPanel buttons;
	
	//JPanel panel ;
	JButton btnBack;
	JFrame frameModify;
	
	public ViewOrder()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 607);

		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
						
						SplashScreen.employeeLogin.chef.setVisible(true);
						dispose();
								
							}
				});
		
		fillPanels();
	}
	
	public void fillPanels(){
		
		
		frameModify = new JFrame();

		
			for(int i = 0; i<dataStorage.currentOrders.size(); i++){
				final Order order = dataStorage.currentOrders.get(i);
				JLabel l = new JLabel(order.customerName);
				labelPanel.add(l);
				JButton b = new JButton("View");
				final String tempName = order.customerName;
				
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("inside view order");					
							
						JPanel panel = new JPanel(new GridLayout(0,1));
						
						for(int n=0; n<order.orderContents.size();n++)
						{
							JLabel label = new JLabel();
							label.setText(order.orderContents.get(n).name);
							panel.add(label);
							
						}
						JFrame f = new JFrame();
						f.setBounds(100, 100, 500, 500);
						f.add(panel);
						f.setVisible(true);
								
							}		  
						
				});
				JButton ok = new JButton("OK");
				ok.setBounds(480, 500, 100, 23);
				contentPane.add(ok);
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frameModify.dispose();
					}
					
				});
				buttonPanel.add(b);
				frameModify.setVisible(true);
			
		
		//contentPane.updateUI();
			
	}
	}
		

}

