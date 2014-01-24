import javax.swing.JOptionPane;


public class Manager extends User{
	

	public Manager(String username, String password) {
		
		super(username, password);
		
		if (type == 0){
			
			String bus_res[][] = null;
			
			ManagerMainscreen w = new ManagerMainscreen();
			w.setTitle("Διαχειριστής");
			w.setVisible(true);
			
			//w.getUsername().setText(username);
			//w.getReportButton().setEnabled(false);
			
		}
		
	}
	
	
}
