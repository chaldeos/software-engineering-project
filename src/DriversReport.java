import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DriversReport extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	

		public void run() {
			try {
				DriversReport report = new DriversReport();
				report.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	/**
	 * Create the frame.
	 */
	public DriversReport() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 414, 192);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btSubmit = new JButton("\u0391\u03C0\u03BF\u03C3\u03C4\u03BF\u03BB\u03AE");
		btSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//send report
				//ok
				CloseFrame();
			}
		});
		btSubmit.setBounds(139, 214, 154, 37);
		contentPane.add(btSubmit);
		
	}

	public void CloseFrame(){
	    super.dispose();
	}

}
