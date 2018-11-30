package mailApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import XML.ReadAndWriteXML;

/**
 * Date: 25/11/2018 Classe de testes da classe ReadAndWriteXMLTest
 * 
 * @author António Teixeira
 * @version 1.0
 */
public class ReadAndWriteXMLTest {

	String senderEmail = "testemail";
	String senderPassword = "testpassword";

	/**
	 * Método para testar a classe ReadAndWriteXMLTest
	 */
	@Test
	public void testReadAndWriteXML(){
	ReadAndWriteXML xml = new ReadAndWriteXML();	
	xml.writeToXML(senderEmail, senderPassword);
	xml.readFromXML();
	
	}
}
