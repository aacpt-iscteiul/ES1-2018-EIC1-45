package twitterApp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import twitterApp.TwitterApp;

public class TwitterAppTest {

	private TwitterApp twitterTest;

	@Before
	public void setUp() throws Exception {
		twitterTest = new TwitterApp();

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
//		boolean cond = twitterTest.getAuthConsumerKey().length() > 0;
//		if (twitterTest.getAuthConsumerKey().length() > 0)
//			cond = true;
//		else
//			cond = false;
//		assertTrue(cond);
		assertEquals(twitterTest.getAuthConsumerKey(), "FaI6Q7K5LmhNQC6U87n2qffpe");

	}

	@Test
	public void getAuthConsumerSecretTest() {
//		boolean cond = (twitterTest.getAuthConsumerSecret().length() > 0);
		assertEquals(twitterTest.getAuthConsumerSecret(), "vE0BgXPhwWg1obzg4y68NE79ebJspgiXsRk74tINiMbEYVshn3");

	}

	@Test
	public void getAuthAccessTokenTest() {
//		boolean cond = (twitterTest.getAuthAccessToken().length() > 0);
//		assertTrue(cond);
		assertEquals(twitterTest.getAuthAccessToken(), "1054111224428986368-Q1PHXRIo9vq7IjeI1HvOGJkOoBGNxX");

	}

	@Test
	public void getAuthAccessTokenSecretTest() {
//		boolean cond = (twitterTest.getAuthAccessTokenSecret().length() > 0);
//		assertTrue(cond);
		assertEquals(twitterTest.getAuthAccessTokenSecret(), "vcqLcZosIvFZecOE8bgx13fE79CRTc2VNt7CjXZQoOBAX");

	}

}
