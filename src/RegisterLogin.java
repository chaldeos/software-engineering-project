import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class RegisterLogin {
	private static String salt = "5jgDZ4AoVK6IBbKeKUPR"; // It is strongly recommended to change before installation
	
	// Logins a user to the system
	public static String[][] login (String username, String password) throws RegisterLoginException {
		String[][] res = null;
		
		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
			throw new RegisterLoginException("Password or Username fields are empty");
		}
		else if (username.length() > 255) {
			throw new RegisterLoginException("Username must not be more than 255 characters");
		}
		
		// Create the password hash
		password = passwordHashGen(password);
		
		// Connect to database
		Database db = new Database();
		db.mysqlConnect();
		
		// Check if username - password hash combination exists
		try {
			res = db.fetchFromDatabase("users", "uid, username, password, firstname, surname, tin, address, phone, sex, type", "username='" + username + "' AND password='" + password + "'");
			if (res == null) {
				throw new RegisterLoginException("Wrong username or password");
			}
		} catch (DBIOException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	// Registers a user to the system
	public static String register (String username, String password, String firstname, String surname, String tin, String address, String phone, int sex, int type) throws RegisterLoginException {
		String[] errors = new String[9];
		String errorMsg = "";
		
		// Validate submitted fields
		errors[0] = Validation.validateUsername(username);
		errors[1] = Validation.validatePassword(password);
		errors[2] = Validation.validateFirstname(firstname);
		errors[3] = Validation.validateSurname(surname);
		errors[4] = Validation.validateTin(tin);
		errors[5] = Validation.validateAddress(address);
		errors[6] = Validation.validatePhone(phone);
		errors[7] = Validation.validateSex(sex);
		errors[8] = Validation.validateType(type);
    	
		for (int i = 0; i < 9; ++i) {
			if (errors[i] != null) {
				errorMsg += errors[i] + "\n";
			}
		}
		
		if (errorMsg == "") { // If no errors then register the user
			Database db = new Database();
			db.mysqlConnect();
			try {
				db.insertToDatabase("users", "username, password, firstname, surname, tin, address, phone, sex, type", username + "," + password + "," + firstname + "," + surname + "," + tin + "," + address + "," + phone + "," + sex + "," + type);
			} catch (DBIOException e) {
				e.printStackTrace();
			}
		}
		
		return errorMsg;
	}

	// Generates the salted SHA-512 hash of a password
	private static String passwordHashGen (String password) {
		byte[] hash = null;
		
		Security.addProvider(new BouncyCastleProvider());

		MessageDigest mda;
		try {
			mda = MessageDigest.getInstance("SHA-512", "BC");
			hash = mda.digest((password + salt).getBytes());
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			e.printStackTrace();
		}
		
		return Hex.encodeHexString(hash);
	}
	
}
