import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		String[][] res;
		Database db = new Database();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		db.mysqlConnect();
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
		}
	}

}
