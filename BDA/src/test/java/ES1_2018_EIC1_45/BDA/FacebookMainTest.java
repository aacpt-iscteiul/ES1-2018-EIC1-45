package ES1_2018_EIC1_45.BDA;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.*;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Post;
import com.restfb.types.User;

import facebookApp.FacebookMain;

public class FacebookMainTest {
	
	static String accessToken = "EAAIFIIEgfxIBADggr3JFRaxgbYP1l4zdOPMmJWHCCWLXIEhZCgRh689rwyIcdRWyBXaoq6zOyqOa9g0otVn09taEumGU6m0oF2oJ3ZC16RGdedZBCmbkVXx1dqkyiI3J41gx4m8tw819P4PmCsb2BngBlUwpr4MedqHfNDBuJPCruPsIJgyl3HTnl4xKfZAFh36vq949HRYNktXy0ALF";
	FacebookClient fbClient;
	User me;
	FacebookMain fb;
	
	@BeforeClass
	public void initBeforeTests() {
		
		fb = new FacebookMain();
		fb.init();
		
	}
	
	@Test
	//This is also the test to see if init() worked as init is void
	public void getMeShouldNotBeNull() {
		assertNotNull(fb.getMe());
	}
	
	
	@Test
	public void getMyIDLengthShouldBeBiggerThanZero() {
		assert(fb.getMyID().length()>0);	
	}
	
		
	@Test
	public void getMyUsernameLengthShouldBeBiggerThanZero() {
		assert(me.getUsername().length()>0);
	}
	
	
	@Test
	public void getPostsShouldNotBeNull() {
		assertNotNull(fb.getPosts());
	}
	
	
}
