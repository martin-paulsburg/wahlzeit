package org.wahlzeit.model;
import org.wahlzeit.model.Coordinate;

public class Location {
	private Coordinate position;
	
	public Location() {
		position = new Coordinate();
	}
	
	public Location(Location copy) {
		position = new Coordinate(copy.getPosition());
	}
	
	public Location(Coordinate position) {
		this.position = position;
	}
	
	public Coordinate getPosition() {
		return position;
	}

	public void setPosition(Coordinate position) {
		this.position = position;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
	    if (obj == this) return true;
	    if (!(obj instanceof Location)) {
	    	return false;
	    }

	    return position.equals(((Location)obj).getPosition());
	}
}
