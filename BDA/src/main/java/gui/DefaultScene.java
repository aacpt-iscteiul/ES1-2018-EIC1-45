package gui;

import java.util.ArrayList;

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
		ListView<String> listTweets = new ListView<>();
		setTweetList(listTweets, content);
		frame.setLeft(listTweets);
		
		optionsAndContent.getChildren().addAll(buttonsOptionsEmail(listTweets, content), content, replyBox);
		frame.setCenter(optionsAndContent);
		
		return new Scene(frame, NewWindow.WIDTH, NewWindow.HEIGHT);
		
	}
	
	private static void setTweetList(ListView<String> listEmails, TextArea bodyEmail) {
		if (listEmails.getItems() != null)
			listEmails.getItems().clear();
		listEmails.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
			bodyEmail.setText(funcGetTextMail(listEmails.getSelectionModel().getSelectedIndex())); //função para ir buscar o texto do email aqui
		});
		//Função da class Mail que devolve um ArrayList com os títulos dos emails
		ArrayList<String> arrayListEmails = new ArrayList<>();//Mail.getEmailList(); 
		//temp enquanto nao ha funçao do mail
		for (int i = 0; i < 26; i++) {
			arrayListEmails.add("Título do tweet LOOOOONGOOOOOOOOOOOO " + i + " 25/02/2018\nRemetente");
		}
		for (String email : arrayListEmails) {
			listEmails.getItems().add(email);
		}listEmails.getSelectionModel().select(0);
	}
	

	private static String funcGetTextMail(int selectedIndex) { // funcao para imitar a que se vai usar da classe do email
		String body = "";
		for (int i = 0; i < 36; i++) {
			body += "corpo do tweet" + selectedIndex + " ";
		}
		return body;
	}

	private static HBox buttonsOptionsEmail(ListView<String> listTweets, TextArea tweet) {
		HBox optionsEmail = new HBox(10);
		optionsEmail.setPadding(new Insets(0, 0, 0, 10));
		optionsEmail.setAlignment(Pos.BASELINE_LEFT);
		
		Button buttonReply = new Button("Reply");
//		buttonReply.setOnAction(e -> ); //responde diretamente
		
		//refresh
		Button buttonRefresh = new Button("Refresh");
		buttonRefresh.setOnAction(e -> setTweetList(listTweets, tweet)); 
		
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
		
		optionsEmail.getChildren().addAll(buttonReply, buttonRefresh, textFilter, buttonFilter, buttonTime);
		return optionsEmail;
	}
	
}
