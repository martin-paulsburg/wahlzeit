package org.wahlzeit.model;

import java.io.InvalidObjectException;

public interface Coordinate {
	public CartesianCoordinate asCartesianCoordinate() throws InvalidObjectException;
	public SphericCoordinate asSphericCoordinate() throws InvalidObjectException;
	public double getCartesianDistance(Coordinate compareCoordinate) throws IllegalArgumentException, InvalidObjectException;
	public double getSphericDistance(Coordinate compareCoordinate) throws IllegalArgumentException, InvalidObjectException;
	public double getDistance(Coordinate compareCoordinate) throws IllegalArgumentException, InvalidObjectException;
	public boolean isEqual(Coordinate comareCoordinate) throws InvalidObjectException;
}