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
	
	@Test
	public void getTimelineNotNull() {
		assertNotNull(twitterTest.getTimeline());
	}
	
	@Test
	public void getTimelineSearchUserTweetseNotNull() {
		assertNotNull(twitterTest.getTimelineSearchUserTweets("IscteG"));
	}
	
	@Test
	public void getTimelineSearchTweetsNotNull() {
		assertNotNull(twitterTest.getTimelineSearchTweets("Hello"));
	}
	
	@Test
	public void getUsernameNotNull() {
		assertNotNull(twitterTest.getUsername());
	}
	
	@Test
	public void getFavoritesNotNull() {
		assertNotNull(twitterTest.getFavorites());
	}
	
	@Test
	public void getUsertimelineNotNull() {
		assertNotNull(twitterTest.getUsertimeline());
	}
	
	@Test
	public void getAuthConsumerKeyTest() {
		assert(twitterTest.getAuthConsumerKey().length()>0);
		
	}
	
	@Test
	public void getAuthConsumerSecretTest() {
		assert(twitterTest.getAuthConsumerSecret().length()>0);
		
	}

	@Test
	public void getAuthAccessTokenTest() {
		assert(twitterTest.getAuthAccessToken().length()>0);
		
	}

	@Test
	public void getAuthAccessTokenSecretTest() {
		assert(twitterTest.getAuthAccessTokenSecret().length()>0);
		
	}
	


	

}
