package org.wahlzeit.model;
import org.wahlzeit.model.CartesianCoordinate;

public class Location {
	private CartesianCoordinate position;
	
	public Location() {
		position = new CartesianCoordinate();
	}
	
	public Location(Location copy) {
		position = new CartesianCoordinate(copy.getPosition());
	}
	
	public Location(CartesianCoordinate position) {
		this.position = position;
	}
	
	public CartesianCoordinate getPosition() {
		return position;
	}

	public void setPosition(CartesianCoordinate position) {
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
