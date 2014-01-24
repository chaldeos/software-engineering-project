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
	private Manager manager;
	private String arg[][];
	/**
	 * Launch the application.
	 */

	public void run() {
		try {
			ManagerBusesWnd frame = new ManagerBusesWnd(manager);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public ManagerBusesWnd(final Manager manager) {
		this.manager = manager;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNumberPlate = new JTextField();
		txtNumberPlate.setBounds(30, 95, 219, 25);
		contentPane.add(txtNumberPlate);
		txtNumberPlate.setColumns(10);
		
		JLabel lblName = new JLabel(manager.getName());
		lblName.setBounds(12, 12, 199, 34);
		contentPane.add(lblName);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(301, 17, 131, 25);
		contentPane.add(btnLogOut);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				try {
					arg = manager.getBusses(txtNumberPlate.getText().trim());
				} catch (DBIOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BusInfo window = new BusInfo(manager,arg); 
				window.setTitle("Όχημα");
				window.setVisible(true);
			}
		});
		btnSearch.setBounds(261, 95, 117, 25);
		contentPane.add(btnSearch);
		
		JButton btnListAll = new JButton("List all buses");
		btnListAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				try {
					arg = manager.getBusses();
				} catch (DBIOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				BusInfo window = new BusInfo(manager,arg); 
				window.setTitle("Buses");
				window.setVisible(true);
			}
		});
		btnListAll.setBounds(137, 162, 163, 50);
		contentPane.add(btnListAll);
		
		JLabel lblNumberplate = new JLabel("Numberplate");
		lblNumberplate.setBounds(34, 68, 117, 15);
		contentPane.add(lblNumberplate);	
	}
	
	public JTextField TextField() {
		return txtNumberPlate;
	}
	
	public void CloseFrame(){
	    super.dispose();
	}
}