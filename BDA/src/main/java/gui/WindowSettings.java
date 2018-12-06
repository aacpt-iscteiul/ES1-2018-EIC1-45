package gui;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WindowSettings {

	static private Scene sceneMailSettings, sceneFBSettings, sceneTwitterSettings;
	static private Stage windowSettings;
	/**
	 * Creates a window for the settings
	 */
	public static void openSettings() {
		// Stage
		windowSettings = new Stage();
		windowSettings.setTitle("Settings");
		windowSettings.initModality(Modality.APPLICATION_MODAL);
		windowSettings.setHeight(145);
		windowSettings.setWidth(335);
		windowSettings.setResizable(false);

		sceneMailSettings = SettingsScenes.getEmailScene();
		sceneFBSettings = SettingsScenes.getFacebookScene();
		sceneTwitterSettings = SettingsScenes.getTwitterScene();

		// Stage Show
		windowSettings.setScene(sceneMailSettings); // default
		windowSettings.showAndWait();
	}

	/**
	 * creates left side buttons that are used for all settings scenes
	 * 
	 * @return VBox with settings buttons
	 */
	public static Node getSettingsLeftButtons() {
		VBox settingsLeftButtons = new VBox(10);
		settingsLeftButtons.setPadding(new Insets(10));
		settingsLeftButtons.setAlignment(Pos.CENTER_LEFT);
		Button buttonMail = new Button("Mail");
		buttonMail.setOnAction(e -> windowSettings.setScene(sceneMailSettings));
		
		Button buttonFB = new Button("Facebook");
		buttonFB.setOnAction(e -> windowSettings.setScene(sceneFBSettings));
		
		Button buttonTwitter = new Button("Twitter");
		buttonTwitter.setOnAction(e ->windowSettings.setScene(sceneTwitterSettings));
		
		settingsLeftButtons.getChildren().addAll(buttonMail, buttonFB, buttonTwitter);

		return settingsLeftButtons;
	}

}
