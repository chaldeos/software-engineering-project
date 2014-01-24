import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ManagerMainscreen extends JFrame {

	private JPanel contentPane;
	public String managerName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerMainscreen frame = new ManagerMainscreen();
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
	
	
	public ManagerMainscreen() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		managerName="Αλέξανδρος Ευθυμιάδης";
		
		JLabel lblName = new JLabel(managerName);
		lblName.setBounds(12, 12, 199, 34);
		contentPane.add(lblName);
		
		JButton btnBuses = new JButton("Οχήματα");
		btnBuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerBusesWnd window = new ManagerBusesWnd(); 
				window.setTitle("Οχήματα");
				window.setVisible(true);
			}
		});
		btnBuses.setBounds(70, 130, 117, 60);
		contentPane.add(btnBuses);
		
		JButton btnEmployees = new JButton("Υπάλληλοι");
		
		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		btnEmployees.setBounds(260, 130, 117, 60);
		contentPane.add(btnEmployees);
		
		JButton btnLogOut = new JButton("Αποσύνδεση");
		btnLogOut.setBounds(301, 17, 131, 25);
		contentPane.add(btnLogOut);
		
		
		
	}
}
