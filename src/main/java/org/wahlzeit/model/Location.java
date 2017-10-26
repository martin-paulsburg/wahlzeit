package org.wahlzeit.model;
import org.wahlzeit.model.Coordinate;

public class Location {
	public Coordinate position;
	boolean equals(Location compLocation){
		return position.isEqual(compLocation.position);
	}
}
