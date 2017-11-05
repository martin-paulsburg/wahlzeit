package org.wahlzeit.model;


public class Coordinate {
	private double x=0.0;
	private double y=0.0;
	private double z=0.0;
	
	
	public Coordinate(){
		
	}
	
	public Coordinate(Coordinate copy) {
		x=copy.getX();
		y=copy.getY();
		z=copy.getZ();
	}
	
	public Coordinate(double x, double y, double z) {
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

	double getDistance(Coordinate otherCoordinate){
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
	    if (!(obj instanceof Coordinate)) {
	    	return false;
	    }
	    return isEqual((Coordinate) obj);
	}

	boolean isEqual(Coordinate checkCoordinate){
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
}
