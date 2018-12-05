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
	 * Valor String para guardar o AuthConsumerKey do twitter do utilizador
	 */
	private String twtAuthConsumerKey;

	/**
	 * Valor String para guardar o AuthConsumerSecret do twitter do utilizador
	 */
	private String twtAuthConsumerSecret;

	/**
	 * Valor String para guardar o AuthAccessToken do twitter do utilizador
	 */
	private String twtAuthAccessToken;
	/**
	 * Valor String para guardar o AuthAccessTokenSecret do twitter do utilizador
	 */
	private String twtAuthAccessTokenSecret;

	/**
	 * Construtor sem elementos para auxiliar a utilização do XML
	 */
	public UserInfo() {
	}

	/**
	 * Construtor da classe UserInfo
	 * 
	 * @param emailAddress
	 * @param emailPassword
	 * @param fbUserName
	 * @param fbPassword
	 * @param twtUserName
	 * @param twtPassword
	 * @param twtAuthConsumerKey
	 * @param twtAuthConsumerSecret
	 * @param twtAuthAccessToken
	 * @param twtAuthAccessTokenSecret
	 */
	public UserInfo(String emailAddress, String emailPassword, String fbUserName, String fbPassword, String twtUserName, String twtPassword, String twtAuthConsumerKey, String twtAuthConsumerSecret, String twtAuthAccessToken,
			String twtAuthAccessTokenSecret) {
		this.emailAddress = emailAddress;
		this.emailPassword = emailPassword;
		this.fbUserName = fbUserName;
		this.fbPassword = fbPassword;
		this.twtUserName = twtUserName;
		this.twtPassword = twtPassword;
		this.twtAuthConsumerKey = twtAuthConsumerKey;
		this.twtAuthConsumerSecret = twtAuthConsumerSecret;
		this.twtAuthAccessToken = twtAuthAccessToken;
		this.twtAuthAccessTokenSecret = twtAuthAccessTokenSecret;
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
	 * Getter para o twtAuthConsumerKey
	 * 
	 * @return twtAuthConsumerKey
	 */
	public String getTwtAuthConsumerKey() {
		return twtAuthConsumerKey;
	}

	/**
	 * Getter para o twtAuthConsumerSecret
	 * 
	 * @return twtAuthConsumerSecret
	 */
	public String getTwtAuthConsumerSecret() {
		return twtAuthConsumerSecret;
	}

	/**
	 * Getter para o twtAuthAccessToken
	 * 
	 * @return twtAuthAccessToken
	 */
	public String getTwtAuthAccessToken() {
		return twtAuthAccessToken;
	}

	/**
	 * Getter para o twtAuthAccessTokenSecret
	 * 
	 * @return twtAuthAccessTokenSecret
	 */
	public String getTwtAuthAccessTokenSecret() {
		return twtAuthAccessTokenSecret;
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

	/**
	 * Setter para o twtAuthConsumerKey
	 * 
	 * @param twtAuthConsumerKey
	 */
	public void setTwtAuthConsumerSecret(String twtAuthConsumerSecret) {
		this.twtAuthConsumerSecret = twtAuthConsumerSecret;
	}

	/**
	 * Setter para o twtAuthConsumerSecret
	 * 
	 * @param twtAuthConsumerSecret
	 */
	public void setTwtAuthConsumerKey(String twtAuthConsumerKey) {
		this.twtAuthConsumerKey = twtAuthConsumerKey;
	}

	/**
	 * Setter para o twtAuthAccessToken
	 * 
	 * @param twtAuthAccessToken
	 */
	public void setTwtAuthAccessToken(String twtAuthAccessToken) {
		this.twtAuthAccessToken = twtAuthAccessToken;
	}

	/**
	 * Setter para o twtAuthAccessTokenSecret
	 * 
	 * @param twtAuthAccessTokenSecret
	 */
	public void setTwtAuthAccessTokenSecret(String twtAuthAccessTokenSecret) {
		this.twtAuthAccessTokenSecret = twtAuthAccessTokenSecret;
	}

}
