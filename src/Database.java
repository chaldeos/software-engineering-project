import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Database {
	private Connection conn = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
    public void MysqlConnect() {

    	try {
    		
    		try {
    			Class.forName("com.mysql.jdbc.Driver").newInstance();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		// Connect to Database
    		conn = DriverManager.getConnection("jdbc:mysql://localhost/shoft-eng-proj?" + "user=Manolis&password=qwe/789");

    	} catch (SQLException e) {
    		System.out.println("SQLException: " + e.getMessage());
    		System.out.println("SQLState: " + e.getSQLState());
    		System.out.println("VendorError: " + e.getErrorCode());
    	}
    	
	}
    
    public int InsertToDatabase(String table, String fields, String values) {
    	String query;
    	String[] valuesArray;
    	
    	int fieldNum;
    	
    	if (table == null || table.isEmpty() || fields == null || fields.isEmpty() || values == null || values.isEmpty()) {
    	    return 1; // If any string is empty
    	}
    	else if ( (fieldNum = fields.split(",").length) != (values.split(",").length) ) {
    		return 2; // If fields number not equal values number
    	}
    	
    	// Construct Query
    	query = "INSERT INTO `" + table + "` (" + fields + ") VALUES (";
    	for (int i = 0; i < fieldNum - 1; ++i) {
    		query += "?, ";
    	}
    	query += "?)";
    	
    	
    	// Prepare the SQL Statement
    	try {
			preparedStatement = conn.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	valuesArray = values.split(",");
    	
    	for (int i = 0; i < fieldNum; ++i) {
    		try {
				preparedStatement.setString(i + 1, valuesArray[i]);
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
    	
    	// Execute
    	try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	return 0;
    }
    
    public void FetchFromDatabase(String table, String fields, String condition) {
    	// Construct Query
    	
    	
    	// Execute
    }
    
}
