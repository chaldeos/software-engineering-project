import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class RegisterLogin {
	private static String salt = "5jgDZ4AoVK6IBbKeKUPR"; // It is strongly recommended to change before installation
	
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
			res = db.fetchFromDatabase("users", "username, password, firstname, surname, tin, address, phone, sex, type", "username='" + username + "' AND password='" + password + "'");
			if (res == null) {
				throw new RegisterLoginException("Wrong username or password");
			}
		} catch (DBIOException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static void register (String username, String password, String firstname, String surname, String tin, String address, String phone, int sex, int type) {
		
		
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
