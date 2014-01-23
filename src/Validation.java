
public class Validation {
	
	public static String validateUsername (String data) {
		if (data == null || data.isEmpty()) {
			return "The username cannot be empty";
		}
		else if (data.length() > 255) {
			return "Username must not be more than 255 characters";
		}
		else if (data.length() < 4) {
			return "Username must be at least 4 characters";
		}
		
		// Connect to database
		String[][] res;
		Database db = new Database();
		db.mysqlConnect();
				
		// Check if username allready exists
		try {
			res = db.fetchFromDatabase("users", "uid", "username='" + data + "'");
			if (res != null) {
				return "The username allready exists";
			}
		} catch (DBIOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
			
	public static String validatePassword (String data) {
		if (data == null || data.isEmpty()) {
			return "The password cannot be empty";
		}
		else if (data.length() < 6) {
			return "Password must be at least 6 characters";
		}

		return null;
	}
	
	public static String validateFirstname (String data) {
		if (data == null || data.isEmpty()) {
			return "The firstname cannot be empty";
		}
		else if (data.length() > 255) {
			return "Firstname must not be more than 255 characters";
		}

		return null;
	}
	
	public static String validateSurname (String data) {
		if (data == null || data.isEmpty()) {
			return "The surname cannot be empty";
		}
		else if (data.length() > 255) {
			return "Surname must not be more than 255 characters";
		}

		return null;
	}
	
	public static String validateTin(String data) {
		if (data == null || data.isEmpty()) {
			return "The Tax Identify Number cannot be empty";
		}
		else if (data.length() != 9 || !isNumeric(data)) {
			return "Invalid Tax Identify Number";
		}

		return null;
	}
	
	public static String validateAddress (String data) {
		if (data == null || data.isEmpty()) {
			return "The address cannot be empty";
		}
		else if (data.length() > 255) {
			return "Address must not be more than 255 characters";
		}

		return null;
	}
	
	public static String validatePhone(String data) {
		if (data == null || data.isEmpty()) {
			return "The phone cannot be empty";
		}
		else if (data.length() != 10 || !isNumeric(data)) {
			return "Invalid phone number";
		}

		return null;
	}
	
	public static String validateSex (int data) {
		if (data != 0 && data != 1) {
			return "Invalid sex value";
		}

		return null;
	}
	
	public static String validateType (int data) {
		if (data != 0 && data != 1 && data != 2) {
			return "Invalid user type value";
		}

		return null;
	}
		
	public static boolean isNumeric (String str) {
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
}
