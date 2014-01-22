import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		Database db = new Database();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		
		db.MysqlConnect();
		db.InsertToDatabase("fuellings", "bid,litres,km,date", "1,10,100," + dateFormat.format(cal.getTime()));
	}

}
