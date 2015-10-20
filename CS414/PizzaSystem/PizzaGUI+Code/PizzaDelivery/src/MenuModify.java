import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MenuModify extends JFrame {

	private JPanel contentPane;
	private JLabel lblMenuTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuModify frame = new MenuModify();
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
	public MenuModify() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		final JEditorPane dtrpnCheese = new JEditorPane();
		dtrpnCheese.setText("Cheese");
		
		dtrpnCheese.setBounds(24, 99, 66, 20);
		contentPane.add(dtrpnCheese);
		
		/////////Not sure how well this works but it saves it///////////////
		//Might need to go in and test it with the whole menu made//
		JButton btnEdit = new JButton("Save");
		btnEdit.addActionListener(new ActionListener() {
			final String newText = dtrpnCheese.getText();
			public void actionPerformed(ActionEvent arg0) {
				final String newText = dtrpnCheese.getText();
				dtrpnCheese.setText(newText);
			}
		});
		btnEdit.setBounds(100, 96, 75, 23);
		contentPane.add(btnEdit);
	}
	public void setMyTitle(String title){
		System.out.println(title);
		lblMenuTitle = new JLabel(title);
		lblMenuTitle.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblMenuTitle.setBounds(185, 11, 129, 38);
		contentPane.add(lblMenuTitle);
	}
}
