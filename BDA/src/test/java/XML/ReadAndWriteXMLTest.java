package XML;

import org.junit.Test;

import XML.ReadAndWriteXML;

/**
 * Date: 25/11/2018 Classe de testes da classe ReadAndWriteXMLTest
 * 
 * @author António Teixeira
 * @version 1.0
 */
public class ReadAndWriteXMLTest {

	String emailAddress = "emailAddress@mail.com";
	String emailPassword = "emailPassword";
	String fbUserName = "fbUserName";
	String fbPassword = "fbPassword";
	String twtUserName = "twtUserName";
	String twtPassword = "twtPassword";

	/**
	 * Método para testar a classe ReadAndWriteXMLTest
	 */
	@Test
	public void testReadAndWriteXML() {
		ReadAndWriteXML xml = new ReadAndWriteXML();
		xml.writeToXML(emailAddress, emailPassword, fbUserName, fbPassword, twtUserName, twtPassword);
		xml.readFromXML();

	}
}
