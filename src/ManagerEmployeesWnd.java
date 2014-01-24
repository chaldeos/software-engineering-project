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
	private JTextField txtLastname;
	private JTextField txtFirstname;
	private JTextField txtTIN;

	private Manager manager;
	private String arg[][];
	
	public String[] category = {"Driver","Employee"};
	
	public void run() {
		try {
			ManagerEmployeesWnd frame = new ManagerEmployeesWnd(manager);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ManagerEmployeesWnd(final Manager manager) {
		this.manager = manager;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel(manager.getName());
		lblName.setBounds(33, 15, 168, 15);
		contentPane.add(lblName);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(315, 10, 121, 25);
		contentPane.add(btnLogOut);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(274, 131, 114, 25);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnSearch);
		
		txtLastname = new JTextField();
		txtLastname.setForeground(Color.LIGHT_GRAY);
		txtLastname.setBackground(Color.WHITE);
		txtLastname.setText("Lastname");
		txtLastname.setBounds(33, 82, 114, 25);
		contentPane.add(txtLastname);
		txtLastname.setColumns(15);
		
		txtFirstname = new JTextField();
		txtFirstname.setText("Firstname");
		txtFirstname.setForeground(Color.LIGHT_GRAY);
		txtFirstname.setBounds(153, 82, 114, 25);
		contentPane.add(txtFirstname);
		txtFirstname.setColumns(15);
		
		txtTIN = new JTextField();
		txtTIN.setText("TIN");
		txtTIN.setForeground(Color.LIGHT_GRAY);
		txtTIN.setBounds(274, 82, 114, 25);
		contentPane.add(txtTIN);
		txtTIN.setColumns(9);
		
		JComboBox listCategories = new JComboBox(category);
		listCategories.setBounds(33, 131, 114, 24);
		listCategories.setSelectedIndex(0);
		contentPane.add(listCategories);	
	}
}
