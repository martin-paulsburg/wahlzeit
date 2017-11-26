package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {

	private double latitude = 0.0;
	private double longitude = 0.0;
	private double radius = 0.0;

	public SphericCoordinate() {

	}

	public SphericCoordinate(SphericCoordinate copy) {
		latitude = copy.getLatitude();
		longitude = copy.getLongitude();
		radius = copy.getRadius();
	}

	public SphericCoordinate(double lattitude, double longitude, double radius) {
		this.latitude = lattitude;
		this.longitude = longitude;
		this.radius = radius;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double x = radius * Math.sin(Math.toRadians(latitude)) * Math.cos(Math.toRadians(longitude));
		double y = radius * Math.sin(Math.toRadians(latitude)) * Math.sin(Math.toRadians(longitude));
		double z = radius * Math.cos(Math.toRadians(latitude));
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}


	@Override
	public boolean isEqual(Coordinate compareCoordinate) {
		SphericCoordinate testCoordinate = compareCoordinate.asSphericCoordinate();
		return ((Double.compare(latitude, testCoordinate.latitude) == 0)
				&& (Double.compare(longitude, testCoordinate.longitude) == 0)
				&& (Double.compare(radius, testCoordinate.radius) == 0));
	}

}
