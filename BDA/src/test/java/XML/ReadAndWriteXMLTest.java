package XML;

import org.junit.Test;

import XML.ReadAndWriteXML;

/**
 * Date: 25/11/2018 Classe de testes da classe ReadAndWriteXMLTest
 * 
 * @author António Teixeira
 * @version 1.1
 */
public class ReadAndWriteXMLTest {

	String emailAddress = "emailAddress@mail.com";
	String emailPassword = "emailPassword";
	String fbUserName = "fbUserName";
	String fbPassword = "fbPassword";
	String twtUserName = "twtUserName";
	String twtPassword = "twtPassword";
	String twtAuthConsumerKey = "FaI6Q7K5LmhNQC6U87n2qffpe";
	String twtAuthConsumerSecret = "vE0BgXPhwWg1obzg4y68NE79ebJspgiXsRk74tINiMbEYVshn3";
	String twtAuthAccessToken = "1054111224428986368-Q1PHXRIo9vq7IjeI1HvOGJkOoBGNxX";
	String twtAuthAccessTokenSecret = "vcqLcZosIvFZecOE8bgx13fE79CRTc2VNt7CjXZQoOBAX";

	/**
	 * Método para testar a classe ReadAndWriteXMLTest
	 */
	@Test
	public void testReadAndWriteXML() {
		ReadAndWriteXML xml = new ReadAndWriteXML();
		xml.writeToXML(emailAddress, emailPassword, fbUserName, fbPassword, twtUserName, twtPassword,
				twtAuthConsumerKey, twtAuthConsumerSecret, twtAuthAccessToken, twtAuthAccessTokenSecret);
		xml.readFromXML();

	}
}
