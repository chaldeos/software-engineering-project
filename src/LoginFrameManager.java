import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class LoginFrameManager extends LoginFrame{
	
	public LoginFrameManager(){
	btLogin = new JButton("Log in");
	btLogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		
			try {
				manager=new Manager(textFieldName.getText().trim(),textFieldPass.getText().trim());
				ManagerMainscreen w = new ManagerMainscreen(manager);
				w.setTitle("Manager");
				w.setVisible(true);

				CloseFrame();
			} catch (RegisterLoginException d) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, d.getMessage(),"Error", JOptionPane.PLAIN_MESSAGE);	
			}
			
			
		}


	});
	btLogin.setBounds(151, 206, 143, 34);
	contentPane.add(btLogin);
	
	}

}
