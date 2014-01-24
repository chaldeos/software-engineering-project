import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldPass;
	private JButton btLogin;

	/**
	 * Launch the application.
	 */
	public void run() {
		try {
			Driver_Frame frame = new Driver_Frame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblname = new JLabel("Όνομα Χρήστη");
		lblname.setBounds(46, 110, 99, 14);
		contentPane.add(lblname);
		
		JLabel lbpass = new JLabel("Συνθηματικό");
		lbpass.setBounds(46, 160, 99, 14);
		contentPane.add(lbpass);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(177, 105, 86, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldPass = new JTextField();
		textFieldPass.setBounds(177, 157, 86, 20);
		contentPane.add(textFieldPass);
		textFieldPass.setColumns(10);
		
		JLabel connect = new JLabel("Σύνδεση");
		connect.setHorizontalAlignment(SwingConstants.CENTER);
		connect.setBounds(177, 63, 86, 20);
		contentPane.add(connect);
		
		btLogin = new JButton("Είσοδος");
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Driver driver=new Driver(textFieldName.getText().trim(),textFieldPass.getText().trim());
				CloseFrame();
			}
		});
		btLogin.setBounds(151, 206, 143, 34);
		contentPane.add(btLogin);
	}
	
	public void CloseFrame(){
	    super.dispose();
	}

}
