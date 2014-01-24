import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class LoginFrameManager extends LoginFrame{
	
	public LoginFrameManager(){
	btLogin = new JButton("Είσοδος");
	btLogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			try {
				manager=new Manager(textFieldName.getText().trim(),textFieldPass.getText().trim());
				ManagerMainscreen w = new ManagerMainscreen(manager);
				w.setTitle("Διαχειριστής");
				w.setVisible(true);
				//allign at center
				//w.getUsername().setText(textFieldName.getText().trim());
				//if (driver.getBid() != -1){
					//w.getReportButton().setEnabled(true);
					//w.getNplate().setText(driver.getNumberPlate());
				//}
				//else{
					//w.getReportButton().setEnabled(false);
				//}
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