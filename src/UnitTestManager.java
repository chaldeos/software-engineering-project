import static org.junit.Assert.*;

import org.junit.Test;


public class UnitTestManager {

	@Test
	public void testGetBusses() {
		Manager mg = null;
		String[][] waitForBuss = {{
			"1", 
			"AD123D", 
			"1200", 
			"Volvo"
		}};
		
		String[][] Buss;
		
		try {
			mg = new Manager("admin", "1234");
			Buss = mg.getBusses("AD123D");
			assertEquals("Result", waitForBuss[0][0], Buss[0][0]);
			assertEquals("Result", waitForBuss[0][1], Buss[0][1]);
			assertEquals("Result", waitForBuss[0][2], Buss[0][2]);
			assertEquals("Result", waitForBuss[0][3], Buss[0][3]);
		} catch (RegisterLoginException | DBIOException e) {
			e.printStackTrace();
		}
	}

}
