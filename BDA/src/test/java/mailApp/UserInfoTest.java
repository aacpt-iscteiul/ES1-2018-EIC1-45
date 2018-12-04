package mailApp;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Date: 25/11/2018 Classe de testes da classe UserInfoTest
 * 
 * @author António Teixeira
 * @version 1.0
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
		u = new UserInfo("emailAddress", "emailPassword");
		assertNotNull(u);
	}

	/**
	 * Método para testar o getEmailAddress()
	 */
	@Test
	public void testGetEmailAddress() {
		u = new UserInfo("emailAddress", "emailPassword");
		assertEquals("emailAddress", u.getEmailAddress());
	}

	/**
	 * Método para testar o getEmailPassword()
	 */
	@Test
	public void testGetEmailPassword() {
		u = new UserInfo("emailAddress", "emailPassword");
		assertEquals("emailPassword", u.getEmailPassword());
	}

	/**
	 * Método para testar o setEmailAddress()
	 */
	@Test
	public void testSetEmailAddress() {
		u = new UserInfo("", "emailPassword");
		u.setEmailAddress("emailAddress");
		assertEquals("emailAddress", u.getEmailAddress());
	}

	/**
	 * Método para testar o setEmailPassword()
	 */
	@Test
	public void testSetEmailPassword() {
		u = new UserInfo("emailAddress", "");
		u.setEmailPassword("emailPassword");
		assertEquals("emailPassword", u.getEmailPassword());
	}

}
