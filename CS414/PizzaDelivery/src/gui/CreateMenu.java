package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import functionality.dataStorage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CreateMenu extends JFrame {

	private JPanel contentPane;
	private JTextField menuTitle;
	private static CreateMenu frame;
	static MenuModify newMenu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CreateMenu();
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
	public CreateMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPleaseEnterThe = new JLabel("Please Enter the Name of the Menu:");
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPleaseEnterThe.setBounds(41, 31, 356, 43);
		contentPane.add(lblPleaseEnterThe);
		
		menuTitle = new JTextField();
		menuTitle.setBounds(109, 79, 197, 28);
		contentPane.add(menuTitle);
		menuTitle.setColumns(10);
		

		
		JButton btnCreateMenu = new JButton("Create Menu");
		btnCreateMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    //String newTitle = menuTitle.getText();
				newMenu = new MenuModify();
				
				dataStorage.mananger.createMenu(menuTitle.getText());
				newMenu.setVisible(true);
				newMenu.setMyTitle(menuTitle.getText());
				dispose();
			}
		});
		btnCreateMenu.setBounds(146, 118, 128, 23);
		contentPane.add(btnCreateMenu);
	}

}
