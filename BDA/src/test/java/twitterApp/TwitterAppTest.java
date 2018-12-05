package twitterApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import twitterApp.TwitterApp;

public class TwitterAppTest {

	private TwitterApp twitterTest;
	
	@Before
	public void setUp() throws Exception{
		twitterTest= new TwitterApp();
		
	}
	
	@Test
	public void testJUnit() {
		assertTrue(true);
	}
	


	@Test
	public void getUserNotNull() {
		assertNotNull(twitterTest.getUsername());
	}
	
	@Test
	public void getMyUsernameLengthShouldBeBiggerThanZero() {
		assert(twitterTest.getUsername().length()>0);
	}

}
