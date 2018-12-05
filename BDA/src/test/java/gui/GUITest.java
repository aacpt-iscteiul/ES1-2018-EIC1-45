package gui;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javafx.application.Application;
import javafx.stage.Stage;
import mailApp.EmailReader;

public class GUITest {

	private NewWindow window;
	private Stage primaryStage;
	private DefaultScene myScene;
	
	@Before
	public void init() {
		
		window = new NewWindow();
		window.main(null);
		
	}
	
	@Test
	public void testStageSize() {
		primaryStage = window.getPrimaryStage();
		
		assert(primaryStage.getMinHeight()==300);
		assert(primaryStage.getMinWidth()==400);
	}
	
	@Test
	public void testStageTitle() {
		assertEquals("Bom Dia Academia", primaryStage.getTitle());
	}
	
	@Test
	public void isStageShown() {
		assertTrue(primaryStage.isShowing());
	}
	

	@Test
	public void testJUnit() {
		assertTrue(true);
	}
	
	
	
}
