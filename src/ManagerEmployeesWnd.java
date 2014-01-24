import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;


public class ManagerEmployeesWnd extends JFrame {

	private JPanel contentPane;
	private JTextField txtSurname;
	private JTextField txtName;
	private JTextField txtAFM;

	
	public String managerName;
	public String[] category = {"Οδηγός","Υπάλληλος"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerEmployeesWnd frame = new ManagerEmployeesWnd();
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
	public ManagerEmployeesWnd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		managerName="Αλέξανδρος Ευθυμιάδης";
		contentPane.setLayout(null);

		
		JLabel lblName = new JLabel(managerName);
		lblName.setBounds(33, 15, 168, 15);
		contentPane.add(lblName);
		
		JButton btnLogOut = new JButton("Αποσύνδεση");
		btnLogOut.setBounds(315, 10, 121, 25);
		contentPane.add(btnLogOut);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(274, 131, 114, 25);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnSearch);
		
		txtSurname = new JTextField();
		txtSurname.setForeground(Color.LIGHT_GRAY);
		txtSurname.setBackground(Color.WHITE);
		txtSurname.setText("Επώνυμο");
		txtSurname.setBounds(33, 82, 114, 25);
		contentPane.add(txtSurname);
		txtSurname.setColumns(15);
		
		txtName = new JTextField();
		txtName.setText("Όνομα");
		txtName.setForeground(Color.LIGHT_GRAY);
		txtName.setBounds(153, 82, 114, 25);
		contentPane.add(txtName);
		txtName.setColumns(15);
		
		txtAFM = new JTextField();
		txtAFM.setText("ΑΦΜ");
		txtAFM.setForeground(Color.LIGHT_GRAY);
		txtAFM.setBounds(274, 82, 114, 25);
		contentPane.add(txtAFM);
		txtAFM.setColumns(9);
		
		JComboBox listCategories = new JComboBox(category);
		listCategories.setBounds(33, 131, 114, 24);
		listCategories.setSelectedIndex(0);
		contentPane.add(listCategories);
		
	}
}