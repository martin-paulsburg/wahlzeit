package org.wahlzeit.model;

import java.io.InvalidObjectException;

public class SphericCoordinate extends AbstractCoordinate {

	private double latitude = 0.0;
	private double longitude = 0.0;
	private double radius = 0.0;

	public SphericCoordinate() {

	}

	public SphericCoordinate(SphericCoordinate copy) throws InvalidObjectException {
		assertIsNotNull(copy);
		latitude = copy.getLatitude();
		longitude = copy.getLongitude();
		radius = copy.getRadius();
		assert Double.compare(this.latitude, copy.getLatitude()) == 0 : "Latitiude not set correctly";
		assert Double.compare(this.longitude, copy.getLongitude()) == 0 : "longitude not set correctly";
		assert Double.compare(this.radius, copy.getRadius()) == 0 : "radius not set correctly";
		assertClassInvariants();
	}

	public SphericCoordinate(double latitude, double longitude, double radius) throws IllegalArgumentException, InvalidObjectException{
		try {
			assertLatitude(latitude);
			assertLongitude(longitude);
			assertRadius(radius);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(
					"one of the Parameters is NULL or out of range @SphericCoordinate construktor", e);
		}
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		assert Double.compare(this.latitude, latitude) == 0 : "Latitiude not set correctly";
		assert Double.compare(this.longitude, longitude) == 0 : "longitude not set correctly";
		assert Double.compare(this.radius, radius) == 0 : "radius not set correctly";
		assertClassInvariants();
	}

	public double getLatitude() throws InvalidObjectException{
		assertClassInvariants();
		return latitude;
	}

	public void setRadius(double radius) throws IllegalArgumentException, InvalidObjectException {
		assertClassInvariants();
		try {
			assertRadius(radius);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("@SphericCoordinate set Radius", e);
		}
		this.radius = radius;
		assert Double.compare(this.radius, radius) == 0 : "radius not set correctly";
		assertClassInvariants();
	}

	public void setLatitude(double latitude) throws IllegalArgumentException, InvalidObjectException {
		assertClassInvariants();
		try {
			assertLatitude(latitude);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("@SphericCoordinate setLatitude", e);
		}
		this.latitude = latitude;
		assert Double.compare(this.latitude, latitude) == 0 : "Latitiude not set correctly";
		assertClassInvariants();
	}

	public double getLongitude() throws InvalidObjectException {
		assertClassInvariants();
		return longitude;
	}

	public void setLongitude(double longitude) throws IllegalArgumentException, InvalidObjectException {
		assertClassInvariants();
		try {
			assertLongitude(longitude);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("@SphericCoordinate setLongitude", e);
		}
		this.longitude = longitude;
		assert Double.compare(this.longitude, longitude) == 0 : "longitude not set correctly";
		assertClassInvariants();
	}

	public double getRadius() throws InvalidObjectException {
		assertClassInvariants();
		return radius;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() throws InvalidObjectException {
		assertClassInvariants();
		double x = radius * Math.sin(Math.toRadians(latitude)) * Math.cos(Math.toRadians(longitude));
		double y = radius * Math.sin(Math.toRadians(latitude)) * Math.sin(Math.toRadians(longitude));
		double z = radius * Math.cos(Math.toRadians(latitude));
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() throws InvalidObjectException {
		assertClassInvariants();
		return this;
	}

	@Override
	public boolean isEqual(Coordinate compareCoordinate) throws InvalidObjectException {
		assertClassInvariants();
		SphericCoordinate testCoordinate = compareCoordinate.asSphericCoordinate();
		return ((Double.compare(latitude, testCoordinate.latitude) == 0)
				&& (Double.compare(longitude, testCoordinate.longitude) == 0)
				&& (Double.compare(radius, testCoordinate.radius) == 0));
	}

	@Override
	protected void assertClassInvariants() throws InvalidObjectException {
		//TODO: invalid conditions
		try {
			assertLatitude(latitude);
			assertLongitude(longitude);
			assertRadius(radius);
		}catch(IllegalArgumentException e){
			throw new InvalidObjectException("Object is in invalid state (object is NULL");
		}
	}

	private void assertLatitude(double latitude) throws IllegalArgumentException {
		try {
			assertIsNotNull(latitude);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("latitude is NULL", e);
		}
		if ((latitude <= -90.0) && (latitude >= 90.0)) {
			throw new IllegalArgumentException("latitude is out of range");
		}
	}

	private void assertLongitude(double longitude) throws IllegalArgumentException {
		try {
			assertIsNotNull(longitude);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("longitude is NULL", e);
		}
		if ((longitude <= -180) && (longitude >= 180)) {
			throw new IllegalArgumentException("longitude is out of range");
		}
	}

	private void assertRadius(double radius) throws IllegalArgumentException {
		try {
			assertIsNotNull(radius);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("radius is NULL", e);
		}
		if (radius < 0.0) {
			throw new IllegalArgumentException("radius is out of range");
		}
	}

}
