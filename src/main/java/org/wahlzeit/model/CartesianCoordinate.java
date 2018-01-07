package org.wahlzeit.model;

import java.io.InvalidObjectException;
import java.util.Hashtable;
@DesignPattern{
	name = "Template method pattern",
	participants = {"concrete implementation"}
}
public class CartesianCoordinate extends AbstractCoordinate {
	private double x = 0.0;
	private double y = 0.0;
	private double z = 0.0;

	protected static Hashtable<Integer, Coordinate> CoordinateTable;

	public static Coordinate getCoordiante(double x, double y, double z) {
		// find coordinate if exists
		Coordinate returnCoordinate = CoordinateTable.get(doHashCode(x, y, z));
		// if not make new one
		if (returnCoordinate == null) {
			try {
				returnCoordinate = new CartesianCoordinate(x, y, z);
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

	private static int doHashCode(double x, double y, double z) {
		int hash = 1;
		hash = (int) (hash * 13 + ('x' + x));
		hash = (int) (hash * 58 + ('y' + y));
		hash = (int) (hash * 95 + ('z' + z));
		return hash;
	}

	@Override
	public int hashCode() {
		return doHashCode(x, y, z);

	}

	private CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException, InvalidObjectException {
		try {
			assertDoubleVaiable(x);
			assertDoubleVaiable(y);
			assertDoubleVaiable(z);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("@CartesianCoordinate constructor fialed", e);
		}
		CoordinateTable.put(hashCode(), this);
		this.x = x;
		this.y = y;
		this.z = z;
		assert this.x == x : "Constructor failed";
		assert this.y == y : "Constructor failed";
		assert this.z == z : "Constructor failed";
		assertClassInvariants();
	}

	public double getX() throws InvalidObjectException {
		assertClassInvariants();
		return x;
	}

	public double getY() throws InvalidObjectException {
		assertClassInvariants();
		return y;
	}

	public double getZ() throws InvalidObjectException {
		assertClassInvariants();
		return z;
	}

	@Override
	public boolean equals(Object obj) {
		//TODO: equals /isEqual for immutable/shared value
		// assertClassInvariants(); assertion not working because of standard equals
		// function signature
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof CartesianCoordinate)) {
			return false;
		}
		try {
			return isEqual((Coordinate) obj);
		} catch (InvalidObjectException e) {
			// no good error handling
			return false;
		}
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() throws InvalidObjectException {
		assertClassInvariants();
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() throws InvalidObjectException, IllegalArgumentException {
		assertClassInvariants();
		double radius = Math.sqrt(x * x + y * y + z * z);
		if (Double.compare(radius, 0.0) == 0) {
			return (SphericCoordinate) SphericCoordinate.getCoordiante(0, 0, 0);
		}
		double latitude = Math.toDegrees(Math.asin(z / radius));
		double longitude = Math.toDegrees(Math.atan2(y, x));
		return (SphericCoordinate) SphericCoordinate.getCoordiante(latitude, longitude, radius);
	}

	@Override
	public boolean isEqual(Coordinate compareCoordinate) throws InvalidObjectException {
		CartesianCoordinate testCoordinate = compareCoordinate.asCartesianCoordinate();
		return testCoordinate == this;
	}

	@Override
	protected void assertClassInvariants() throws InvalidObjectException {
		if ((Double.isNaN(x)) || (Double.isNaN(y)) || (Double.isNaN(z))) {
			throw new InvalidObjectException("Object is in invalid state (some variables are no numbers");
		}
	}

	private void assertDoubleVaiable(double var) throws InvalidObjectException {
		assertIsNotNull(var);
		if (Double.isNaN(var)) {
			throw new InvalidObjectException("variable is not a number");
		}
	}
}
