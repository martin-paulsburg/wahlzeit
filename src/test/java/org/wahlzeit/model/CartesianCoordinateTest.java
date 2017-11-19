package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CartesianCoordinateTest {

	private CartesianCoordinate coord1;
	private CartesianCoordinate coord2;
	private CartesianCoordinate coord3;
	private CartesianCoordinate coord4;
	
	@Before
	public void SetUp() {
		coord1 = new CartesianCoordinate(4, 5, 6);
		coord2 = new CartesianCoordinate(coord1);
		coord3 = new CartesianCoordinate();
		coord4 = new CartesianCoordinate(0, 0, 0);
	}
	@Test
	public void testGetX() {
		assertTrue(Double.compare(coord1.getX(), 4)==0);
	}

	@Test
	public void testSetX() {
		coord3.setX(4);
		assertTrue(Double.compare(coord3.getX(), 4)==0);
	}

	@Test
	public void testGetY() {
		assertTrue(Double.compare(coord1.getY(), 5)==0);
	}

	@Test
	public void testSetY() {
		coord3.setY(5);
		assertTrue(Double.compare(coord3.getY(), 5)==0);
	}

	@Test
	public void testGetZ() {
		assertTrue(Double.compare(coord1.getZ(), 6)==0);
	}

	@Test
	public void testSetZ() {
		coord3.setZ(6);
		assertTrue(Double.compare(coord3.getZ(), 6)==0);
	}

	@Test
	public void testAsCartesianCoordinate() {
		assertTrue(coord1.isEqual(coord1.asCartesianCoordinate()));
	}

	@Test
	public void testAsSphericCoordinate() {
		SphericCoordinate testCoord = new SphericCoordinate(0, 0, 0);
		assertTrue(testCoord.isEqual(coord4.asSphericCoordinate()));
	}

	@Test
	public void testGetCartesianDistance() {
		assertTrue(Double.compare(Math.sqrt(77.0), coord1.getCartesianDistance(coord4))==0);
	}

	@Test
	public void testGetSphericDistance() {
		assertTrue(Double.compare(Math.sqrt(77.0), coord1.getCartesianDistance(coord4))==0);
	}

	@Test
	public void testGetDistance() {
		assertTrue(Double.compare(Math.sqrt(77.0), coord1.getCartesianDistance(coord4))==0);
	}

	@Test
	public void testIsEqual() {
		assertTrue(coord1.isEqual(coord2));
	}

}
