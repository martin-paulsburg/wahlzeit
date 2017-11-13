import org.junit.runner.*;
import org.junit.runners.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	//handler test
	org.wahlzeit.handlers.TellFriendTest.class,
	//model test
	org.wahlzeit.model.AccessRightsTest.class,
	org.wahlzeit.model.CoordinateLocationTest.class,
	org.wahlzeit.model.FlagReasonTest.class,
	org.wahlzeit.model.GenderTest.class,
	org.wahlzeit.model.GuestTest.class,
	org.wahlzeit.model.PhotoFilterTest.class,
	org.wahlzeit.model.TagsTest.class,
	org.wahlzeit.model.UserStatusTest.class,
	org.wahlzeit.model.ValueTest.class,
	org.wahlzeit.model.ConstructionDefectPhotoTest.class,
	org.wahlzeit.model.ConstructionDefectPhotoFactoryTest.class,
	org.wahlzeit.model.ConstructionDefectPhotoManagerTest.class,
	//model.persistence test
	org.wahlzeit.model.persistence.AbstractAdapterTest.class,
	org.wahlzeit.model.persistence.DatastoreAdapterTest.class,
	//service test
	org.wahlzeit.services.EmailAddressTest.class,
	org.wahlzeit.services.LogBuilderTest.class,
	//service.mailing test
	org.wahlzeit.services.mailing.EmailServiceTest.class,
	//utils test
	org.wahlzeit.utils.StringUtilTest.class,
	org.wahlzeit.utils.VersionTest.class
})


public class AllSuitesTest {

}
