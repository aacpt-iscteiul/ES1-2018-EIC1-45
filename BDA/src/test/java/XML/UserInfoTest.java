package XML;

import static org.junit.Assert.*;

import org.junit.Test;

import XML.UserInfo;

/**
 * Date: 25/11/2018 Classe de testes da classe UserInfoTest
 * 
 * @author António Teixeira
 * @version 1.1
 */
public class UserInfoTest {

	private UserInfo u;

	/**
	 * Método para testar o construtor testUserInfo()
	 */
	@Test
	public void testUserInfo() {
		u = new UserInfo();
		assertNotNull(u);
	}

	/**
	 * Método para testar o construtor testUserInfo(String, String)
	 */
	@Test
	public void testUserInfoStringString() {
		u = new UserInfo("emailAddress", "emailPassword", "fbUserName", "fbPassword", "twtUserName", "twtPassword",
				"twtAuthConsumerKey", "twtAuthConsumerSecret", "twtAuthAccessToken", "twtAuthAccessTokenSecret");
		assertNotNull(u);
	}

	// ************************************
	// ************************************
	// ************************************
	// ******************************** TESTES AOS GETTERS
	// ************************************
	// ************************************
	// ************************************
	/**
	 * Método para testar o getEmailAddress()
	 */
	@Test
	public void testGetEmailAddress() {
		u = new UserInfo("emailAddress", "emailPassword", "fbUserName", "fbPassword", "twtUserName", "twtPassword",
				"twtAuthConsumerKey", "twtAuthConsumerSecret", "twtAuthAccessToken", "twtAuthAccessTokenSecret");
		assertEquals("emailAddress", u.getEmailAddress());
	}

	/**
	 * Método para testar o getEmailPassword()
	 */
	@Test
	public void testGetEmailPassword() {
		u = new UserInfo("emailAddress", "emailPassword", "fbUserName", "fbPassword", "twtUserName", "twtPassword",
				"twtAuthConsumerKey", "twtAuthConsumerSecret", "twtAuthAccessToken", "twtAuthAccessTokenSecret");
		assertEquals("emailPassword", u.getEmailPassword());
	}

	/**
	 * Método para testar o getFbUserName()
	 */
	@Test
	public void testGetFbUserName() {
		u = new UserInfo("emailAddress", "emailPassword", "fbUserName", "fbPassword", "twtUserName", "twtPassword",
				"twtAuthConsumerKey", "twtAuthConsumerSecret", "twtAuthAccessToken", "twtAuthAccessTokenSecret");
		assertEquals("fbUserName", u.getFbUserName());
	}

	/**
	 * Método para testar o getFbPassword()
	 */
	@Test
	public void testGetFbPassword() {
		u = new UserInfo("emailAddress", "emailPassword", "fbUserName", "fbPassword", "twtUserName", "twtPassword",
				"twtAuthConsumerKey", "twtAuthConsumerSecret", "twtAuthAccessToken", "twtAuthAccessTokenSecret");
		assertEquals("fbPassword", u.getFbPassword());
	}

	/**
	 * Método para testar o getTwtUserName()
	 */
	@Test
	public void testGetTwtUserName() {
		u = new UserInfo("emailAddress", "emailPassword", "fbUserName", "fbPassword", "twtUserName", "twtPassword",
				"twtAuthConsumerKey", "twtAuthConsumerSecret", "twtAuthAccessToken", "twtAuthAccessTokenSecret");
		assertEquals("twtUserName", u.getTwtUserName());
	}

	/**
	 * Método para testar o getTwtPassword()
	 */
	@Test
	public void testGetTwtPassword() {
		u = new UserInfo("emailAddress", "emailPassword", "fbUserName", "fbPassword", "twtUserName", "twtPassword",
				"twtAuthConsumerKey", "twtAuthConsumerSecret", "twtAuthAccessToken", "twtAuthAccessTokenSecret");
		assertEquals("twtPassword", u.getTwtPassword());
	}

	/**
	 * Método para testar o getTwtAuthConsumerKey()
	 */
	@Test
	public void testgetTwtAuthConsumerKey() {
		u = new UserInfo("emailAddress", "emailPassword", "fbUserName", "fbPassword", "twtUserName", "twtPassword",
				"twtAuthConsumerKey", "twtAuthConsumerSecret", "twtAuthAccessToken", "twtAuthAccessTokenSecret");
		assertEquals("twtAuthConsumerKey", u.getTwtAuthConsumerKey());
	}

	/**
	 * Método para testar o getTwtAuthConsumerSecret()
	 */
	@Test
	public void testgetTwtAuthConsumerSecret() {
		u = new UserInfo("emailAddress", "emailPassword", "fbUserName", "fbPassword", "twtUserName", "twtPassword",
				"twtAuthConsumerKey", "twtAuthConsumerSecret", "twtAuthAccessToken", "twtAuthAccessTokenSecret");
		assertEquals("twtAuthConsumerSecret", u.getTwtAuthConsumerSecret());
	}

