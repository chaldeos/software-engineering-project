import static org.junit.Assert.*;

import org.junit.Test;


public class UnitTestManager {

	@Test
	public void testGetBusses() {
		Manager mg = null;
		String[][] waitForBuss = {
			{
				"1", 
				"AD123D", 
				"1200", 
				"Volvo"
			},
			{
				"2",
				"GF236S",
				"10000",
				"Ferrari"
			}
		};
		
		String[][] Buss;
		
		try {
			mg = new Manager("admin", "1234");
			Buss = mg.getBusses("AD123D");
			assertEquals("Result", waitForBuss[0][0], Buss[0][0]);
			assertEquals("Result", waitForBuss[0][1], Buss[0][1]);
			assertEquals("Result", waitForBuss[0][2], Buss[0][2]);
			assertEquals("Result", waitForBuss[0][3], Buss[0][3]);
			
			Buss = mg.getBusses();
			assertEquals("Result", waitForBuss[0][0], Buss[0][0]);
			assertEquals("Result", waitForBuss[0][1], Buss[0][1]);
			assertEquals("Result", waitForBuss[0][2], Buss[0][2]);
			assertEquals("Result", waitForBuss[0][3], Buss[0][3]);
			assertEquals("Result", waitForBuss[1][0], Buss[1][0]);
			assertEquals("Result", waitForBuss[1][1], Buss[1][1]);
			assertEquals("Result", waitForBuss[1][2], Buss[1][2]);
			assertEquals("Result", waitForBuss[1][3], Buss[1][3]);
			
			Buss = mg.getBusses("AER264");
			assertEquals("Result", null, Buss);
		} catch (RegisterLoginException | DBIOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetFuellings() {
		Manager mg = null;
		String[][] waitForFuelling = {
			{
				"1", 
				"1", 
				"100", 
				"1000",
				"2014-01-22 23:54:53.0",
				"Σχόλιο"
			},
			{
				"2", 
				"1", 
				"10", 
				"100",
				"2014-01-22 20:47:41.0",
				null
			}
		};
		
		String[][] Fuelling;
		
		try {
			mg = new Manager("admin", "1234");
			Fuelling = mg.getFuellings();
			assertEquals("Result", waitForFuelling[0][0], Fuelling[0][0]);
			assertEquals("Result", waitForFuelling[0][1], Fuelling[0][1]);
			assertEquals("Result", waitForFuelling[0][2], Fuelling[0][2]);
			assertEquals("Result", waitForFuelling[0][3], Fuelling[0][3]);
			assertEquals("Result", waitForFuelling[0][4], Fuelling[0][4]);
			assertEquals("Result", waitForFuelling[0][5], Fuelling[0][5]);
			assertEquals("Result", waitForFuelling[1][0], Fuelling[1][0]);
			assertEquals("Result", waitForFuelling[1][1], Fuelling[1][1]);
			assertEquals("Result", waitForFuelling[1][2], Fuelling[1][2]);
			assertEquals("Result", waitForFuelling[1][3], Fuelling[1][3]);
			assertEquals("Result", waitForFuelling[1][4], Fuelling[1][4]);
			assertEquals("Result", waitForFuelling[1][5], Fuelling[1][5]);

		} catch (RegisterLoginException | DBIOException e) {
			e.printStackTrace();
		}
	}
}
