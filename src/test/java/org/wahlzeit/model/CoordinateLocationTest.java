package org.wahlzeit.model;

/*import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;*/
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CoordinateLocationTest {
	Location location1;
	Location location2;
	Location location3;
	Location location4;

	@Before
	public void setUp() {
		/*
		 * Location1 same coordinates as location2 for Equals test
		 * location3 at 0-0-0 for distance test
		 * location
		 * 1,2 and 4 have a distance of 5.0 to location3
		 */
		location1 = new Location();
		location2 = new Location();
		location3 = new Location();
		location4 = new Location();
		
		location1.position.x = 0.0;
		location1.position.y = 3.0;
		location1.position.z = 4.0;
		
		location2.position.x = 0.0;
		location2.position.y = 3.0;
		location2.position.z = 4.0;
		
		location3.position.x = 0.0;
		location3.position.y = 0.0;
		location3.position.z = 0.0;
		
		location4.position.x = 3.0;
		location4.position.y = 4.0;
		location4.position.z = 0.0;
	}

	@Test
	public void testEquals() {
		assertTrue(location1.equals(location2));
		assertFalse(location1.equals(location3));
	}
	
	@Test
	public void testDistance() {
		assertTrue((location1.position.getDistance(location3.position)==5.0));
		assertTrue((location4.position.getDistance(location3.position)==5.0));
		assertTrue((location1.position.getDistance(location2.position)==0.0));
	}

}
