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
	private JTextField txtNumberPlate;
	private JButton button;
	public String managerName;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		txtNumberPlate = new JTextField();
		txtNumberPlate.setBounds(30, 73, 219, 25);
		contentPane.add(txtNumberPlate);
		txtNumberPlate.setColumns(10);
		
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
		btnSearch.setBounds(261, 73, 117, 25);
		contentPane.add(btnSearch);
		
		JButton btnListAll = new JButton("Εμφάνιση όλων");
		btnListAll.setBounds(137, 162, 163, 50);
		contentPane.add(btnListAll);
	}
}