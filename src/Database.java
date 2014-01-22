import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Database {
	private Connection conn = null;
	private ResultSet resultSet = null;
	
    public void mysqlConnect() {

    	try {
    		
    		try {
    			Class.forName("com.mysql.jdbc.Driver").newInstance();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		
    		// Connect to Database
    		conn = DriverManager.getConnection("jdbc:mysql://localhost/shoft-eng-proj?" + "user=root&password=");

    	} catch (SQLException e) {
    		System.out.println("SQLException: " + e.getMessage());
    		System.out.println("SQLState: " + e.getSQLState());
    		System.out.println("VendorError: " + e.getErrorCode());
    	}
    	
	}
    
    public void insertToDatabase(String table, String fields, String values) throws DBIOException {
    	PreparedStatement preparedStatement = null;
    	String query;
    	String[] valuesArray;
    	int fieldNum;
    	
    	if (table == null || table.isEmpty() || fields == null || fields.isEmpty() || values == null || values.isEmpty()) {
    		throw new DBIOException("One or more arguments are empty");
    	} else if ( (fieldNum = fields.split(",").length) != (values.split(",").length) ) {
    		throw new DBIOException("Number of fields does not match number of values");
    	}
    	
    	// Construct Query
    	query = "INSERT INTO " + table + " (" + fields + ") VALUES (";
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
    	
    }
    
    public String[][] fetchFromDatabase(String table, String fields, String condition) throws DBIOException {
    	PreparedStatement preparedStatement = null;
    	String query;
    	String[] fieldsArray;
    	String[][] result = null;
    	int fieldNum;
    	int rowsNum;
    	
    	if (table == null || table.isEmpty() || fields == null || fields.isEmpty()) {
    		throw new DBIOException("One or more arguments are empty");
    	}
    	
    	fieldsArray = fields.split(","); //Get field names
    	fieldNum = fieldsArray.length; // Get number of fields
    	
    	// Construct Query
    	query = "SELECT " + fields + " FROM " + table;
    	if (condition != null && !condition.isEmpty()) {
    		query += " WHERE " + condition;
    	}
    	
    	// Prepare the SQL Statement
    	try {
			preparedStatement = conn.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	// Execute
    	try {
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	// Check if table is empty
    	if (resultSet == null) {
			throw new DBIOException("Table " + table + " is empty");
	    }
		
    	// Fetch result
		try {
			
			// Get Number of rows
			resultSet.last();
			rowsNum = resultSet.getRow();
			resultSet.first();
			result = new String[rowsNum][fieldNum];
			
			for (int i = 0; i < rowsNum; ++i, resultSet.next()) {
				for (int j = 0; j < fieldNum; ++j) {
					result[i][j] = resultSet.getString(fieldsArray[j].trim());
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
    }
    
}
