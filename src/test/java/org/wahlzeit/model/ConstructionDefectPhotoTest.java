package org.wahlzeit.model;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.wahlzeit.services.EmailAddress;
import org.wahlzeit.services.EmailAddressTest;
import org.wahlzeit.services.Language;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;
import org.wahlzeit.utils.EnumValue;

import com.google.appengine.repackaged.org.apache.commons.codec.language.bm.Languages;



public class ConstructionDefectPhotoTest {
	
	
	Photo photo1;
	Photo photo2;
	Photo photo3;
	Photo photo4;
	
	@ClassRule
	public static LocalDatastoreServiceTestConfigProvider Datastore = new LocalDatastoreServiceTestConfigProvider();

	@Before
	public void setup() {
			photo2 = new ConstructionDefectPhoto();
			photo3 = new ConstructionDefectPhoto(new PhotoId(42));
			photo4 = new ConstructionDefectPhoto(new PhotoId(42));
	}
	
	@Test
	public void testConstructionDefectPhoto() {
		photo1 = new ConstructionDefectPhoto();
		assertTrue(photo1 instanceof ConstructionDefectPhoto);
	}

	@Test
	public void testConstructionDefectPhotoPhotoId() {
		photo1 = new ConstructionDefectPhoto(new PhotoId(17));
		assertTrue(photo1 instanceof ConstructionDefectPhoto);
	}

	@Test
	public void testGetIdAsString() {
		String id = PhotoId.getFromInt(42);
		assertTrue(id.compareTo(photo3.getIdAsString())==0);
	}

	@Test
	public void testGetId() {
		PhotoId compareId = new PhotoId(42);
		assertTrue(compareId.isEqual(photo3.getId()));
	}

	@Test
	public void testGetOwnerId() {
		photo4.ownerId=new String("testUser");
		String compareString = new String("testUser");
		assertTrue(compareString.compareTo(photo4.getOwnerId())==0);
	}

	@Test
	public void testSetOwnerId() {
		String compString = new String("user2");
		photo3.setOwnerId(compString);
		assertTrue(compString.compareTo(photo3.getOwnerId())==0);
	}

	@Test
	public void testGetOwnerNotifyAboutPraise() {
		photo2.ownerNotifyAboutPraise = false;
		photo3.ownerNotifyAboutPraise = true;
		assertFalse(photo2.getOwnerNotifyAboutPraise());
		assertTrue(photo3.getOwnerNotifyAboutPraise());
	}

	@Test
	public void testSetOwnerNotifyAboutPraise() {
		photo2.setOwnerNotifyAboutPraise(true);
		assertTrue(photo2.ownerNotifyAboutPraise);
		photo3.setOwnerNotifyAboutPraise(false);
		assertFalse(photo3.ownerNotifyAboutPraise);
	}

	@Test
	public void testGetOwnerLanguage() {
		assertTrue(Language.ENGLISH.compareTo(photo2.getOwnerLanguage())==0);
		assertFalse(Language.GERMAN.compareTo(photo2.getOwnerLanguage())==0);
	}

	@Test
	public void testSetOwnerLanguage() {
		photo3.setOwnerLanguage(Language.JAPANESE);
		assertTrue(Language.JAPANESE.compareTo(photo3.ownerLanguage)==0);
	}

	@Test
	public void testHasSameOwner() {
		photo2.ownerEmailAddress = EmailAddress.getFromString("abc@def.com");
		photo3.ownerEmailAddress = EmailAddress.getFromString("xyz@def.com");
		photo4.ownerEmailAddress = EmailAddress.getFromString("abc@def.com");
		assertTrue(photo2.hasSameOwner(photo4));
		assertFalse(photo2.hasSameOwner(photo3));
	}

	@Test
	public void testGetOwnerEmailAddress() {
		photo2.ownerEmailAddress = EmailAddress.getFromString("abc@test.com");
		EmailAddress testAdd = EmailAddress.getFromString("abc@test.com");
		assertTrue(testAdd.isEqual(photo2.getOwnerEmailAddress()));
	}

