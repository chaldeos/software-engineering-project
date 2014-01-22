import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	Connection conn = null;
	
    public void MysqlConnect() {

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
    
    public void InsertToDatabase(String table, String fields, String values) {
    	// Construct Query
    	
    	//Execute
    }
    
    public void FetchFromDatabase(String table, String fields, String condition) {
    	// Construct Query
    	
    	// Execute
    }
    
}
