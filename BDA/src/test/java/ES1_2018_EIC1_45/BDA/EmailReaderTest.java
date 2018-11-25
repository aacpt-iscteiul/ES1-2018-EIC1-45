package ES1_2018_EIC1_45.BDA;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.ContentType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;

import org.junit.Test;

/**
 * Date: 25/10/2018 Classe de testes da classe EmailReader
 * 
 * @author António Teixeira
 * @version 1.0
 */

public class EmailReaderTest {
	
	/**
	 * Valor String para o endereço de email do recetor
	 */
	String receiverEmail = "es1_2018_45@outlook.pt";
	/**
	 * Valor String para a password de email do recetor
	 */
	String receiverPassword = "isctegrupo45";
	/**
	 * Valor String para o assunto do email
	 */
	String subject = "";
	/**
	 * Valor String para o corpo do email
	 */
	String messageBoby = "";

//	EmailReader er = new EmailReader(receiverEmail, receiverPassword);
//	Mail m = new Mail(null, null, null, null, null);

	/**
	 * Método para testar a classe EmailReader
	 */
	/**
	 * 
	 */
	/**
	 * 
	 */
	@Test
	public void test() {
		try {
			Properties props = System.getProperties();
			props.setProperty("mail.store.protocol", "imaps");
			Session mailSession = Session.getInstance(props);

			// mailSession.setDebug(true);
			Store emailStore = mailSession.getStore("imaps");
			emailStore.connect("imap-mail.outlook.com", receiverEmail, receiverPassword);

			// pasta inbox
			Folder emailFolder = emailStore.getFolder("INBOX");
			emailFolder.open(Folder.READ_ONLY);
			Message messages[] = emailFolder.getMessages();

//			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			// Só vejo as 3 primeiras

			for (int i = messages.length - 1; i < messages.length; i++) {
				Message message = messages[i];
				Address[] froms = message.getFrom(); // melhor maneira de extrair os endereços de quem enviou emails
				System.out.println("Email Number: " + (i + 1));
				subject = message.getSubject();
				System.out.println("Subject: " + message.getSubject());
				String senderEmail = froms == null ? null : ((InternetAddress) froms[0]).getAddress();
				System.out.println("From: " + senderEmail);
				Date sentDate = message.getSentDate();
				System.out.println("Sent date: " + sentDate);
				messageBoby = getTextFromMessage(message);
				System.out.println("Text: " + messageBoby);

//				Mail m = new Mail(receiverEmail, subject, messageBoby, senderEmail, sentDate);
//				mails.add(m);
			}
			emailFolder.close();
			emailStore.close();
		} catch (NoSuchProviderException nspex) {
			nspex.printStackTrace();
		} catch (MessagingException mex) {
			mex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(messageBoby, "This is a test email body");
		assertEquals(subject, "This is a test email subject 5");
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
	public String getTextFromMessage(Message message) throws IOException, MessagingException {
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
	 * @throws IOException        envia a exceção do tipo IOException para quem
	 *                            chama o método.
	 * @throws MessagingException envia a exceção do tipo MessagingException para
	 *                            quem chama o método.
	 */
	public String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws IOException, MessagingException {

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
	
	public String getTextFromBodyPart(BodyPart bodyPart) throws IOException, MessagingException {
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
