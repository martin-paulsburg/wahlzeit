package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class ConstructionDefectPhotoFactoryTest {
	
	ConstructionDefectPhotoFactory fac;
	ConstructionDefectPhotoFactory fac2;
	ConstructionDefectPhotoFactory fac3;
	
	@ClassRule
	public static LocalDatastoreServiceTestConfigProvider Datastore = new LocalDatastoreServiceTestConfigProvider();

	@Before
	public void setup() {
		fac = new ConstructionDefectPhotoFactory();
	}
	@After
	public void tearDown() {
		fac.instance = null;
	}
	@Test
	public void testGetInstance() {
		assertTrue(fac.getInstance() instanceof ConstructionDefectPhotoFactory);
	}

	@Test
	public void testCreatePhoto() {
		assertTrue(fac.createPhoto() instanceof ConstructionDefectPhoto);
	}

	@Test
	public void testCreatePhotoPhotoId() {
		assertTrue(fac.createPhoto(new PhotoId(42)) instanceof ConstructionDefectPhoto);
	}

	@Test
	public void testConstructionDefectPhotoFactory() {
		//nothing to test only no errors here
	}

	@Test
	public void testSetInstanceConstructionDefectPhotoFactory() {
		fac2.setInstance(new ConstructionDefectPhotoFactory());
		assertTrue(fac2.instance instanceof ConstructionDefectPhotoFactory);
	}

	@Test
	public void testInitialize() {
		fac3.initialize();
		
		assertTrue(fac3.instance instanceof ConstructionDefectPhotoFactory);
	}

	
	//LoadPhodo does Nothing at the moment so no test necessary
	/*@Test
	public void testLoadPhoto() {
		fail("Not yet implemented");
	}*/


	@Test
	public void testCreatePhotoFilter() {
		assertTrue(fac.createPhotoFilter() instanceof PhotoFilter);
	}

	@Test
	public void testCreatePhotoTagCollector() {
		assertTrue(fac.createPhotoTagCollector() instanceof PhotoTagCollector);
	}

}
