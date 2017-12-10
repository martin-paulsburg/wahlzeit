package org.wahlzeit.model;

import java.io.InvalidObjectException;

public class ConstructionDefectPhoto extends Photo {
	
	private String types = ""; //Types seperated by ","
	public ConstructionDefectPhoto() {
		super();
	}
	
	public ConstructionDefectPhoto(PhotoId myId) {
		super(myId);
	}
	public void addType(String type){
		if(type == null) {
			throw new IllegalArgumentException("Type can not be NULL");
		}
		if(type.contains(",")) {
			throw new IllegalArgumentException("Type can not contain a \",\"");
		}
		types = types + "," + type;
	}
	public String getTypes() throws InvalidObjectException {
		if(types == null) {
			throw new InvalidObjectException("types is NULL");
		}
		return types;
	}
}
