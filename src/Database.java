import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public void MysqlConnect() {
    	Connection conn = null;

    	try {
    		
    		try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
    		
    		// Connect to Database
    		conn = DriverManager.getConnection("jdbc:mysql://localhost/shoft-eng-proj?" + "user=root&password=");

    	} catch (SQLException ex) {
    		System.out.println("SQLException: " + ex.getMessage());
    		System.out.println("SQLState: " + ex.getSQLState());
    		System.out.println("VendorError: " + ex.getErrorCode());
    	}
	}
}
