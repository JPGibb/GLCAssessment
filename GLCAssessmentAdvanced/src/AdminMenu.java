import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMenu extends JFrame {

	private JPanel contentPane;
	
	private Controller ctrl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMenu frame = new AdminMenu();
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
	public AdminMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDisplayData = new JButton("Display info page");
		btnDisplayData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.openDisplayInfoScreen();
				dispose();
			}
		});
		btnDisplayData.setBounds(113, 43, 144, 61);
		contentPane.add(btnDisplayData);
		
		JButton btnCreateNewLoan = new JButton("Create new loan");
		btnCreateNewLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.openCreateLoanScreen();
				dispose();
			}
		});
		btnCreateNewLoan.setBounds(113, 151, 144, 61);
		contentPane.add(btnCreateNewLoan);
	}
	
	public void setController(Controller c) {
		ctrl = c;
	}

}
