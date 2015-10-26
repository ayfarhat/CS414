package gui;

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
		
		JButton btnCreateOrder = new JButton("Create Order");
		btnCreateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateOrder create = new CreateOrder();
				create.setVisible(true);
			}
		});
		btnCreateOrder.setBounds(38, 66, 121, 23);
		contentPane.add(btnCreateOrder);
		
		JButton btnChangeOrder = new JButton("Change Order");
		btnChangeOrder.setBounds(267, 66, 121, 23);
		contentPane.add(btnChangeOrder);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLogout.setBounds(10, 325, 89, 23);
		contentPane.add(btnLogout);
	}

}
