package org.wahlzeit.model;


public class Coordinate {
	public double x=0;
	public double y=0;
	public double z=0;
	
	double getDistance(Coordinate otherCoordinate){
		double dx=x-otherCoordinate.x;
		double dy=y-otherCoordinate.y;
		double dz=z-otherCoordinate.z;
		double dist=Math.sqrt(dx*dx+dy*dy+dz*dz);
		return dist;
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
