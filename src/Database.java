import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Types;

public class Database {
	private Connection conn = null;
	private ResultSet resultSet = null;
	
	// Connects to database and sets the conn property
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
    
    // Inserts a new recored in a database table
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
    
    // Updated a value of a field in a database table and returns the number of the affected rows
    public int updateDatabase(String table, String field, String value, String condition) throws DBIOException {
    	PreparedStatement preparedStatement = null;
    	String query;
    	int affectedRows = 0;
    	
    	if (table == null || table.isEmpty() || field == null || field.isEmpty() || value == null || value.isEmpty() || condition == null || condition.isEmpty()) {
    		throw new DBIOException("One or more arguments are empty");
    	}
    	
    	// Construct Query
    	query = "UPDATE " + table + " SET " + field + "=? WHERE " + condition;
    	
    	// Prepare the SQL Statement
    	try {
			preparedStatement = conn.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	try {
    		if (value == "NULL") {
    			preparedStatement.setNull(1, Types.NULL);
    		}
    		else {
    			preparedStatement.setString(1, value);
    		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	// Execute
    	try {
    		affectedRows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
		return affectedRows;
    }
    
    // Fetches all specified fields from a database table
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
    	try {
			if (!resultSet.isBeforeFirst()) {
				throw new DBIOException("Query returned no results");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
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
