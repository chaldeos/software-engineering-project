import static org.junit.Assert.*;

import org.junit.Test;


public class UnitTestDatabase {

	@Test
	public void testFetchFromDatabase() {
		Database db;
		String[][] waitForBuss = {{
					"AD123D", 
					"1200",
		}}, Buss;
		
				
		db = new Database();
		db.mysqlConnect();
		try {
			Buss = db.fetchFromDatabase("busses", "numberplate, cc", "bid=1");
			assertEquals("Result", Buss, waitForBuss);
		} catch (DBIOException e) {
			e.printStackTrace();
		}
		
	}

}
