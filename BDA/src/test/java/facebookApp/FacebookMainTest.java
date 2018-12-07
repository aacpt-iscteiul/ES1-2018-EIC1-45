package facebookApp;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Post;
import com.restfb.types.User;

import facebookApp.FacebookMain;

public class FacebookMainTest {
	
	FacebookClient fbClient;
	User me;
	FacebookMain fb;
	
	
	@Before
	public void initBeforeTests() {
		fb = new FacebookMain();
		fb.init();
	}
	
	@Test
	public void testJUnit() {
		assertTrue(true);
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
		assert(fb.getMyUsername().length()>0);
	}
	
	
	@Test
	public void getPostsShouldNotBeNull() {
		assertNotNull(fb.getPosts());
	}
	
	
	@Test
	public void getIDShouldBeANumericalString() {
		assertNotNull(fb.getMyID());
		
		assertTrue(Long.valueOf(fb.getMyID())>0);
	}
	
}