	@Test
	public void testSetOwnerEmailAddress() {
		photo3.setOwnerEmailAddress(EmailAddress.getFromString("abc@test.com"));
		EmailAddress testAdd = EmailAddress.getFromString("abc@test.com");
		assertTrue(testAdd.isEqual(photo3.ownerEmailAddress));
	}

	@Test
	public void testGetWidth() {
		photo2.width = 20;
		assertTrue(photo2.getWidth()==20);
	}

	@Test
	public void testGetHeight() {
		photo2.height = 20;
		assertTrue(photo2.getHeight()==20);
	}

	@Test
	public void testGetThumbWidth() {
		photo2.height = 20;
		photo2.width = 10;
		assertTrue(photo2.getThumbWidth()==(10*Photo.MAX_THUMB_PHOTO_HEIGHT/20));
		photo3.height = 10;
		photo3.width = 20;
		assertTrue(photo3.getThumbWidth()==Photo.MAX_THUMB_PHOTO_WIDTH);
	}

	@Test
	public void testIsWiderThanHigher() {
		photo2.height = 20;
		photo2.width = 10;
		photo3.height = 10;
		photo3.width = 20;
		assertFalse(photo2.isWiderThanHigher());
		assertTrue(photo3.isWiderThanHigher());
	}

	@Test
	public void testGetThumbHeight() {
		photo2.height = 20;
		photo2.width = 10;
		photo3.height = 10;
		photo3.width = 20;
		assertTrue(photo3.getThumbHeight()==10*Photo.MAX_THUMB_PHOTO_WIDTH/20);
		assertTrue(photo2.getThumbHeight()==Photo.MAX_THUMB_PHOTO_HEIGHT);
	}

	@Test
	public void testSetWidthAndHeight() {
		photo4.setWidthAndHeight(40, 50);
		assertTrue(photo4.width==40);
		assertTrue(photo4.height==50);
	}

	@Test
	public void testHasPhotoSize() {
		photo2.maxPhotoSize = PhotoSize.MEDIUM;
		assertTrue(photo2.hasPhotoSize(PhotoSize.MEDIUM));
		assertFalse(photo2.hasPhotoSize(PhotoSize.EXTRA_LARGE));
	}

	@Test
	public void testGetMaxPhotoSize() {
		photo3.maxPhotoSize = PhotoSize.EXTRA_LARGE;
		assertTrue(PhotoSize.EXTRA_LARGE.compareTo(photo3.getMaxPhotoSize())==0);
	}

	@Test
	public void testGetPraise() {
		photo2.praiseSum=20;
		photo2.noVotes=4;
		assertTrue(photo2.getPraise()==5);
	}

	@Test
	public void testAddToPraise() {
		photo3.noVotes = 0;
		photo3.praiseSum = 0;
		photo3.addToPraise(5);
		assertTrue(photo3.praiseSum==5);
		assertTrue(photo3.noVotes==1);
	}

	@Test
	public void testIsVisible() {
		photo2.status = PhotoStatus.VISIBLE;
		photo3.status = PhotoStatus.INVISIBLE;
		assertTrue(photo2.isVisible());
		assertFalse(photo3.isVisible());
	}

	@Test
	public void testGetStatus() {
		photo4.status = PhotoStatus.INVISIBLE;
		assertTrue(photo4.getStatus().compareTo(PhotoStatus.INVISIBLE)==0);
	}

	@Test
	public void testSetStatus() {
		photo2.setStatus(PhotoStatus.INVISIBLE);
		assertTrue(photo2.status.compareTo(PhotoStatus.INVISIBLE)==0);
	}

	@Test
	public void testHasTag() {
		assertFalse(photo2.hasTag("abc"));
		photo3.tags = new Tags("abc");
		assertTrue(photo3.hasTag("abc"));
	}

	@Test
	public void testGetTags() {
		photo4.tags = new Tags("abc");
		Tags comTags = new Tags("abc");
		assertTrue(comTags.isEqual(photo4.getTags()));
	}

	@Test
	public void testSetTags() {
		photo2.setTags(new Tags("def"));
		assertTrue(photo2.tags.isEqual(new Tags("def")));
	}

}
