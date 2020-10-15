import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class DisplayInfoScreen extends JFrame {

	private JPanel contentPane;

	private Controller ctrl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayInfoScreen frame = new DisplayInfoScreen();
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
	public DisplayInfoScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtInfo = new JTextPane();
		txtInfo.setEditable(false);
		txtInfo.setBounds(90, 41, 571, 512);

		//Create the scrollbar for the textpane
		JScrollPane scroll = new JScrollPane(txtInfo);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(90, 41, 571, 512);
		contentPane.add(scroll);
	
		
		JButton btnUsers = new JButton("Display Users");
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInfo.setText(ctrl.listAllUsers());
			}
		});
		btnUsers.setBounds(90, 564, 116, 23);
		contentPane.add(btnUsers);
		
		JButton btnStock = new JButton("Display Stock");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInfo.setText(ctrl.listAllStock());
			}
		});
		btnStock.setBounds(323, 564, 116, 23);
		contentPane.add(btnStock);
		
		JButton btnLoans = new JButton("Display Loans");
		btnLoans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtInfo.setText(ctrl.listAllLoans());
			}
		});
		btnLoans.setBounds(538, 564, 123, 23);
		contentPane.add(btnLoans);
		
		JButton btnAdminMenu = new JButton("Admin Menu");
		btnAdminMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.openAdminMenu();
				dispose();
			}
		});
		btnAdminMenu.setBounds(10, 11, 129, 23);
		contentPane.add(btnAdminMenu);
	}
	
	public void setController(Controller c) {
		ctrl = c;
	}

}
