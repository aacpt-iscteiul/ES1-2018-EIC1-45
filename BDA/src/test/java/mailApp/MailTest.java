package mailApp;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

/**
 * Date: 25/11/2018 Classe de testes da classe MailTest
 * 
 * @author António Teixeira
 * @version 1.0
 */
public class MailTest {

	/**
	 * Método para testar o getReceiverEmail()
	 */
	@Test
	public void testGetReceiverEmail() {
		Date d = new Date(123412341);
		Mail m = new Mail("receiver@test.mail", "1", "2", "3", d);
		assertEquals("receiver@test.mail", m.getReceiverEmail());
	}

	/**
	 * Método para testar o getEmailSubject()
	 */
	@Test
	public void testGetEmailSubject() {
		Date d = new Date(123412341);
		Mail m = new Mail("1", "mailsubject", "2", "3", d);
		assertEquals("mailsubject", m.getEmailSubject());
	}

	/**
	 * Método para testar o getEmailBody()
	 */
	@Test
	public void testGetEmailBody() {
		Date d = new Date(123412341);
		Mail m = new Mail("1", "2", "mailbody", "3", d);
		assertEquals("mailbody", m.getEmailBody());
	}

	/**
	 * Método para testar o getSenderEmail()
	 */
	@Test
	public void testGetSenderEmail() {
		Date d = new Date(123412341);
		Mail m = new Mail("1", "2", "3", "sender@test.mail", d);
		assertEquals("sender@test.mail", m.getSenderEmail());
	}

	/**
	 * Método para testar o getSentDate()
	 */
	@Test
	public void testGetSentDate() {
		Date d = new Date(123412341);
		Mail m = new Mail("1", "2", "3", "4", d);
		assertEquals(d, m.getSentDate());
	}

}