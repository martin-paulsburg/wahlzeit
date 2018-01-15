package org.wahlzeit.model;

import java.util.HashMap;

import org.wahlzeit.services.LogBuilder;

import com.google.appengine.repackaged.org.antlr.runtime.tree.DOTTreeGenerator;

@DesignPattern{
	name = "Factory",
	participants = {"Factory"}
}
@DesignPattern{
	name = "Singleton",
	participants = {"Singleton"}
}

public class ConstructionDefectPhotoFactory extends PhotoFactory {
	
	private HashMap<String, ConstructionDefectType> TypeMap;

	
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
		return createPhoto("Default");
	}
	
	public Photo createPhoto(String type) {
		Photo ret = new ConstructionDefectPhotoInstance();
		((ConstructionDefectPhotoInstance) ret).setType(doGetTypeFromList(type));
		return ret;
	}
	
	private ConstructionDefectType doGetTypeFromList(String type) {
		if(!TypeMap.containsKey(type)){
			TypeMap.put(type, new ConstructionDefectType(type));
		}
		return TypeMap.get(type);
	}
	
	/**
	 * Creates a new photo with the specified id
	 */
	public Photo createPhoto(PhotoId id) {
		return new ConstructionDefectPhoto(id);
	}
}
