package org.wahlzeit.model;

import java.io.InvalidObjectException;

public class CartesianCoordinate extends AbstractCoordinate {
	private double x = 0.0;
	private double y = 0.0;
	private double z = 0.0;

	public CartesianCoordinate() {

	}

	public CartesianCoordinate(CartesianCoordinate copy) throws InvalidObjectException {
		assertIsNotNull(copy);
		x = copy.getX();
		y = copy.getY();
		z = copy.getZ();
		assert this.x == copy.getX() : "Constructor failed";
		assert this.y == copy.getY() : "Constructor failed";
		assert this.z == copy.getZ() : "Constructor failed";
		assertClassInvariants();
	}

	public CartesianCoordinate(double x, double y, double z) throws IllegalArgumentException, InvalidObjectException {
		try {
			assertDoubleVaiable(x);
			assertDoubleVaiable(y);
			assertDoubleVaiable(z);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("@CartesianCoordinate constructor fialed", e);
		}
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

	public void setX(double x) throws IllegalArgumentException, InvalidObjectException{
		assertClassInvariants();
		try {
			assertIsNotNull(x);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("@CartesianCoordinate setX", e);
		}
		this.x = x;
		assert this.x == x : "setX Failed";
		assertClassInvariants();
	}

	public double getY() throws InvalidObjectException {
		assertClassInvariants();
		return y;
	}

	public void setY(double y) throws IllegalArgumentException, InvalidObjectException{
		assertClassInvariants();
		try {
			assertIsNotNull(y);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("@CartesianCoordinate setY", e);
		}
		this.y = y;
		assert this.y == y : "setY Failed";
		assertClassInvariants();
	}

	public double getZ() throws InvalidObjectException {
		assertClassInvariants();
		return z;
	}

	public void setZ(double z) throws IllegalArgumentException, InvalidObjectException{
		assertClassInvariants();
		try {
			assertIsNotNull(z);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("@CartesianCoordinate setZ", e);
		}
		this.z = z;
		assert this.z == z : "setZ Failed";
		assertClassInvariants();
	}

	@Override
	public boolean equals(Object obj) {
		//assertClassInvariants(); assertion not working because of standard equals function signature
		if (obj == null)
			return false;
		if (obj == this)
			return true;
		if (!(obj instanceof CartesianCoordinate)) {
			return false;
		}
		try {
			return isEqual((Coordinate) obj);
		}catch (InvalidObjectException e) {
			//no good error handling
			return false;
		}
	}

	private boolean doIsEqual(CartesianCoordinate checkCoordinate) throws InvalidObjectException {
		assertClassInvariants();
		if (Double.compare(x, checkCoordinate.x) != 0) {
			return false;
		} else if (Double.compare(y, checkCoordinate.y) != 0) {
			return false;
		} else if (Double.compare(z, checkCoordinate.z) != 0) {
			return false;
		} else {
			return true;
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
			return new SphericCoordinate(0, 0, 0);
		}
		double latitude = Math.toDegrees(Math.asin(z / radius));
		double longitude = Math.toDegrees(Math.atan2(y, x));
		return new SphericCoordinate(latitude, longitude, radius);
	}

	@Override
	public boolean isEqual(Coordinate compareCoordinate) throws InvalidObjectException {
		return doIsEqual(compareCoordinate.asCartesianCoordinate());
	}

	@Override
	protected void assertClassInvariants() throws InvalidObjectException {
		if((Double.isNaN(x))||(Double.isNaN(y))||(Double.isNaN(z))) {
			throw new InvalidObjectException("Object is in invalid state (some variables are no numbers");
		}
	}
	private void assertDoubleVaiable(double var) throws InvalidObjectException {
		assertIsNotNull(var);
		if(Double.isNaN(var)) {
			throw new InvalidObjectException("variable is not a number");
		}
	}
}
