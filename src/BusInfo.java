import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;


public class BusInfo extends JFrame {

	private JPanel contentPane;
	public String managerName;
	private JTable table;

	private Manager manager;
	
	String arg[][] = null;
	String[] columnNames = {"Numberplate", "CC", "Brand", "Driven"};	
	/*
	Object[][] data = {
		    {"Kathy", "Smith",
		     "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe",
		     "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black",
		     "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White",
		     "Speed reading", new Integer(20), new Boolean(true)},
		    {"Joe", "Brown",
		     "Pool", new Integer(10), new Boolean(false)}
		};
	*/
	
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

		});
	}*/
	
	public void run() {
		try {
			BusInfo frame = new BusInfo(manager, arg);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public BusInfo(final Manager manager, String arg[][]) {
		this.arg = arg;
		this.manager = manager;
		
		
		//Object[][] data = 21;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		managerName="Αλέξανδρος Ευθυμιάδης";
		
		JLabel lblName = new JLabel(managerName);
		lblName.setBounds(12, 12, 199, 34);
		contentPane.add(lblName);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				// LoginManager
				LoginFrameManager window = new LoginFrameManager();
				window.setTitle("Είσοδος χρήστη");
				window.setVisible(true);
			}
		});
		btnLogOut.setBounds(655, 12, 131, 25);
		contentPane.add(btnLogOut);
		
		table = new JTable(arg, columnNames);
		table.setBounds(32, 58, 737, 374);
		contentPane.add(table);
		
		
	}
	
	public void CloseFrame(){
	    super.dispose();
	}
}
