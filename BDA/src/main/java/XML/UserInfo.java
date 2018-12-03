package XML;

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
	 * Valor String para guardar o username do facebook do utilizador
	 */
	private String fbUserName;
	/**
	 * Valor String para guardar a password do facebook do utilizador
	 */
	private String fbPassword;
	/**
	 * Valor String para guardar o username do twitter do utilizador
	 */
	private String twtUserName;
	/**
	 * Valor String para guardar a password do twitter do utilizador
	 */
	private String twtPassword;

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
	 * @param fbUserName    terceiro argumento String
	 * @param fbPassword    quarto argumento String
	 * @param twtUserName   quinto argumento String
	 * @param twtPassword   sexto argumento String
	 */
	public UserInfo(String emailAddress, String emailPassword, String fbUserName, String fbPassword, String twtUserName,
			String twtPassword) {
		this.emailAddress = emailAddress;
		this.emailPassword = emailPassword;
		this.fbUserName = fbUserName;
		this.fbPassword = fbPassword;
		this.twtUserName = twtUserName;
		this.twtPassword = twtPassword;
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
	 * Getter para o fbUserName
	 * 
	 * @return fbUserName
	 */
	public String getFbUserName() {
		return fbUserName;
	}

	/**
	 * Getter para o fbPassword
	 * 
	 * @return fbPassword
	 */
	public String getFbPassword() {
		return fbPassword;
	}

	/**
	 * Getter para o twtUserName
	 * 
	 * @return twtUserName
	 */
	public String getTwtUserName() {
		return twtUserName;
	}

	/**
	 * Getter para o twtPassword
	 * 
	 * @return twtPassword
	 */
	public String getTwtPassword() {
		return twtPassword;
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

	/**
	 * Setter para o fbUserName
	 * 
	 * @param fbUserName
	 */
	public void setFbUserName(String fbUserName) {
		this.fbUserName = fbUserName;
	}

	/**
	 * Setter para o fbPassword
	 * 
	 * @param fbPassword
	 */
	public void setFbPassword(String fbPassword) {
		this.fbPassword = fbPassword;
	}

	/**
	 * Setter para o twtUserName
	 * 
	 * @param twtUserName
	 */
	public void setTwtUserName(String twtUserName) {
		this.twtUserName = twtUserName;
	}

	/**
	 * Setter para o twtPassword
	 * 
	 * @param twtPassword
	 */
	public void setTwtPassword(String twtPassword) {
		this.twtPassword = twtPassword;
	}

}
