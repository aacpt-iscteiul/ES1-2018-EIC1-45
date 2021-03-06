package mailApp;

import java.util.Date;

/**
 * Date: 25/10/2018 Classe de objetos "Mails" a ser usada no futuro
 * 
 * @author António Teixeira
 * @version 1.03
 * 
 */

public class Mail {

	/**
	 * Valor String para o endereço de email de quem recebe
	 */
	private String receiverEmail;
	/**
	 * Valor String para o assunto do email
	 */
	private String emailSubject;
	/**
	 * Valor String para o corpo do email
	 */
	private String emailBody;
	/**
	 * Valor String para o endereço de email de quem envia
	 */
	private String senderEmail;
	/**
	 * Valor Date que corresponde á data de envio do email
	 */
	private Date sentDate;

	/**
	 * Construtor da classe Mail
	 * 
	 * @param receiverEmail primeiro argumento String
	 * @param emailSubject  segundo argumento String
	 * @param emailBody     terceiro argumento String
	 * @param senderEmail   quarto argumento String
	 * @param sentDate      argumento do tipo Date
	 */
	public Mail(String receiverEmail, String emailSubject, String emailBody, String senderEmail, Date sentDate) {
		this.sentDate = sentDate;
		this.receiverEmail = receiverEmail;
		this.emailSubject = emailSubject;
		this.emailBody = emailBody;
		this.senderEmail = senderEmail;
	}

	/**
	 * Método getter para o receiverEmail
	 * 
	 * @return receiverEmail
	 */
	public String getReceiverEmail() {
		return receiverEmail;
	}

	/**
	 * Método getter para o emailSubject
	 * 
	 * @return emailSubject
	 */
	public String getEmailSubject() {
		return emailSubject;
	}

	/**
	 * Método getter para o getEmailBody
	 * 
	 * @return emailBody String
	 */
	public String getEmailBody() {
		return emailBody;
	}

	/**
	 * Método getter para o senderEmail
	 * 
	 * @return senderEmail
	 */
	public String getSenderEmail() {
		return senderEmail;
	}

	/**
	 * Método getter para o sentDate
	 * 
	 * @return sentDate
	 */
	public Date getSentDate() {
		return sentDate;
	}

}
