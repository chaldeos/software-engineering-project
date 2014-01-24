import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.DropMode;


public class DriversReport extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton button;
	public String setDriversText;
	private Driver driver;

		public void run() {
			try {
				DriversReport report = new DriversReport(driver);
				report.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	/**
	 * Create the frame.
	 */
	public DriversReport(final Driver driver) {
		
		this.driver = driver;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(10, 11, 414, 192);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btSubmit = new JButton("Αποστολή");
		btSubmit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					driver.insertReport(textField.getText().trim());
					JOptionPane.showMessageDialog(null, "Η δήλωσή σας εστάλει.","Title", JOptionPane.PLAIN_MESSAGE);
					CloseFrame();
				} catch (DBIOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Title", JOptionPane.PLAIN_MESSAGE);
				}
				
			}
			
		});
		btSubmit.setBounds(20, 214, 154, 37);
		contentPane.add(btSubmit);
		
		button = new JButton("Ακύρωση");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseFrame();
			}
		});
		button.setBounds(257, 214, 154, 37);
		contentPane.add(button);
		
	}

	public void CloseFrame(){
	    super.dispose();
	}

	public JTextField TextField() {
		System.out.println(textField);
		return textField;
	}

	public String setDriversText(){
		String t = (textField.getText().trim());
		return t;
		
	}	
}
