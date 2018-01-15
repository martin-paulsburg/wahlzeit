package org.wahlzeit.model;

public class ConstructionDefectPhotoInstance extends ConstructionDefectPhoto{
	private ConstructionDefectType photoType = null;
	public ConstructionDefectPhotoInstance() {
		super();
	}
	public void setType(ConstructionDefectType type) {
		photoType = type;
	}
	public ConstructionDefectType getType() {
		return photoType;
	}
}
