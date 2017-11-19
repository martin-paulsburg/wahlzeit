package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SphericCoordinateTest {

	private SphericCoordinate coord1;
	private SphericCoordinate coord2;
	private SphericCoordinate coord3;
	private SphericCoordinate coord4;
	@Before
	public void SetUp() {
		coord1 = new SphericCoordinate(5.0, 2.0, 4.0);
		coord2 = new SphericCoordinate(coord1);
		coord3 = new SphericCoordinate(0.0,0.0,0.0);
		coord4 = new SphericCoordinate();
	}
	@Test
	public void testGetLatitude() {
		assertTrue(Double.compare(coord1.getLatitude(), 5.0)==0);
	}

	@Test
	public void testSetRadius() {
		coord4.setRadius(4.0);
		assertTrue(Double.compare(coord4.getRadius(), 4.0)==0);
	}

	@Test
	public void testSetLatitude() {
		coord4.setLatitude(5.0);
		assertTrue(Double.compare(coord4.getLatitude(), 5.0)==0);
	}

	@Test
	public void testGetLongitude() {
		assertTrue(Double.compare(coord1.getLongitude(), 2.0)==0);
	}

	@Test
	public void testSetLongitude() {
		coord4.setLongitude(2.0);
		assertTrue(Double.compare(coord4.getLongitude(), 2.0)==0);
	}

	@Test
	public void testGetRadius() {
		assertTrue(Double.compare(coord1.getRadius(),4.0)==0);
	}

	@Test
	public void testAsCartesianCoordinate() {
		CartesianCoordinate compCoord = new CartesianCoordinate(0, 0, 0);
		assertTrue(compCoord.isEqual(coord3.asCartesianCoordinate()));
	}

	@Test
	public void testAsSphericCoordinate() {
		assertTrue(coord1.isEqual(coord1.asSphericCoordinate()));
	}

	@Test
	public void testGetCartesianDistance() {
		assertTrue(Double.compare(coord1.getCartesianDistance(coord3),4.0)==0);
	}

	@Test
	public void testGetSphericDistance() {
		assertTrue(Double.compare(coord1.getCartesianDistance(coord3),4.0)==0);
	}

	@Test
	public void testGetDistance() {
		System.out.println(coord1.getCartesianDistance(coord3));
		assertTrue(Double.compare(coord1.getCartesianDistance(coord3),4.0)==0);
	}

	@Test
	public void testIsEqual() {
		assertTrue(coord1.isEqual(coord2));
	}

}
