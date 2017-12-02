package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {

	private double latitude = 0.0;
	private double longitude = 0.0;
	private double radius = 0.0;

	public SphericCoordinate() {

	}

	public SphericCoordinate(SphericCoordinate copy) {
		assertIsNotNull(copy);
		latitude = copy.getLatitude();
		longitude = copy.getLongitude();
		radius = copy.getRadius();
		assert Double.compare(this.latitude, copy.getLatitude()) == 0 : "Latitiude not set correctly";
		assert Double.compare(this.longitude, copy.getLongitude()) == 0 : "longitude not set correctly";
		assert Double.compare(this.radius, copy.getRadius()) == 0 : "radius not set correctly";
		assertClassInvariants();
	}

	public SphericCoordinate(double latitude, double longitude, double radius) {
		assertIsNotNull(latitude);
		assertIsNotNull(longitude);
		assertIsNotNull(radius);
		assert radius >= 0 : "radius should be greater 0";
		assert (latitude >= -90) && (latitude <= 90) : "latitude should be betwenn -90 and 90";
		assert (longitude >= -180) && (longitude <= 180) : "longitude should be betwenn -180 and 180";
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		assert Double.compare(this.latitude, latitude) == 0 : "Latitiude not set correctly";
		assert Double.compare(this.longitude, longitude) == 0 : "longitude not set correctly";
		assert Double.compare(this.radius, radius) == 0 : "radius not set correctly";
		assertClassInvariants();
	}

	public double getLatitude() {
		assertClassInvariants();
		return latitude;
	}

	public void setRadius(double radius) {
		assertClassInvariants();
		assertIsNotNull(radius);
		assert radius >= 0 : "radius should be greater 0";
		this.radius = radius;
		assert Double.compare(this.radius, radius) == 0 : "radius not set correctly";
		assertClassInvariants();
	}

	public void setLatitude(double latitude) {
		assertClassInvariants();
		assertIsNotNull(latitude);
		assert (latitude >= -90) && (latitude <= 90) : "latitude should be betwenn -90 and 90";
		this.latitude = latitude;
		assert Double.compare(this.latitude, latitude) == 0 : "Latitiude not set correctly";
		assertClassInvariants();
	}

	public double getLongitude() {
		assertClassInvariants();
		return longitude;
	}

	public void setLongitude(double longitude) {
		assertClassInvariants();
		assertIsNotNull(longitude);
		assert (longitude >= -180) && (longitude <= 180) : "longitude should be betwenn -180 and 180";
		this.longitude = longitude;
		assert Double.compare(this.longitude, longitude) == 0 : "longitude not set correctly";
		assertClassInvariants();
	}

	public double getRadius() {
		assertClassInvariants();
		return radius;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants();
		double x = radius * Math.sin(Math.toRadians(latitude)) * Math.cos(Math.toRadians(longitude));
		double y = radius * Math.sin(Math.toRadians(latitude)) * Math.sin(Math.toRadians(longitude));
		double z = radius * Math.cos(Math.toRadians(latitude));
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();
		return this;
	}

	@Override
	public boolean isEqual(Coordinate compareCoordinate) {
		assertClassInvariants();
		SphericCoordinate testCoordinate = compareCoordinate.asSphericCoordinate();
		return ((Double.compare(latitude, testCoordinate.latitude) == 0)
				&& (Double.compare(longitude, testCoordinate.longitude) == 0)
				&& (Double.compare(radius, testCoordinate.radius) == 0));
	}

	@Override
	protected void assertClassInvariants() {
		assertIsNotNull(this);
	}

}
