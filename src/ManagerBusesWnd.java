import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ManagerBusesWnd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton button;
	public String managerName;


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerBusesWnd frame = new ManagerBusesWnd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	*/
	
	public void run() {
		try {
			ManagerBusesWnd frame = new ManagerBusesWnd();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the frame.
	 */
	public ManagerBusesWnd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(30, 65, 200, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		managerName="Αλέξανδρος Ευθυμιάδης";

		
		JLabel lblName = new JLabel(managerName);
		lblName.setBounds(12, 12, 199, 34);
		contentPane.add(lblName);
		
		JButton btnLogOut = new JButton("Αποσύνδεση");
		btnLogOut.setBounds(301, 17, 131, 25);
		contentPane.add(btnLogOut);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setBounds(261, 65, 117, 50);
		contentPane.add(btnSearch);
		
		button = new JButton("Εμφάνιση όλων");
		button.setBounds(143, 162, 163, 50);
		contentPane.add(button);
	}
}
