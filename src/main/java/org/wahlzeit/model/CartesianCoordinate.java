package org.wahlzeit.model;


public class CartesianCoordinate extends AbstractCoordinate {
	private double x=0.0;
	private double y=0.0;
	private double z=0.0;
	
	
	public CartesianCoordinate(){
		
	}
	
	public CartesianCoordinate(CartesianCoordinate copy) {
		assertIsNotNull(copy);
		x=copy.getX();
		y=copy.getY();
		z=copy.getZ();
		assert this.x==copy.getX() : "Constructor failed";
		assert this.y==copy.getY() : "Constructor failed";
		assert this.z==copy.getZ() : "Constructor failed";
		assertClassInvariants();
	}
	
	public CartesianCoordinate(double x, double y, double z) {
		assertIsNotNull(x);
		assertIsNotNull(y);
		assertIsNotNull(z);
		this.x=x;
		this.y=y;
		this.z=z;
		assert this.x==x : "Constructor failed";
		assert this.y==y : "Constructor failed";
		assert this.z==z : "Constructor failed";
		assertClassInvariants();
	}
	
	public double getX() {
		assertClassInvariants();
		return x;
	}

	public void setX(double x) {
		assertClassInvariants();
		assertIsNotNull(x);
		this.x = x;
		assert this.x==x : "setX Failed";
		assertClassInvariants();
	}

	public double getY() {
		assertClassInvariants();
		return y;
	}

	public void setY(double y) {
		assertClassInvariants();
		assertIsNotNull(y);
		this.y = y;
		assert this.y==y : "setY Failed";
		assertClassInvariants();
	}

	public double getZ() {
		assertClassInvariants();
		return z;
	}

	public void setZ(double z) {
		assertClassInvariants();
		assertIsNotNull(z);
		this.z = z;
		assert this.z==z : "setZ Failed";
		assertClassInvariants();
	}

	@Override
	public boolean equals(Object obj) {
		assertClassInvariants();
		if (obj == null) return false;
	    if (obj == this) return true;
	    if (!(obj instanceof CartesianCoordinate)) {
	    	return false;
	    }
	    return isEqual((Coordinate) obj);
	}

	private boolean doIsEqual(CartesianCoordinate checkCoordinate){
		assertClassInvariants();
		if(Double.compare(x, checkCoordinate.x)!=0){
			return false;
		}else if(Double.compare(y, checkCoordinate.y)!=0){
			return false;
		}else if(Double.compare(z, checkCoordinate.z)!=0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants();
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();
		double radius = Math.sqrt(x*x+y*y+z*z);
		if(Double.compare(radius, 0.0)==0) {
			return new SphericCoordinate(0, 0, 0);
		}
		double latitude = Math.toDegrees(Math.asin(z/radius));
		double longitude = Math.toDegrees(Math.atan2(y, x));
		return new SphericCoordinate(latitude, longitude, radius);
	}

	@Override
	public boolean isEqual(Coordinate compareCoordinate) {
		return doIsEqual(compareCoordinate.asCartesianCoordinate());
	}

	@Override
	protected void assertClassInvariants() {
		assertIsNotNull(this);
	}
}
