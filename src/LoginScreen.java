import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class LoginScreen extends JFrame {
	
	private Controller ctrl;
	
	private JPanel contentPane;
	private JTextField txtId;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginScreen frame = new LoginScreen();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public LoginScreen() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(157, 91, 151, 25);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(157, 134, 151, 25);
		contentPane.add(txtPassword);
		
		JButton btnLoginUser = new JButton("Login as a user!");
		btnLoginUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					validateInput();
				} 
				catch(InvalidLoginException e) {
					displayMessage("Invalid Login");
				}
			}
		});
		btnLoginUser.setBounds(273, 204, 136, 32);
		contentPane.add(btnLoginUser);
		
		JLabel lblID = new JLabel("Enter ID");
		lblID.setBounds(48, 96, 46, 14);
		contentPane.add(lblID);
		
		JLabel lblPassword = new JLabel("Enter Password");
		lblPassword.setBounds(48, 139, 81, 14);
		contentPane.add(lblPassword);
		
		JButton btnLoginAdmin = new JButton("Login as an admin!");
		btnLoginAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = txtId.getText();
				String pw = txtPassword.getText();
				
				if(id.equals(null) || id.equals("") || pw.equals(null) || pw.equals("")) {
					displayMessage("You must enter a userId and password");
				}
				else {
					
					boolean isValid = false;
					isValid = ctrl.validateAdminLogin(new Integer(id), pw);
					
					if(isValid) {						
						//Login was successful, controller will open the menu window
						//Close and dispose of the login screen
						dispose();
					}
					else {
						displayMessage("Login is invalid");
					}
				}
			}
		});
		btnLoginAdmin.setBounds(10, 204, 151, 32);
		contentPane.add(btnLoginAdmin);
	}
	
	public void setController(Controller c) {
		ctrl = c;
	}
	
	private void validateInput() throws InvalidLoginException{
		String id = txtId.getText();
		String pw = txtPassword.getText();
		
		if(id.equals(null) || id.equals("") || pw.equals(null) || pw.equals("")) {
			displayMessage("You must enter a userId and password");
		}
		else {
			
			boolean isValid = false;
			isValid = ctrl.validateLogin(new Integer(id), pw);
			
			if(isValid) {
				//Login was successful, controller will open the menu window
				//Close and dispose of the login screen
				dispose();
			}
			else {
				//displayMessage("Login is invalid");
				throw new InvalidLoginException();
				
			}
		}		
	}
	
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
