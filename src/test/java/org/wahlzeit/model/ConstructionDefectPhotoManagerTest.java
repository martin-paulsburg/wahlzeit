package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class ConstructionDefectPhotoManagerTest {

	public ConstructionDefectPhotoManager man;
	@ClassRule
	public static LocalDatastoreServiceTestConfigProvider Datastore = new LocalDatastoreServiceTestConfigProvider();
	@Before
	public void setup() {
		man = new ConstructionDefectPhotoManager();
	}
	
	@Test
	public void testGetPhotoFromId() {
		man.photoCache.put(new PhotoId(42), new ConstructionDefectPhoto());
		assertTrue(man.getPhotoFromId(new PhotoId(42)) instanceof ConstructionDefectPhoto);
	}
	
	@Test
	public void testGetPhotoPhotoId() {
		man.photoCache.put(new PhotoId(42), new ConstructionDefectPhoto());
		assertTrue(man.getPhotoFromId(new PhotoId(42)) instanceof ConstructionDefectPhoto);
	}
	
	@Test
	public void testGetPhotoString() {
		man.photoCache.put(PhotoId.getIdFromString("42"), new ConstructionDefectPhoto());
		assertTrue(man.getPhotoFromId(PhotoId.getIdFromString("42")) instanceof ConstructionDefectPhoto);
	}
	
	
	@Test
	public void testConstructionDefectPhotoManager() {
		man = new ConstructionDefectPhotoManager();
		assertTrue(man.photoTagCollector!=null);
	}




}
