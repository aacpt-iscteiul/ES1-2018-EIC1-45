package gui;


import facebookApp.FacebookMain;
import javafx.application.Application;
import javafx.stage.Stage;
import mailApp.EmailReader;

public class NewWindow extends Application{

	public static final int HEIGHT = 600, WIDTH = 1000;
	static EmailReader readMail;
	static FacebookMain fb;
	
	public static void main(String[] args) {
		//MAIL
		String receiverEmail = "es1_2018_45@outlook.pt";
		String receiverPassword = "isctegrupo45";
		readMail = new EmailReader(receiverEmail, receiverPassword);
		readMail.getMail();
		//FACEBOOK
		fb = new FacebookMain();
		fb.init();
		
		NewWindow gui = new NewWindow();
		Application.launch(gui.getClass(), args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Stage
		primaryStage.setTitle("Bom Dia Academia");
		primaryStage.setMinHeight(300);
		primaryStage.setMinWidth(400);

		// Stage Show
		primaryStage.setScene(DefaultScene.getScene());
		primaryStage.show();
	}	
	
}
