package org.wahlzeit.model;


public abstract class AbstractCoordinate implements Coordinate {
	
	protected abstract void assertClassInvariants();

	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();

	@Override
	public abstract SphericCoordinate asSphericCoordinate();

	@Override
	public double getCartesianDistance(Coordinate compareCoordinate) {
		assertClassInvariants();
		assertIsNotNull(compareCoordinate);
		
		double dx = this.asCartesianCoordinate().getX() - compareCoordinate.asCartesianCoordinate().getX();
		double dy = this.asCartesianCoordinate().getY() - compareCoordinate.asCartesianCoordinate().getY();
		double dz = this.asCartesianCoordinate().getZ() - compareCoordinate.asCartesianCoordinate().getZ();
		double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
		
		//no invariantCheck necessary becaus no change is made
		
		return dist;
	}

	@Override
	public double getSphericDistance(Coordinate compareCoordinate) {
		assertClassInvariants();
		assertIsNotNull(compareCoordinate);
		
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
		//no invariantCheck necessary becaus no change is made
		
		return Math.toRadians(arc)*this.asSphericCoordinate().getRadius();
	}

	@Override
	public double getDistance(Coordinate compareCoordinate) {
		
		//no assertion checks necessary because all checs are made in the getCartesianDistance
		
		return this.getCartesianDistance(compareCoordinate);
	}

	protected void assertIsNotNull(Object obj) {
		assert obj!=null : "argument is NULL!";
	}
	
	@Override
	public abstract boolean isEqual(Coordinate comareCoordinate);

}
