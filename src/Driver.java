import javax.swing.JOptionPane;


public class Driver extends User{


	public Driver(String username, String password) {
		
		super(username, password);
		
		if (type == 2){
			Driver_Frame w = new Driver_Frame();
			w.setTitle("Οδηγός");
			w.setVisible(true);
		}
		else{
			JOptionPane.showMessageDialog(null, "Τα στοιχεία σας δεν είναι έγκυρα. ","Σφάλμα", JOptionPane.PLAIN_MESSAGE);
		}
	}

}
