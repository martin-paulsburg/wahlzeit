package org.wahlzeit.model;


public class Location {
	private Coordinate position;
	
	public Location(Location copy) {
		this.position = copy.position;
	}
	
	public Location(CartesianCoordinate position) {
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
