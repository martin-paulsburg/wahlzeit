package org.wahlzeit.model;


public class CartesianCoordinate implements Coordinate {
	private double x=0.0;
	private double y=0.0;
	private double z=0.0;
	
	
	public CartesianCoordinate(){
		
	}
	
	public CartesianCoordinate(CartesianCoordinate copy) {
		x=copy.getX();
		y=copy.getY();
		z=copy.getZ();
	}
	
	public CartesianCoordinate(double x, double y, double z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	private double doGetDistance(CartesianCoordinate otherCoordinate){
		double dx=x-otherCoordinate.x;
		double dy=y-otherCoordinate.y;
		double dz=z-otherCoordinate.z;
		double dist=Math.sqrt(dx*dx+dy*dy+dz*dz);
		return dist;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
	    if (obj == this) return true;
	    if (!(obj instanceof CartesianCoordinate)) {
	    	return false;
	    }
	    return isEqual((Coordinate) obj);
	}

	private boolean doIsEqual(CartesianCoordinate checkCoordinate){
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
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(x*x+y*y+z*z);
		if(Double.compare(radius, 0.0)==0) {
			return new SphericCoordinate(0, 0, 0);
		}
		double latitude = 90-Math.asin(z/radius);
		double longitude = Math.atan2(y, x);
		return new SphericCoordinate(latitude, longitude, radius);
	}

	@Override
	public double getCartesianDistance(Coordinate compareCoordinate) {
		return getDistance(compareCoordinate);
	}

	@Override
	public double getSphericDistance(Coordinate compareCoordinate) {
		return getDistance(compareCoordinate);
	}

	@Override
	public double getDistance(Coordinate compareCoordinate) {
		return doGetDistance(compareCoordinate.asCartesianCoordinate());
	}

	@Override
	public boolean isEqual(Coordinate compareCoordinate) {
		return doIsEqual(compareCoordinate.asCartesianCoordinate());
	}
}
