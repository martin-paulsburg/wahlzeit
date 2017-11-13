package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;

public class ConstructionDefectPhotoFactory extends PhotoFactory {
	
	
	/**
	 *
	 */
	protected ConstructionDefectPhotoFactory() {
		super();
	}
	/**
	 * Public singleton access method.
	 */
	public static synchronized PhotoFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic ConstructionDefectPhotoFactory").toString());
			setInstance(new ConstructionDefectPhotoFactory());
		}

		return instance;
	}
	
	public static void initialize() {
		getInstance(); // drops result due to getInstance() side-effects
	}
	
	/**
	 * Method to set the singleton instance of ConstructionDefectPhotoFactory.
	 */
	protected static synchronized void setInstance(ConstructionDefectPhotoFactory photoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize ConstructionDefectPhotoFactory twice");
		}

		instance = photoFactory;
	}
	/**
	 * @methodtype factory
	 */
	public Photo createPhoto() {
		return new ConstructionDefectPhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 */
	public Photo createPhoto(PhotoId id) {
		return new ConstructionDefectPhoto(id);
	}
}
