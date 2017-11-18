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
		 * Location1 same coordinates as location2 for Equals test location3 at 0-0-0
		 * for distance test location 1,2 and 4 have a distance of 5.0 to location3
		 */
		location1 = new Location(new CartesianCoordinate(0.0, 3.0, 4.0));
		location2 = new Location(new CartesianCoordinate(0.0, 3.0, 4.0));
		location3 = new Location(new CartesianCoordinate());
		location4 = new Location(new CartesianCoordinate(3.0, 4.0, 0.0));

	}

	@Test
	public void testEquals() {
		assertTrue(location1.equals(location2));
		assertFalse(location1.equals(location3));
	}

	@Test
	public void testDistance() {
		assertTrue(Double.compare(location1.getPosition().getDistance(location3.getPosition()), 5.0) == 0);
		assertTrue(Double.compare(location4.getPosition().getDistance(location3.getPosition()), 5.0) == 0);
		assertTrue(Double.compare(location1.getPosition().getDistance(location2.getPosition()), 0.0) == 0);
	}

}
