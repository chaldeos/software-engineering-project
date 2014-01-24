import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTestDriver {

	@Test
	public void testGetBid() {
		Driver dr = null;
		
		try {
			dr = new Driver("driver", "1234");
			assertEquals("Result", 1, dr.getBid());
			
			dr = new Driver("driver_2", "1234");
			assertEquals("Result", -1, dr.getBid());
		} catch (RegisterLoginException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetNumberPlate() {
		Driver dr = null;
		
		try {
			dr = new Driver("driver", "1234");
			assertEquals("Result", "AD123D", dr.getNumberPlate());
			
			dr = new Driver("driver_2", "1234");
			assertEquals("Result", null, dr.getNumberPlate());
		} catch (RegisterLoginException e) {
			e.printStackTrace();
		}
		
	}
}
