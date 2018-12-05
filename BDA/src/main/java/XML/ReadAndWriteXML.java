package XML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	 * Método para ler XML e escrever na consola o output
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
			// print da lista de Users
//			for (UserInfo u : usersList) {
//				System.out.println(u.toString());
//			}
		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
		} catch (SAXException e) {
//			e.printStackTrace();
		} catch (IOException e) {
//			e.printStackTrace();
		}

	}

	/**
	 * Método auxiliar do readFromXML() que vai buscar objetos UserInfo
	 * 
	 * @param node parametro node
	 * @return u objeto UserInfo
	 */
	private UserInfo getUser(Node node) {
		// XMLReaderDOM domReader = new XMLReaderDOM();
		UserInfo u = new UserInfo();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			u.setEmailAddress(getTagValue("email_address", element));
			u.setEmailPassword(getTagValue("email_password", element));
			u.setFbUserName(getTagValue("fb_username", element));
			u.setFbPassword(getTagValue("fb_password", element));
			u.setTwtUserName(getTagValue("twt_username", element));
			u.setTwtPassword(getTagValue("twt_password", element));
			u.setTwtAuthConsumerKey(getTagValue("auth_consumer_key", element));
			u.setTwtAuthConsumerSecret(getTagValue("auth_consumer_secret", element));
			u.setTwtAuthAccessToken(getTagValue("auth_access_token", element));
			u.setTwtAuthAccessTokenSecret(getTagValue("auth_access_token_secret", element));
		}
		return u;
	}

	/**
	 * Método auxiliar do getUser() que devolve o valor de um Node
	 * 
	 * @param tag     String
	 * @param element Element
	 * @return Node String
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
	 * Método para escrever as credenciais das apps em XML
	 * 
	 * @param emailAddress             String
	 * @param emailPassword            String
	 * @param fbUserName               String
	 * @param fbPassword               String
	 * @param twtUserName              String
	 * @param twtPassword              String
	 * @param twtAuthConsumerKey       String
	 * @param twtAuthConsumerSecret    String
	 * @param twtAuthAccessToken       String
	 * @param twtAuthAccessTokenSecret String
	 */
	public void writeToXML(String emailAddress, String emailPassword, String fbUserName, String fbPassword,
			String twtUserName, String twtPassword, String twtAuthConsumerKey, String twtAuthConsumerSecret,
			String twtAuthAccessToken, String twtAuthAccessTokenSecret) {

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
			rootElement.appendChild(
					getUserNode(doc, emailAddress, emailPassword, fbUserName, fbPassword, twtUserName, twtPassword,
							twtAuthConsumerKey, twtAuthConsumerSecret, twtAuthAccessToken, twtAuthAccessTokenSecret));

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
//			e.printStackTrace();
		}
	}

	/**
	 * Método auxiliar do writeToXML() que devolve um objeto do tipo Node
	 * 
	 * @param doc                      String
	 * @param emailAddress             String
	 * @param emailPassword            String
	 * @param fbUserName               String
	 * @param fbPassword               String
	 * @param twtUserName              String
	 * @param twtPassword              String
	 * @param twtAuthConsumerKey       String
	 * @param twtAuthConsumerSecret    String
	 * @param twtAuthAccessToken       String
	 * @param twtAuthAccessTokenSecret String
	 * @return user Node
	 */
	private Node getUserNode(Document doc, String emailAddress, String emailPassword, String fbUserName,
			String fbPassword, String twtUserName, String twtPassword, String twtAuthConsumerKey,
			String twtAuthConsumerSecret, String twtAuthAccessToken, String twtAuthAccessTokenSecret) {
		Element user = doc.createElement("User");

		// criar atributo id
//		user.setAttribute("id", id);

		// criar elemento email_address
		user.appendChild(getUserElements(doc, user, "email_address", emailAddress));

		// criar element email_password
		user.appendChild(getUserElements(doc, user, "email_password", emailPassword));

		// criar element fb_username
		user.appendChild(getUserElements(doc, user, "fb_username", fbUserName));

		// criar element fb_password
		user.appendChild(getUserElements(doc, user, "fb_password", fbPassword));

		// criar element twt_username
		user.appendChild(getUserElements(doc, user, "twt_username", twtUserName));

		// criar element twt_password
		user.appendChild(getUserElements(doc, user, "twt_password", twtPassword));

		// criar element auth_consumer_key
		user.appendChild(getUserElements(doc, user, "auth_consumer_key", twtAuthConsumerKey));

		// criar element auth_consumer_secret
		user.appendChild(getUserElements(doc, user, "auth_consumer_secret", twtAuthConsumerSecret));

		// criar element auth_access_token
		user.appendChild(getUserElements(doc, user, "auth_access_token", twtAuthAccessToken));

		// criar element auth_access_token_secret
		user.appendChild(getUserElements(doc, user, "auth_access_token_secret", twtAuthAccessTokenSecret));
		return user;

	}

	// metodo utilitário para criar nó de texto
	/**
	 * Método getUserElements
	 * 
	 * @param doc     Document
	 * @param element Element
	 * @param name    String
	 * @param value   String
	 * @return node Node
	 */
	private Node getUserElements(Document doc, Element element, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

	/**
	 * Método de testes para leitura e escrita de XML
	 * 
	 * @param args argumentos
	 */
//	public static void main(String[] args) {
//
//		String emailAddress = "emailAddress@mail.com";
//		String emailPassword = "emailPassword";
//		String fbUserName = "fbUserName";
//		String fbPassword = "fbPassword";
//		String twtUserName = "twtUserName";
//		String twtPassword = "twtPassword";
//		String twtAuthConsumerKey = "FaI6Q7K5LmhNQC6U87n2qffpe";
//		String twtAuthConsumerSecret = "vE0BgXPhwWg1obzg4y68NE79ebJspgiXsRk74tINiMbEYVshn3";
//		String twtAuthAccessToken = "1054111224428986368-Q1PHXRIo9vq7IjeI1HvOGJkOoBGNxX";
//		String twtAuthAccessTokenSecret = "vcqLcZosIvFZecOE8bgx13fE79CRTc2VNt7CjXZQoOBAX";
//
//		ReadAndWriteXML xml = new ReadAndWriteXML();
//		xml.writeToXML(emailAddress, emailPassword, fbUserName, fbPassword, twtUserName, twtPassword,
//				twtAuthConsumerKey, twtAuthConsumerSecret, twtAuthAccessToken, twtAuthAccessTokenSecret);
//		xml.readFromXML();
//	}
}