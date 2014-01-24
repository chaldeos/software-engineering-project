import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
//import java.text.DateFormat;

public class Main extends JFrame {


	private static final long serialVersionUID = 1L;

	
	public static void main(String[] args) {
		
		
		LoginFrameManager window = new LoginFrameManager();
		window.setTitle("Είσοδος χρήστη");
		window.setVisible(true);
		
/*String errorMsg;
		
		try {
			errorMsg = RegisterLogin.register("aaaa", "aaaaaa", "aaa", "aaa", "123456789", "aaa", "1234567890", 0, 0);
			System.out.println(errorMsg);
		} catch (RegisterLoginException e) {
			e.printStackTrace();
		}
		
		// Login example
		try {
			String[][] res = RegisterLogin.login("nick", "1234");
			
			for (int i = 0; i < res.length; ++i) {
				for (int j = 0; j < res[i].length; ++j) {
					System.out.print(res[i][j] + ";");
				}
				System.out.println();
			}
			
		} catch (RegisterLoginException e) {
			e.printStackTrace();
		}
		
		String[][] res;
		Database db = new Database();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		db.mysqlConnect();
		
		// Insert Example
		try {
			db.insertToDatabase("fuellings", "bid, litres, km, date", "1, 100, 55555, 2000-12-12 12:35:45");
		} catch (DBIOException e1) {
			e1.printStackTrace();
		}
		
		// Update Example
		try {
			System.out.println("Affected rows: " + db.updateDatabase("fuellings", "date", dateFormat.format(cal.getTime()), "fid=1"));
		} catch (DBIOException e) {
			e.printStackTrace();
		}
		
		// Fetch example
		try {
			res = db.fetchFromDatabase("fuellings", "fid, bid, litres, km, date, comments", "");
			
			for (int i = 0; i < res.length; ++i) {
				for (int j = 0; j < res[i].length; ++j) {
					System.out.print(res[i][j] + ";");
				}
				System.out.println();
			}
		} catch (DBIOException e) {
			e.printStackTrace();
		}*/	
	}

}
