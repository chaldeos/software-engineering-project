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
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(10, 11, 414, 192);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btSubmit = new JButton("��������");
		btSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//send report
				String textFieldValue = textField.getText().trim();
				System.out.println(textFieldValue);
				JOptionPane.showMessageDialog(
						null, "� ������ ��� �������. ","Title", JOptionPane.PLAIN_MESSAGE);

				CloseFrame();
			}
		});
		btSubmit.setBounds(20, 214, 154, 37);
		contentPane.add(btSubmit);
		
		button = new JButton("�������");
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

	public JTextField getTextField() {
		System.out.println(textField);
		return textField;
	}
}
