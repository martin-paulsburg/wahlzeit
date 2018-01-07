package org.wahlzeit.model;

import org.wahlzeit.services.Persistent;

@DesignPattern{
	name = "Singleton",
	participants = {"Singleton"}
}

public class ConstructionDefectPhotoManager extends PhotoManager {
	/**
	 *
	 */
	protected static final ConstructionDefectPhotoManager instance = new ConstructionDefectPhotoManager();

	/**
	 *
	 */
	public ConstructionDefectPhotoManager() {
		photoTagCollector = ConstructionDefectPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	/**
	 *
	 */
	public Photo getPhotoFromId(PhotoId id) {
		if (id == null) {
			throw new IllegalArgumentException("photo id is NULL");
		}

		Photo result = doGetPhotoFromId(id);

		if (result == null) {
			result = ConstructionDefectPhotoFactory.getInstance().loadPhoto(id);
			if (result != null) {
				doAddPhoto(result);
			}
		}

		return result;
	}
	protected void updateDependents(Persistent obj) {
		if (obj instanceof ConstructionDefectPhoto) {
			Photo photo = (ConstructionDefectPhoto) obj;
			saveScaledImages(photo);
			updateTags(photo);
			UserManager userManager = UserManager.getInstance();
			Client owner = userManager.getClientById(photo.getOwnerId());
			userManager.saveClient(owner);
		}
	}
	

}
