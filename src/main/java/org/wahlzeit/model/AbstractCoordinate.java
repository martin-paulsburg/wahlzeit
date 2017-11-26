package org.wahlzeit.model;


public abstract class AbstractCoordinate implements Coordinate {

	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();

	@Override
	public abstract SphericCoordinate asSphericCoordinate();

	@Override
	public double getCartesianDistance(Coordinate compareCoordinate) {
		double dx = this.asCartesianCoordinate().getX() - compareCoordinate.asCartesianCoordinate().getX();
		double dy = this.asCartesianCoordinate().getY() - compareCoordinate.asCartesianCoordinate().getY();
		double dz = this.asCartesianCoordinate().getZ() - compareCoordinate.asCartesianCoordinate().getZ();
		double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
		return dist;
	}

	@Override
	public double getSphericDistance(Coordinate compareCoordinate) {
		if(this.asSphericCoordinate().getRadius()-compareCoordinate.asSphericCoordinate().getRadius()>0.0000001) {
			return -1;
		}
		// for same radius
		double arc = Math.sin(Math.toRadians((this.asSphericCoordinate().getLatitude())))
				* Math.sin(Math.toRadians(compareCoordinate.asSphericCoordinate().getLatitude()))
				+ Math.cos(Math.toRadians(this.asSphericCoordinate().getLatitude()))
						* Math.cos(Math.toRadians(compareCoordinate.asSphericCoordinate().getLatitude()))
						* Math.cos(Math.toRadians(compareCoordinate.asSphericCoordinate().getLongitude()
								- this.asSphericCoordinate().getLongitude()));
		return Math.toRadians(arc)*this.asSphericCoordinate().getRadius();
	}

	@Override
	public double getDistance(Coordinate compareCoordinate) {
		return this.getCartesianDistance(compareCoordinate);
	}

	@Override
	public abstract boolean isEqual(Coordinate comareCoordinate);

}
