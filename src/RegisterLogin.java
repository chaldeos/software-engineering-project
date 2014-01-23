import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class RegisterLogin {
	private static String salt = "5jgDZ4AoVK6IBbKeKUPR"; // It is strongly recommended to change before installation
	
	public static void login (String username, String password) {
		password = passwordHashGen(password);
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
