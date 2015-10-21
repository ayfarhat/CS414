import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PizzaDeliverGUI extends JFrame {

	private JPanel contentPane;
	private JTextField codeInput;
	static PizzaDeliverGUI login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 login = new PizzaDeliverGUI();
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PizzaDeliverGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogin.setBounds(205, 11, 93, 54);
		contentPane.add(lblLogin);
		
		JLabel lblPleaseSelectYour = new JLabel("Please Select Your Position");
		lblPleaseSelectYour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPleaseSelectYour.setBounds(153, 60, 174, 20);
		contentPane.add(lblPleaseSelectYour);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Manager", "Cashier", "Chef"}));
		comboBox.setBounds(186, 91, 94, 20);
		contentPane.add(comboBox);
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = comboBox.getSelectedItem();
				if("Manager".equals(item)){
					ManagerPage manager = new ManagerPage();
					manager.setVisible(true);
					//login.dispose();
				}
				if("Cashier".equals(item)){
					CashierPage cashier = new CashierPage();
					cashier.setVisible(true);
					//login.dispose();
				}
				if("Chef".equals(item)){
					ChefPage chef = new ChefPage();
					chef.setVisible(true);
					//login.dispose();
				}

			}
		});
		btnContinue.setBounds(300, 90, 89, 23);
		contentPane.add(btnContinue);
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter Your Code");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPleaseEnterYour.setBounds(153, 153, 145, 14);
		contentPane.add(lblPleaseEnterYour);
		
		codeInput = new JTextField();
		codeInput.setBounds(163, 178, 86, 20);
		contentPane.add(codeInput);
		codeInput.setColumns(10);
		
		
//		JLabel lblNewLabel = new JLabel("New label");
//		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shannon\\Documents\\CS414\\smallPizza2.jpg"));
//		lblNewLabel.setBounds(-54, 11, 533, 348);
//		contentPane.add(lblNewLabel);

		
		
		
		
	}
}
