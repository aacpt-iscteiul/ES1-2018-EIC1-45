package gui;


import java.util.ArrayList;
import java.util.List;

import com.restfb.Connection;
import com.restfb.types.Post;

import mailApp.Mail;

public class MessageOrganiser {

	private static List<String> bodies = new ArrayList<>();
	private static List<String> titles = new ArrayList<>();
	
	private static List<Mail> mails;
	private static Connection<Post> posts; 
	
	/**
	 * Gets and sets the lists for the gui to use
	 * */
	
	public static void setLists() {
		mails = NewWindow.readMail.getMailList();
		posts = NewWindow.fb.getPosts();
		
		
		//while there is no organiser
		for (Mail m : mails) {
			bodies.add(m.getEmailBody());
			titles.add("Mail: "  + m.getEmailSubject() + "\n" +  m.getSenderEmail() + "\n" + m.getSentDate());
		}for (List<Post> page : posts) {
			for (Post aPost : page) {
				bodies.add(aPost.getMessage());
				titles.add("Facebook: " + aPost.getDescription() + "\n" + aPost.getCreatedTime());
			}
		}
	}

	
	/**
	 * returns the body of the selected title
	 * 
	 * @param selectedIndex
	 * 
	 * @return body
	 * */
	public static String getBody(int selectedIndex) {
		return bodies.get(selectedIndex);
	}

	/**
	 * returns all titles in a List
	 * 
	 * @return titles
	 * */	
	public static List<String> getTitles() {
		return titles;
	}
	

}
