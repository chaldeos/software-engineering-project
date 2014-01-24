import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;


public class Driver_Frame extends JFrame {

	
	private static final long serialVersionUID = 1L;
	 
	private JPanel contentPane;
	
	private JButton reportButton;
	
	private JLabel nplate;
	
	private JLabel user;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driver_Frame frame = new Driver_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 * Create the frame.
	 */
	//EventQueue.invokeLater(new Runnable(){
		public void run() {
			try {
				Driver_Frame frame = new Driver_Frame();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	//Driver driver = new Driver("odhgos", "121");
	public Driver_Frame() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogOut = new JButton("Αποσύνδεση");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				LoginFrame window = new LoginFrame();
				window.setTitle("Είσοδος χρήστη");
				window.setVisible(true);
			}
		});
		btnLogOut.setBounds(292, 11, 132, 40);
		contentPane.add(btnLogOut);
		
		JLabel lbNumberplane = new JLabel("Numberplate");
		this.nplate = lbNumberplane;
		
		lbNumberplane.setHorizontalAlignment(SwingConstants.CENTER);
		lbNumberplane.setBounds(32, 83, 103, 34);
		contentPane.add(lbNumberplane);
		
		JLabel lblDriversname = new JLabel("Name");
		this.user = lblDriversname;
		lblDriversname.setHorizontalAlignment(SwingConstants.CENTER);
		lblDriversname.setBounds(166, 83, 103, 34);
		contentPane.add(lblDriversname);
		
		JButton btReport = new JButton("Δήλωση Βλάβης");
		this.reportButton = btReport;
		//btReport.setEnabled(false);
		btReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriversReport window = new DriversReport();
				window.setTitle("Δήλωση Βλάβης");
				window.setVisible(true);
			}
		});
		btReport.setBounds(268, 175, 156, 76);
		contentPane.add(btReport);
		
		JLabel lbInfo = new JLabel("Τηλ. Κεντρικά 2107777777");
		lbInfo.setBounds(32, 211, 170, 40);
		contentPane.add(lbInfo);
	}
	
	public void CloseFrame(){
	    super.dispose();
	}
	
	public JButton getReportButton(){
		
		return this.reportButton;
	}
	
	public JLabel getNplate(){
		
		return this.nplate;
	}
	
	public JLabel getUsername(){
		
		return this.user;
	}
}