	/**
	 * Método para testar o getTwtAuthAccessToken()
	 */
	@Test
	public void testgetTwtAuthAccessToken() {
		u = new UserInfo("emailAddress", "emailPassword", "fbUserName", "fbPassword", "twtUserName", "twtPassword",
				"twtAuthConsumerKey", "twtAuthConsumerSecret", "twtAuthAccessToken", "twtAuthAccessTokenSecret");
		assertEquals("twtAuthAccessToken", u.getTwtAuthAccessToken());
	}

	/**
	 * Método para testar o getTwtPassword()
	 */
	@Test
	public void testgetTwtAuthAccessTokenSecret() {
		u = new UserInfo("emailAddress", "emailPassword", "fbUserName", "fbPassword", "twtUserName", "twtPassword",
				"twtAuthConsumerKey", "twtAuthConsumerSecret", "twtAuthAccessToken", "twtAuthAccessTokenSecret");
		assertEquals("twtAuthAccessTokenSecret", u.getTwtAuthAccessTokenSecret());
	}

	// ************************************
	// ************************************
	// ************************************
	// ******************************** TESTES AOS SETTERS
	// ************************************
	// ************************************
	// ************************************

	/**
	 * Método para testar o setEmailAddress()
	 */
	@Test
	public void testSetEmailAddress() {
		u = new UserInfo("", "emailPassword", "", "", "", "", "", "", "", "");
		u.setEmailAddress("emailAddress");
		assertEquals("emailAddress", u.getEmailAddress());
	}

	/**
	 * Método para testar o setEmailPassword()
	 */
	@Test
	public void testSetEmailPassword() {
		u = new UserInfo("emailAddress", "", "", "", "", "", "", "", "", "");
		u.setEmailPassword("emailPassword");
		assertEquals("emailPassword", u.getEmailPassword());
	}

	/**
	 * Método para testar o setFbUserName()
	 */
	@Test
	public void testSetFbUserName() {
		u = new UserInfo("", "", "fbUserName", "", "", "", "", "", "", "");
		u.setFbUserName("fbUserName");
		assertEquals("fbUserName", u.getFbUserName());
	}

	/**
	 * Método para testar o setFbPassword()
	 */
	@Test
	public void testSetFbPassword() {
		u = new UserInfo("", "", "", "fbPassword", "", "", "", "", "", "");
		u.setFbPassword("fbPassword");
		assertEquals("fbPassword", u.getFbPassword());
	}

	/**
	 * Método para testar o setTwtUserName()
	 */
	@Test
	public void testSetTwtUserName() {
		u = new UserInfo("", "", "", "", "twtUserName", "", "", "", "", "");
		u.setTwtUserName("twtUserName");
		assertEquals("twtUserName", u.getTwtUserName());
	}

	/**
	 * Método para testar o setTwtPassword()
	 */
	@Test
	public void testSetTwtPassword() {
		u = new UserInfo("", "", "", "", "", "twtPassword", "", "", "", "");
		u.setTwtPassword("twtPassword");
		assertEquals("twtPassword", u.getTwtPassword());
	}

	/**
	 * Método para testar o setTwtAuthConsumerSecret()
	 */
	@Test
	public void testsetTwtAuthConsumerSecret() {
		u = new UserInfo("", "", "", "", "", "", "twtAuthConsumerKey", "", "", "");
		u.setTwtAuthConsumerSecret("twtAuthConsumerKey");
		assertEquals("twtAuthConsumerKey", u.getTwtAuthConsumerKey());
	}

	/**
	 * Método para testar o setTwtAuthConsumerKey()
	 */
	@Test
	public void testsetTwtAuthConsumerKey() {
		u = new UserInfo("", "", "", "", "", "", "", "twtAuthConsumerKey", "", "");
		u.setTwtAuthConsumerKey("twtAuthConsumerKey");
		assertEquals("twtAuthConsumerKey", u.getTwtAuthConsumerKey());
	}

	/**
	 * Método para testar o setTwtAuthAccessToken()
	 */
	@Test
	public void testsetTwtAuthAccessToken() {
		u = new UserInfo("", "", "", "", "", "", "", "", "twtAuthAccessToken", "");
		u.setTwtAuthAccessToken("twtAuthAccessToken");
		assertEquals("twtAuthAccessToken", u.getTwtAuthAccessToken());
	}

	/**
	 * Método para testar o setTwtAuthAccessToken()
	 */
	@Test
	public void testsetTwtAuthAccessTokenSecret() {
		u = new UserInfo("", "", "", "", "", "", "", "", "", "twtAuthAccessTokenSecret");
		u.setTwtAuthAccessTokenSecret("twtAuthAccessTokenSecret");
		assertEquals("twtAuthAccessTokenSecret", u.getTwtAuthAccessTokenSecret());
	}

}
