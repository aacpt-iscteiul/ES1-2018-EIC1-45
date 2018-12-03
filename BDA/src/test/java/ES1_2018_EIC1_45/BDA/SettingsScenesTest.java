package ES1_2018_EIC1_45.BDA;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import gui.NewWindow;
import javafx.stage.Stage;

public class SettingsScenesTest extends ApplicationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationTest.launch(NewWindow.class);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {}

	@Before
	public void setUp() throws Exception {
	}

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

}
