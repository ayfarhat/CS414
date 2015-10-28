package gui;

//import PizzaDeliverGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import functionality.dataStorage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ManagerPage extends JFrame {

	private JPanel contentPane;
	static ManagerPage frame;

	

	/**
	 * Create the frame.
	 */
	public ManagerPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblManagerPage = new JLabel("Manager Page");
		lblManagerPage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblManagerPage.setBounds(154, 11, 124, 22);
		contentPane.add(lblManagerPage);

		JButton btnCreateMenu = new JButton("Create Menu");
		btnCreateMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateMenu create = new CreateMenu();
				create.setVisible(true);
				//contentPane.setVisible(false);
			}
		});
		btnCreateMenu.setBounds(33, 63, 124, 23);
		contentPane.add(btnCreateMenu);

		JButton btnNewButton = new JButton("Modify Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dataStorage.menu == null){
					JOptionPane.showMessageDialog(new JFrame(), "Please first create a menu");
				}
				else{
					/*MenuModify modify = new MenuModify();
					modify.setVisible(true);*/
					//MenuModify.frame.setVisible(true);
					CreateMenu.newMenu.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(271, 63, 124, 23);
		contentPane.add(btnNewButton);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*PizzaDeliverGUI main = new PizzaDeliverGUI();
				main.setVisible(true);
				dispose();*/
				SplashScreen.employeeLogin.setVisible(true);
				SplashScreen.employeeLogin.access = false;
				dispose();
			}
		});
		btnBack.setBounds(10, 325, 89, 23);
		contentPane.add(btnBack);
	}

}
