package org.wahlzeit.model;

import java.io.InvalidObjectException;
import java.util.Hashtable;
@DesignPattern{
	name = "Template method pattern",
	participants = {"concrete implementation"}
}
public class SphericCoordinate extends AbstractCoordinate {

	private double latitude = 0.0;
	private double longitude = 0.0;
	private double radius = 0.0;
	
	protected static Hashtable<Integer, Coordinate> CoordinateTable;

	public static Coordinate getCoordiante(double lat, double lon, double rad) {
		// find coordinate if exists
		Coordinate returnCoordinate = CoordinateTable.get(doHashCode(lat, lon, rad));
		// if not make new one
		if (returnCoordinate == null) {
			try {
				returnCoordinate = new SphericCoordinate(lat, lon, rad);
			} catch (InvalidObjectException e) {
				// TODO exception handling
				//internal invalid object state (should never reached! -> destroy everything)
				assert(false);
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException(e);
			}
		}
		// return
		return returnCoordinate;
	}

	private static int doHashCode(double lat, double lon, double rad) {
		int hash = 1;
		hash = (int) (hash * 135 + ('a' + lat));
		hash = (int) (hash * 51 + ('o' + lon));
		hash = (int) (hash * 94 + ('r' + rad));
		return hash;
	}

	@Override
	public int hashCode() {
		return doHashCode(latitude, longitude, radius);

	}

	private SphericCoordinate(double latitude, double longitude, double radius) throws IllegalArgumentException, InvalidObjectException{
		try {
			assertLatitude(latitude);
			assertLongitude(longitude);
			assertRadius(radius);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(
					"one of the Parameters is NULL or out of range @SphericCoordinate construktor", e);
		}
		CoordinateTable.put(hashCode(), this);
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

	public double getLongitude() throws InvalidObjectException {
		assertClassInvariants();
		return longitude;
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
		return (CartesianCoordinate) CartesianCoordinate.getCoordiante(x, y, z);
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
		return testCoordinate == this;
	}

	@Override
	protected void assertClassInvariants() throws InvalidObjectException {
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
