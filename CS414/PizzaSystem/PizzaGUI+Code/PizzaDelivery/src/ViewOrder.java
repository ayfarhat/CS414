import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JButton;


public class ViewOrder extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOrder frame = new ViewOrder();
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
	public ViewOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourOrder = new JLabel("Your Order");
		lblYourOrder.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblYourOrder.setBounds(30, 11, 108, 14);
		contentPane.add(lblYourOrder);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 36, 128, 112);
		contentPane.add(editorPane);
		
		JButton btnChangeOrder = new JButton("Change Order");
		btnChangeOrder.setBounds(57, 251, 108, 23);
		contentPane.add(btnChangeOrder);
		
		JButton btnCash = new JButton("Cash");
		btnCash.setBounds(10, 285, 89, 23);
		contentPane.add(btnCash);
		
		JButton btnCredit = new JButton("Credit");
		btnCredit.setBounds(133, 285, 89, 23);
		contentPane.add(btnCredit);
	}

}
