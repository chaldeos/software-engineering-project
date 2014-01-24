import javax.swing.JOptionPane;


public class Driver extends User{
	

	public Driver(String username, String password) {
		
		super(username, password);
		
		
		if (type == 2){
			
			String bus_res[][] = null;
			
			Driver_Frame w = new Driver_Frame();
			w.setTitle("Οδηγός");
			w.setVisible(true);
			//allign at center
			w.getUsername().setText(username);
			w.getReportButton().setEnabled(false);
			//numberplate den exei anate8ei lewforeio
			if ((bus_res = getDriversBus(uid)) != null){ //Create bus object
				//appear numberplate
				w.getReportButton().setEnabled(true);
				w.getNplate().setText(bus_res[0][1]);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Τα στοιχεία σας δεν είναι έγκυρα. ","Σφάλμα", JOptionPane.PLAIN_MESSAGE);
		}
	}
	//Validation.validateReport(String data)
	
	private String[][] getDriversBus(int uid){
		String bus[][] = null;
		int bid;
		
		Database db = new Database();
		db.mysqlConnect();
		try {
			bus = db.fetchFromDatabase("busses_users","bid","uid=" + uid);
			if (bus[0][0] != null){
				bid = Integer.parseInt(bus[0][0]);
				bus = db.fetchFromDatabase("busses","bid, numberplate, cc, brand","bid=" + bid);
				
			}
		} catch (DBIOException e) {
			e.printStackTrace();
		}
		
		return bus;
	}
	
	
}
