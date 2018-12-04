package mailApp;

/**
 * Date: 13/11/2018 Classe de objetos "MaiUserInfo" a ser usada para o XML
 * 
 * @author António Teixeira
 * @version 1.00
 * 
 */

public class UserInfo {

	/**
	 * Valor String para guardar o endereço de email do utilizador
	 */
	private String emailAddress;
	/**
	 * Valor String para guardar a password de email do utilizador
	 */
	private String emailPassword;

	/**
	 * Construtor sem elementos para auxiliar a utilização do XML
	 */
	public UserInfo() {
	}

	/**
	 * Construtor da classe UserInfo
	 * 
	 * @param emailAddress  primeiro argumento String
	 * @param emailPassword segundo argumento String
	 */
	public UserInfo(String emailAddress, String emailPassword) {
		this.emailAddress = emailAddress;
		this.emailPassword = emailPassword;
	}

	/**
	 * Getter para o emailAddress
	 * 
	 * @return emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Getter para o emailPassword
	 * 
	 * @return emailPassword
	 */
	public String getEmailPassword() {
		return emailPassword;
	}

	/**
	 * Setter para o emailAddress
	 * 
	 * @param emailAddress
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * Setter para o emailPassword
	 * 
	 * @param emailPassword
	 */
	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

}
