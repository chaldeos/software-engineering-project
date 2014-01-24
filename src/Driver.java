import javax.swing.JOptionPane;


public class Driver extends User{
	int bid = -1;
	String numberplate = null;
	public Driver(String username, String password) throws RegisterLoginException {
		
		super(username, password);
	
		if (type == 2){
			
			String bus_res[][] = null;
			
			//numberplate den exei anate8ei lewforeio
			if ((bus_res = getDriversBus(uid)) != null){ //Create bus object
				//appear numberplate
				this.bid = Integer.parseInt(bus_res[0][0]);
				this.numberplate = bus_res[0][1];
				DriversReport dr = new DriversReport(this);
				String text = dr.setDriversText();
				//if (text!=null){
				//	Report r = new Report(Integer.parseInt(bus_res[0][0]),uid, text);
				//}
			}
		}
		else{
			throw new RegisterLoginException("Τα στοιχεία σας δεν είναι έγκυρα.");
			//JOptionPane.showMessageDialog(null, "Τα στοιχεία σας δεν είναι έγκυρα. ","Σφάλμα", JOptionPane.PLAIN_MESSAGE);
			
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
	
	public int getBid(){
		return this.bid;
	}
	
	public String getNumberPlate(){
		return this.numberplate;
	}
	
	public void insertReport(String text){

		Database db = new Database();
		db.mysqlConnect();
		try {
			//bus = db.fetchFromDatabase("busses_users","bid","uid=" + uid);
			//if (bus[0][0] != null){
				db.insertToDatabase("reports","bid,uid,report_txt",this.bid + "," + this.uid + "," +text);
		} catch (DBIOException e) {
			e.printStackTrace();
		}
		
	}
	
}
