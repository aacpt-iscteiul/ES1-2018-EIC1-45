package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class NewWindow extends Application{
	
	public static void main(String[] args) {
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
