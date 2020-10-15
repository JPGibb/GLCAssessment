import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserMenu extends JFrame {

	private JPanel contentPane;
	
	private Controller ctrl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMenu frame = new UserMenu();
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
	public UserMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtUserLoans = new JTextPane();
		txtUserLoans.setBounds(10, 41, 591, 324);
		contentPane.add(txtUserLoans);
		
		JButton btnUserLoans = new JButton("List all loans");
		btnUserLoans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = null;
				
				message = ctrl.getAllLoansForUser();
				
				if(message.isEmpty()) {
					txtUserLoans.setText("No loans on file");
				} else {
					txtUserLoans.setText(message);
				}
				
			}
		});
		btnUserLoans.setBounds(234, 406, 137, 37);
		contentPane.add(btnUserLoans);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.logout();
				dispose();
			}
		});
		btnLogout.setBounds(10, 7, 89, 23);
		contentPane.add(btnLogout);
	}
	
	public void setController(Controller c) {
		ctrl = c;
	}
}
