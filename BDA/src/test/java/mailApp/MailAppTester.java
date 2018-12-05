package mailApp;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.junit.Test;

/**
 * Date: 25/10/2018 Classe de testes da classe EmailReader e EmailSender em
 * conjunto
 * 
 * @author António Teixeira
 * @version 1.0
 */

public class MailAppTester {

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
	 * Valor String para a password de email do recetor
	 */
	String receiverPassword = "isctegrupo45";
	/**
	 * Valor String para o assunto do email no emissor
	 */
	String senderEmailSubject = "This is a test email subject 5";
	/**
	 * Valor String para o corpo do email no emissor
	 */
//	String senderEmailBody = "";
	String senderEmailBody = "" + "This is a test email body";
	/**
	 * Valor String para o corpo do email no recetor
	 */
	String receiverEmailBody = "";
	/**
	 * Valor String para o assunto do email no recetor
	 */
	String receiverEmailSubject = "";

	/**
	 * Método para testar a classe MailAppTester
	 * 
	 * @throws Exception Exception
	 */
	@Test
	public void test() throws Exception {

		// +++++++++++++++++++ ENVIO DE EMAIL ++++++++++++++++++++++++

		Properties props = new Properties();
		props.put("mail.smtp.user", senderEmail);
		props.put("mail.smtp.host", "smtp-mail.outlook.com");
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.pwd", senderPassword);
		props.put("mail.smtp.port", 587);

		Authenticator auth = new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		};

		Session session = Session.getInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		msg.setText(senderEmailBody);
		msg.setSubject(senderEmailSubject);
		msg.setFrom(new InternetAddress(senderEmail));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
		Transport.send(msg);

		System.out.println("Done. Mail sent!");

		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		// +++++++++++++++++++ RECEÇÃO DE EMAIL ++++++++++++++++++++++++
		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		Properties rProps = System.getProperties();
		rProps.setProperty("mail.store.protocol", "imaps");
		Session mailSession = Session.getInstance(rProps);

		// mailSession.setDebug(true);
		Store emailStore = mailSession.getStore("imaps");
		emailStore.connect("imap-mail.outlook.com", receiverEmail, receiverPassword);

		// pasta inbox
		Folder emailFolder = emailStore.getFolder("INBOX");
		emailFolder.open(Folder.READ_ONLY);
		Message messages[] = emailFolder.getMessages();

//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		for (int i = messages.length - 1; i < messages.length; i++) {
			Message message = messages[i];
			Address[] froms = message.getFrom(); // melhor maneira de extrair os endereços de quem enviou emails
			System.out.println("Email Number: " + (i + 1));
			receiverEmailSubject = message.getSubject();
			System.out.println("Subject: " + message.getSubject());
			String senderEmail2 = froms == null ? null : ((InternetAddress) froms[0]).getAddress();
			System.out.println("From: " + senderEmail2);
			Date sentDate = message.getSentDate();
			System.out.println("Sent date: " + sentDate);
			receiverEmailBody = getTextFromMessage(message);
			System.out.println("Text: " + receiverEmailBody);

//				Mail m = new Mail(receiverEmail, subject, messageBoby, senderEmail, sentDate);
//				mails.add(m);
		}
		emailFolder.close();
		emailStore.close();

//		assertEquals(senderEmailBody, receiverEmailBody);
		assertEquals(senderEmailSubject, receiverEmailSubject);
	}

	/**
	 * Método auxiliar do getMail() que devolve o texto da mensagem de mail caso
	 * seja do tipo Mime.
	 * 
	 * @param message argumento do tipo Message.
	 * @return Devolve uma String que corresponde ao texto da mensagem de email.
	 * @throws IOException        envia a exceção do tipo IOException para quem
	 *                            chama o método.
	 * @throws MessagingException envia a exceção do tipo MessagingException para
	 *                            quem chama o método.
	 */
	public String getTextFromMessage(Message message) throws Exception {
		String result = "";
		if (message.isMimeType("text/plain")) {
			result = message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			result = getTextFromMimeMultipart(mimeMultipart);
		}
		return result;
	}

	/**
	 * Método auxiliar do getTextFromMessage() que devolve o texto da mensagem de
	 * mail caso seja do tipo mimeMultipart.
	 * 
	 * @param mimeMultipart argumento do tipo mimeMultipart
	 * @return Devolve uma String que corresponde ao texto da mensagem de email
	 * @throws Exception Exception
	 */
	public String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {

		int count = mimeMultipart.getCount();
		if (count == 0)
			throw new MessagingException("Multipart with no body parts not supported.");
		boolean multipartAlt = new ContentType(mimeMultipart.getContentType()).match("multipart/alternative");
		if (multipartAlt)
			// alternativas aparecem pela ordem crescente
			return getTextFromBodyPart(mimeMultipart.getBodyPart(count - 1));
		String result = "";
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			result += getTextFromBodyPart(bodyPart);
		}
		return result;
	}

	/**
	 * Método auxiliar de getTextFromMimeMultipart() que devolve o texto da mensagem
	 * de email caso seja do tipo multipartAlt
	 * 
	 * @param bodyPart argumento do tipo bodyPart
	 * @return Devolve uma String que corresponde ao texto da mensagem de email
	 * @throws IOException        envia a exceção do tipo IOException para quem
	 *                            chama o método.
	 * @throws MessagingException envia a exceção do tipo MessagingException para
	 *                            quem chama o método.
	 */

	public String getTextFromBodyPart(BodyPart bodyPart) throws Exception {
		String result = "";
		if (bodyPart.isMimeType("text/plain")) {
			result = (String) bodyPart.getContent();
		} else if (bodyPart.isMimeType("text/html")) {
			String html = (String) bodyPart.getContent();
			result = org.jsoup.Jsoup.parse(html).text();
		} else if (bodyPart.getContent() instanceof MimeMultipart) {
			result = getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
		}
		return result;
	}
}
