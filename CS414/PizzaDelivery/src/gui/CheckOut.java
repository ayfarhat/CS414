package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
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

	/**
	 * Create the frame.
	 */
	public CheckOut(functionality.Order Order) {
		order = Order;
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
		
		JLabel lblYourOrder = new JLabel("Your Order");
		lblYourOrder.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblYourOrder.setBounds(30, 11, 108, 14);
		contentPane.add(lblYourOrder);
		
//		JEditorPane editorPane = new JEditorPane();
//		editorPane.setBounds(10, 36, 128, 112);
//		contentPane.add(editorPane);
		
		JButton btnChangeOrder = new JButton("AddItem");
		btnChangeOrder.setBounds(50, 500, 100, 23);
		contentPane.add(btnChangeOrder);
		
		JButton btnCash = new JButton("Cash");
		btnCash.setBounds(250, 500, 100, 23);
		contentPane.add(btnCash);
		
		JButton btnCredit = new JButton("Credit");
		btnCredit.setBounds(450, 500, 100, 23);
		contentPane.add(btnCredit);
		fillPanels();
	}
	
	public void fillPanels(){
		for(int i = 0; i<order.orderContents.size(); i++){
			JLabel l = new JLabel(order.orderContents.get(i).name);
			labelPanel.add(l);
			JButton b = new JButton("Remove");
			final String tempName = order.orderContents.get(i).name;
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int j = 0; j < labelPanel.getComponentCount(); j++){
						if(((JLabel)labelPanel.getComponent(j)).getText() == tempName){
							labelPanel.remove(j);
							buttonPanel.remove(j);
						}
					}
					contentPane.updateUI();
				}
			});
			buttonPanel.add(b);
		}
		contentPane.updateUI();
	}

}
