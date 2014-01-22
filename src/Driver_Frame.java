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

	private static final long serialVersionUID = 4522486003277656723L;
	private JPanel contentPane;

	//EventQueue.invokeLater(new Runnable(){
		public void run() {
			try {
				Driver_Frame frame = new Driver_Frame();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	Driver driver = new Driver(1, "odhgos", "121", "Nikos","Nikolaou","342322342","Str. Park 32","123456789", 0, 1);
	public Driver_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogOut = new JButton("\u0391\u03C0\u03BF\u03C3\u03CD\u03BD\u03B4\u03B5\u03C3\u03B7");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogOut.setBounds(310, 11, 114, 23);
		contentPane.add(btnLogOut);
		
		JLabel lbNumberplane = new JLabel("Numberplane");
		lbNumberplane.setHorizontalAlignment(SwingConstants.CENTER);
		lbNumberplane.setBounds(32, 51, 103, 34);
		contentPane.add(lbNumberplane);
		
		JLabel lblDriversname = new JLabel(driver.surname);
		lblDriversname.setHorizontalAlignment(SwingConstants.CENTER);
		lblDriversname.setBounds(166, 51, 103, 34);
		contentPane.add(lblDriversname);
		
		JButton btInfo = new JButton("\u03A0\u03BB\u03B7\u03C1\u03BF\u03C6\u03BF\u03C1\u03AF\u03B5\u03C2");
		btInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btInfo.setBounds(10, 175, 114, 76);
		contentPane.add(btInfo);
		
		JButton btnNewButton = new JButton("\u0394\u03AE\u03BB\u03C9\u03C3\u03B7 \u0392\u03BB\u03AC\u03B2\u03B7\u03C2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(191, 175, 156, 76);
		contentPane.add(btnNewButton);
	}
}
