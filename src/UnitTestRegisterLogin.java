import static org.junit.Assert.*;

import org.junit.Test;


public class UnitTestRegisterLogin {

	@Test
	public void testLogin() {
		String[][] userData = null;
		String[][]waitForUserData = {{
			"4", 
			"admin", 
			"f822fb532108ebd2b494dd9f475231b12e59cf4dea4b126f0dd27b9a5f0afa45942581403dd6ceb7cd3e84836c90a085ec94e7459a5b8d7bf56035ae81a328d3", 
			"admin", 
			"admin", 
			"123456789", 
			"123456", 
			"1234567890", 
			"0",
			"0"
		}};
		
		try {
			userData = RegisterLogin.login("admin", "1234");
			assertEquals("Result", waitForUserData[0][0], userData[0][0]);
			assertEquals("Result", waitForUserData[0][1], userData[0][1]);
			assertEquals("Result", waitForUserData[0][2], userData[0][2]);
			assertEquals("Result", waitForUserData[0][3], userData[0][3]);
			assertEquals("Result", waitForUserData[0][4], userData[0][4]);
			assertEquals("Result", waitForUserData[0][5], userData[0][5]);
			assertEquals("Result", waitForUserData[0][6], userData[0][6]);
			assertEquals("Result", waitForUserData[0][7], userData[0][7]);
			assertEquals("Result", waitForUserData[0][8], userData[0][8]);
			assertEquals("Result", waitForUserData[0][9], userData[0][9]);
		} catch (RegisterLoginException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			userData = RegisterLogin.login("admin", "4321"); // Throws Wrong username or password exception
			assertEquals("Result", null, userData);
		} catch (RegisterLoginException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testRegister() { // Delete user emp_lo from database if already exists before run
		String[][] userData = null;
		String[][] dataToRegister = {{
			"emp_lo",
			"1234567", 
			"Χρήστος", 
			"Χρήστου", 
			"123456789", 
			"123456", 
			"1234567890", 
			"0",
			"1"
		}};
		
		
		try {
			RegisterLogin.register(dataToRegister[0][0], dataToRegister[0][1], dataToRegister[0][2], dataToRegister[0][3], dataToRegister[0][4], dataToRegister[0][5], dataToRegister[0][6], Integer.parseInt(dataToRegister[0][7]), Integer.parseInt(dataToRegister[0][8]));
			userData = RegisterLogin.login(dataToRegister[0][0], "1234567");
			assertEquals("Result", dataToRegister[0][0], userData[0][1]);
			assertEquals("Result", "71a806f64f136e7ab9fdcb9e6d4a346bd7386f7732a044ea045ac21da9b2a1096f57d704ba86855b72cb634dacde7a7dd4337a0408beac61e8dd40609ee62242", userData[0][2]);
			assertEquals("Result", dataToRegister[0][2], userData[0][3]);
			assertEquals("Result", dataToRegister[0][3], userData[0][4]);
			assertEquals("Result", dataToRegister[0][4], userData[0][5]);
			assertEquals("Result", dataToRegister[0][5], userData[0][6]);
			assertEquals("Result", dataToRegister[0][6], userData[0][7]);
			assertEquals("Result", dataToRegister[0][7], userData[0][8]);
			assertEquals("Result", dataToRegister[0][8], userData[0][9]);
		} 
		catch (RegisterLoginException e) {
			System.out.println(e.getMessage());
		}
		catch (DBIOException e) {
			System.out.println(e.getMessage());
		}

	}

}
