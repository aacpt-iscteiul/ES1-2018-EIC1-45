package ES1_2018_EIC1_45.BDA;

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
	public void testGetStatus() {
		fail("Not yet implemented");
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
