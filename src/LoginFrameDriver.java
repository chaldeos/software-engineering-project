import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class LoginFrameDriver extends LoginFrame{
	
	public LoginFrameDriver(){
	btLogin = new JButton("Είσοδος");
	btLogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			try {
				driver=new Driver(textFieldName.getText().trim(),textFieldPass.getText().trim());
				Driver_Frame w = new Driver_Frame(driver);
				w.setTitle("Οδηγός");
				w.setVisible(true);
				
				w.getUsername().setText(textFieldName.getText().trim());
				if (driver.getBid() != -1){
					w.getReportButton().setEnabled(true);
					w.getNplate().setText(driver.getNumberPlate());
				}
				else{
					w.getReportButton().setEnabled(false);
				}
				CloseFrame();
			} catch (RegisterLoginException d) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, d.getMessage(),"Σφάλμα", JOptionPane.PLAIN_MESSAGE);	
			}
			
			
		}


	});
	btLogin.setBounds(151, 206, 143, 34);
	contentPane.add(btLogin);
	
	}

}
