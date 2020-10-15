import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateLoanScreen extends JFrame {

	private JPanel contentPane;

	private Controller ctrl;
	private JTextField txtUserId;
	private JTextField txtStockId;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateLoanScreen frame = new CreateLoanScreen();
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
	public CreateLoanScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdminMenu = new JButton("Admin menu");
		btnAdminMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.openAdminMenu();
				dispose();
			}
		});
		btnAdminMenu.setBounds(24, 11, 135, 31);
		contentPane.add(btnAdminMenu);
		
		JButton btnCreateLoan = new JButton("Create Loan");
		btnCreateLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int uId = new Integer(txtUserId.getText());
				int sId = new Integer(txtStockId.getText());
				
				boolean success = ctrl.createNewLoan(uId, sId, true);
				
				if(success) {
					showMessage("Loan created");
				}
				else {
					showMessage("Something went wrong, loan not created");
				}
			}
		});
		btnCreateLoan.setBounds(455, 380, 111, 31);
		contentPane.add(btnCreateLoan);
		
		txtUserId = new JTextField();
		txtUserId.setBounds(246, 157, 111, 20);
		contentPane.add(txtUserId);
		txtUserId.setColumns(10);
		
		txtStockId = new JTextField();
		txtStockId.setBounds(246, 239, 111, 20);
		contentPane.add(txtStockId);
		txtStockId.setColumns(10);
		
		JLabel lblUserId = new JLabel("User Id");
		lblUserId.setBounds(162, 160, 46, 14);
		contentPane.add(lblUserId);
		
		JLabel lblStockId = new JLabel("Stock id");
		lblStockId.setBounds(162, 242, 46, 14);
		contentPane.add(lblStockId);
	}
	
	public void setController(Controller c) {
		ctrl = c;
	}
	
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}

}
