package gui;


import java.util.ArrayList;
import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class DefaultScene{
	
	private static boolean showMail = true, showFacebook = true, showTwitter= true;
	private static String[] timeFilterName = {"Everything", "7 days", "24 hours"};
	private static int timeInt = 0;
	
	public static Scene getScene() {
		BorderPane frame = new BorderPane();
		
		//buttons top
		Button buttonAll = new Button("All");
		Button buttonMail = new Button("Mail");
		Button buttonFB = new Button("FaceBook");
		Button buttonTwitter = new Button("Twitter");
		BorderPane buttonsTop = new BorderPane();
		buttonsTop.setPadding(new Insets(10));
		HBox buttonsTopMiddle = new HBox(10);
		buttonsTopMiddle.setAlignment(Pos.CENTER);

		buttonsTopMiddle.getChildren().add(buttonAll);
		buttonsTopMiddle.getChildren().add(buttonMail);
		buttonsTopMiddle.getChildren().add(buttonFB);
		buttonsTopMiddle.getChildren().add(buttonTwitter);


		buttonAll.setOnAction(e -> {
			showMail = true;
			showFacebook = true;
			showTwitter = true;
		});
		buttonMail.setOnAction(e -> {
			if (showMail)
				showMail = false;
			else
				showMail = true;
		});
		buttonFB.setOnAction(e ->  {
			if (showFacebook)
				showFacebook = false;
			else
				showFacebook = true;
		});
		buttonTwitter.setOnAction(e ->  {
			if (showTwitter)
				showTwitter = false;
			else
				showTwitter = true;
		});
		
		Button buttonSettings = new Button("Settings");
		buttonSettings.setOnAction(e -> WindowSettings.openSettings());
		
		Region padderRegion = new Region();
		padderRegion.prefWidthProperty().bind(buttonSettings.widthProperty());
		buttonsTop.setLeft(padderRegion);
		buttonsTop.setCenter(buttonsTopMiddle);
		buttonsTop.setRight(buttonSettings);
		
		frame.setTop(buttonsTop);

		
		//body and options
		VBox optionsAndContent = new VBox(10);
		TextArea content = new TextArea();
		content.setEditable(false);
		content.setWrapText(true);
		content.setPadding(new Insets(10, 0, 0, 10));
		content.prefWidthProperty().bind(optionsAndContent.widthProperty());
		content.prefHeightProperty().bind(Bindings.divide(optionsAndContent.heightProperty(), 2));
		content.setWrapText(true);
		content.setPadding(new Insets(0, 10, 10, 0));
		TextArea replyBox = new TextArea();
		replyBox.prefWidthProperty().bind(optionsAndContent.widthProperty());
		replyBox.prefHeightProperty().bind(Bindings.divide(optionsAndContent.heightProperty(), 2));
		replyBox.setWrapText(true);
		
		//left list
		ListView<String> list = new ListView<>();
		setList(list, content);
		frame.setLeft(list);
		
		optionsAndContent.getChildren().addAll(buttonsOptions(list, content), content, replyBox);
		frame.setCenter(optionsAndContent);
		
		return new Scene(frame, NewWindow.WIDTH, NewWindow.HEIGHT);
		
	}
	
	private static void setList(ListView<String> list, TextArea body) {
		MessageOrganiser.setLists();
		if (list.getItems() != null)
			list.getItems().clear();
		list.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
			body.setText(MessageOrganiser.getBodies(list.getSelectionModel().getSelectedIndex())); //função para ir buscar os corpos das mensagens aqui
		});
		//Função da class Mail que devolve um ArrayList com os títulos 
		List<String> arrayList = MessageOrganiser.getTitles();
		
		for (String title : arrayList) {
			list.getItems().add(title);
		}list.getSelectionModel().select(0);
	}

	private static HBox buttonsOptions(ListView<String> list, TextArea body) {
		HBox options = new HBox(10);
		options.setPadding(new Insets(0, 0, 0, 10));
		options.setAlignment(Pos.BASELINE_LEFT);
		
		Button buttonReply = new Button("Reply");
//		buttonReply.setOnAction(e -> ); //responde diretamente
		
		//refresh
		Button buttonRefresh = new Button("Refresh");
		buttonRefresh.setOnAction(e -> setList(list, body)); 
		
		//filters
		TextField textFilter = new TextField();
		textFilter.setPromptText("Search");
		Button buttonFilter = new Button("Apply");
//		buttonFilter.setOnAction(e -> );
		
		//time
		Button buttonTime= new Button(timeFilterName[timeInt]);
		buttonTime.setOnAction(e -> {
			if (timeInt < 2)
				timeInt++;
			else
				timeInt=0;
			buttonTime.setText(timeFilterName[timeInt]);
			//setTimeFilter(timeInt);
		});
		
		options.getChildren().addAll(buttonReply, buttonRefresh, textFilter, buttonFilter, buttonTime);
		return options;
	}
	
}
