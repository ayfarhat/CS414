package gui;

import functionality.MenuItem;
import functionality.dataStorage;
import functionality.orderStatus;
import gui.MenuModify.MenuHandler;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JButton;


public class CheckOut extends JFrame {

	private JPanel contentPane;
	private JPanel labelPanel;
	private JPanel buttonPanel;
	private functionality.Order order;
	public  JButton btnChangeOrder;
	JButton btnCancel;
	JButton btnCheckout;
	JButton btnCash;
	JButton btnCredit;
	boolean payed;
	double price;
	JLabel amount;
	

	/**
	 * Create the frame.
	 */
	public CheckOut(functionality.Order Order) {
		order = Order;
		payed =false;
		price =0;
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
//		lowerPane = new JPanel();
//		lowerPane.setBounds(0,500,607,100);
//		lowerPane.setLayout(new GridLayout(1,3));
//		add(lowerPane);
		
		JLabel lblYourOrder = new JLabel(order.customerName);
		lblYourOrder.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblYourOrder.setBounds(30, 11, 108, 14);
		contentPane.add(lblYourOrder);
		
//		JEditorPane editorPane = new JEditorPane();
//		editorPane.setBounds(10, 36, 128, 112);
//		contentPane.add(editorPane);
		
		JLabel total = new JLabel ("Total:");
		total.setBounds(30, 440, 80, 23);
		contentPane.add(total);
		
		amount = new JLabel ();
		amount.setBounds(100, 440, 80, 23);
		contentPane.add(amount);
		
		btnChangeOrder = new JButton("AddItem");
		btnChangeOrder.setBounds(30, 500, 100, 23);
		contentPane.add(btnChangeOrder);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(170, 500, 100, 23);
		contentPane.add(btnCancel);
		
		btnCheckout = new JButton("Checkout");
		btnCheckout.setBounds(480, 540, 100, 23);
		contentPane.add(btnCheckout);
		
		btnCash = new JButton("Cash");
		btnCash.setBounds(320, 500, 100, 23);
		contentPane.add(btnCash);
		
		btnCredit = new JButton("Credit");
		btnCredit.setBounds(480, 500, 100, 23);
		contentPane.add(btnCredit);
		fillPanels();
		amount.setText(price+" $");
		MenuHandler handler = new MenuHandler();
		btnChangeOrder.addActionListener(handler);
		btnCancel.addActionListener(handler);
		btnCheckout.addActionListener(handler);
		btnCash.addActionListener(handler);
		btnCredit.addActionListener(handler);
	}
	
	public void fillPanels(){
		for(int i = 0; i<order.orderContents.size(); i++){
			JLabel l = new JLabel(order.orderContents.get(i).name);
			labelPanel.add(l);
			JButton b = new JButton("Remove");
			final String tempName = order.orderContents.get(i).name;
			final MenuItem item = order.orderContents.get(i);
			price += item.price;
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int j = 0; j < labelPanel.getComponentCount(); j++){
						if(((JLabel)labelPanel.getComponent(j)).getText() == tempName){
							labelPanel.remove(j);
							buttonPanel.remove(j);
							order.removeItem(item);
							price-= item.price;
							amount.setText(price+" $");
							
							
						}
					}
					contentPane.updateUI();
				}
			});
			buttonPanel.add(b);
		}
		
		contentPane.updateUI();
	}
	public class MenuHandler implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			Object source = event.getSource();

			if(source ==  btnChangeOrder)
			{
				CreateOrder c = new CreateOrder();
				c.order = order;
				c.nameField.setText(order.customerName);
				c.orderCreated = true;
				
				c.setVisible(true);
				//SplashScreen.employeeLogin.cashier.create.setVisible(true);
				dispose();
			}
			
			if(source ==  btnCancel)
			{
				//SplashScreen.employeeLogin.cashier.create.orderCreated = false;
				dataStorage.currentOrders.remove(order);
				if(SplashScreen.employeeLogin.cashier.create != null)
				{
					SplashScreen.employeeLogin.cashier.create.dispose();
				}
				
				else if(SplashScreen.employeeLogin.cashier.change != null)
				{
					
					SplashScreen.employeeLogin.cashier.change.labelPanel.removeAll();
					
					SplashScreen.employeeLogin.cashier.change.buttonPanel.removeAll();
					SplashScreen.employeeLogin.cashier.change.contentPane.updateUI();
					SplashScreen.employeeLogin.cashier.change.fillPanels();
				}
//				else
//				{
//					SplashScreen.customer.
//				}

				dispose();
			}
			if(source == btnCash)
			{
				if(order.orderContents.size() == 0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "You don't have items in your cart");
					
				}
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please insert cash", "Cash Payment",
							JOptionPane.PLAIN_MESSAGE); 
					payed = true;
				}
				
			}
			
			if(source == btnCredit)
			{

				if(order.orderContents.size() == 0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "You don't have items in your cart");
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(new JFrame(), "Please swipe credit card","Credit Payment",
						    JOptionPane.PLAIN_MESSAGE);
					
					payed = true;
				}
				
			}
			
			if(source ==  btnCheckout)
			{
				if(order.orderContents.size() == 0)
				{
					JOptionPane.showMessageDialog(new JFrame(), "You don't have items in your cart");
					
				}
				else
				{
					if(payed == false)
					{
						JOptionPane.showMessageDialog(new JFrame(), "Please choose payment method");
					}
					else
					{
						order.os = orderStatus.inProgress;
						
						if(SplashScreen.employeeLogin.cashier.create != null)
						{
						
							SplashScreen.employeeLogin.cashier.create = null;
						}
						else 
						{
							System.out.println("checout customer");
							SplashScreen.customer.newOrder = null;
							
						}
						
						dispose();
					}
				}
				
			}
		}
	}

}
