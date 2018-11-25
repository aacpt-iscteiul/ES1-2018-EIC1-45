package mailApp;

import org.junit.Test;

/**
 * Date: 25/11/2018 Classe de testes da classe EmailReader
 * 
 * @author António Teixeira
 * @version 1.1
 */

public class EmailReaderTest2 {

	/**
	 * Método para testar a classe EmailReader
	 */
	@Test
	public void test() {

		String receiverEmail = "es1_2018_45@outlook.pt";
		String receiverPassword = "isctegrupo45";

		EmailReader read = new EmailReader(receiverEmail, receiverPassword);
		read.getMail();
	}

}
