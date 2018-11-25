package mailApp;

import org.junit.Test;

/**
 * Date: 25/11/2018 Classe de testes da classe EmailSender
 * 
 * @author António Teixeira
 * @version 1.1
 */

public class EmailSenderTest {

	/**
	 * Valor String para o endereço de email do emissor
	 */
	String senderEmail = "es1_2018_45@outlook.pt";
	/**
	 * Valor String para a password de email do emissor
	 */
	String senderPassword = "isctegrupo45";
	/**
	 * Valor String para o endereço de email do recetor
	 */
	String receiverEmail = "es1_2018_45@outlook.pt";
	/**
	 * Valor String para o assunto do email
	 */
	String emailSubject = "This is a test email subject XII";
	/**
	 * Valor String para o corpo do email
	 */
	String emailBody = "This is a test email body X";

	/**
	 * Método para testar a classe EmailSender
	 */
	@Test
	public void testEmailSender() {
		EmailSender send = new EmailSender(receiverEmail, emailSubject, emailBody, senderEmail, senderPassword);
		send.sendEmail();
	}

}
