package mailApp;

import java.io.Serializable;

public class UserInfo /* implements Serializable */ {

	private String emailAddress;
	private String emailPassword;

	public UserInfo() {
		
	}

	public UserInfo(String emailAddress, String emailPassword) {
		this.emailAddress = emailAddress;
		this.emailPassword = emailPassword;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getEmailPassword() {
		return emailPassword;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}
	
	

}
