import static org.junit.Assert.*;

import org.junit.Test;


public class UnitTestRegisterLogin {

	@Test
	public void testLogin() {
		try {
			assertEquals("Result", null, RegisterLogin.login("nick", "1234"));
		} catch (RegisterLoginException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRegister() {
		
	}

}
