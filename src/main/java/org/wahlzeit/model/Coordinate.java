package org.wahlzeit.model;

public interface Coordinate {
	public CartesianCoordinate asCartesianCoordinate();
	public SphericCoordinate asSphericCoordinate();
	public double getCartesianDistance(Coordinate compareCoordinate);
	public double getSphericDistance(Coordinate compareCoordinate);
	public double getDistance(Coordinate compareCoordinate);
	public boolean isEqual(Coordinate comareCoordinate);
}