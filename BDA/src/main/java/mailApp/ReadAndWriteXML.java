package mailApp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Date: 10/11/2018 Classe para escrever e ler XML
 * 
 * @author António Teixeira
 */
public class ReadAndWriteXML {

	/**
	 * Método para ler XML
	 */
	public void readFromXML() {
		String filePath = "UserInfo.xml";
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("User");
			// now XML is loaded as Document in memory, lets convert it to Object List
			List<UserInfo> usersList = new ArrayList<UserInfo>();
			for (int i = 0; i < nodeList.getLength(); i++) {
				usersList.add(getUser(nodeList.item(i)));
			}
			// lets print Employee list information
			for (UserInfo u : usersList) {
				System.out.println(u.toString());
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Método getUser
	 * 
	 * @param node
	 * @return
	 */
	private UserInfo getUser(Node node) {
		// XMLReaderDOM domReader = new XMLReaderDOM();
		UserInfo u = new UserInfo();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			u.setEmailAddress(getTagValue("email_address", element));
			u.setEmailPassword(getTagValue("email_password", element));
		}
		return u;
	}

	/**
	 * Método getTagValue
	 * 
	 * @param tag
	 * @param element
	 * @return
	 */
	private String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodeList.item(0);
		return node.getNodeValue();
	}

	// ****************************************************************************
	// ****************************************************************************
	// ****************************************************************************
	// ****************************************************************************
	// ****************************** WRITE TO XML ********************************
	// ****************************************************************************
	// ****************************************************************************
	// ****************************************************************************
	// ****************************************************************************
	// ****************************************************************************

	/**
	 * Método para escrever XML
	 * 
	 * @param senderEmail
	 * @param senderPassword
	 */
	public void writeToXML(String senderEmail, String senderPassword) {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// adicionar elementos to Document
			Element rootElement = doc.createElementNS("Isto é a lista de utilizadores", "Users");
			// adicionar elemento raiz ao documento
			doc.appendChild(rootElement);

			// adicionar primeiro elemento filho ao elemento raiz
			rootElement.appendChild(getUserNode(doc, senderEmail, senderPassword));

			// fazer output para o ficheiro, consola
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			// print bonito com identação
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);

			// escrever para consola e ficheiro
			StreamResult console = new StreamResult(System.out);
			StreamResult file = new StreamResult(new File("./UserInfo.xml"));

			// escrever dados
			transformer.transform(source, console);
			transformer.transform(source, file);
			System.out.println(" ----------------- fim do ficheiro xml -----------------");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método getUserNode
	 * 
	 * @param doc
	 * @param senderEmail
	 * @param senderPassword
	 * @return
	 */
	private Node getUserNode(Document doc, String senderEmail, String senderPassword) {
		Element user = doc.createElement("User");

		// criar atributo id
//		user.setAttribute("id", id);

		// criar elemento email_address
		user.appendChild(getUserElements(doc, user, "email_address", senderEmail));

		// criar element email_password
		user.appendChild(getUserElements(doc, user, "email_password", senderPassword));
		return user;
	}

	// metodo utilitário para criar nó de texto
	/**
	 * Método getUserElements
	 * 
	 * @param doc
	 * @param element
	 * @param name
	 * @param value
	 * @return
	 */
	private Node getUserElements(Document doc, Element element, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

}