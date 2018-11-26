package facebookApp;

import java.util.List;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.Post;
import com.restfb.types.User;

public class FacebookMain {
	
	//To get a long-lived token
	//https://developers.facebook.com/tools/debug/accesstoken/?access_token=EAAIFIIEgfxIBAIT3qcNBBKXqZBaDBDBcQr7ecRIe8XJHscyZALanWpP5UkmSvw4fUh2dd1eeAH8DSEBp2xwf15r3c3mvtGTyct85LWTabBUcX7DRZAvEA43w8oR3Qg4ZAbrhZCzd1GZAiYZBjzBc6CE71p6vnSn0ZAtG0BjK4xxlZANErvOE9YELCTxX049v2RCq8tTKUgyE64xlqxkMJHSZCQVAainhXvm3QZD
	String accessToken = "EAAIFIIEgfxIBAIZBSW7WG4lUNjJEZBnZAVmOpdFVznXZAgGZCeTLGfHQIN6intn0EIurHZCSae44rb8oXOBhnRXfu9YqpgaVbFBySsgXq4WwoCfZBurQGitZCHQbT18pGsMsSv3Eejj5vi7bAi4YZC7BRyGpF3bwdgQsnKZCGf1Cs2SPVJMfWrm44P";
	FacebookClient fbClient ;
	User me;
	
	
	public FacebookMain() {

		super();
		fbClient = new DefaultFacebookClient(accessToken);
		me = fbClient.fetchObject("me", User.class);	
	
	}
	
	
	/**
	 * 
	 * Initialize Variables/Start Connection
	 * 
	 */
	
	public void init() {
		fbClient = new DefaultFacebookClient(accessToken);
		me = fbClient.fetchObject("me", User.class);	
	}
	
	
	/**
	 * Used mostly for debug or to get the entire User (Class User from library restFB)
	 * Useful to see potential fields available.
	 * 
	 * @return User object
	 */
	public User getMe() {
			return me;
	}
	
	/**
	 * 
	 * @return Currently logged in user's Facebook ID
	 */
	
	public String getMyID() {
		return me.getId();
	}
	

	/**
	 * 
	 * @return	Currently logged in user's Username
	 */
	
	public String getMyUsername() {
		return me.getName();
	}
	
	/**
	 * 
	 * 		postNewPost
	 * 
	 * Cria um novo post feito pelo utilizador.
	 * 
	 * (In Development)
	 * 
	 */
	
	public void postNewPost() {
		
	}
	
	
	/**
	 * getPosts() - Used to get all the posts in the page.
	 * Due to recent limitations on the API can only get "me" - Trying to find a solution, but there doesn't seem to be one with this API.
	 * 
	 * @return Connection<Post> List of all the posts
	 */
	
	public Connection<Post> getPosts() {
		
		Connection<Post> result = fbClient.fetchConnection("me/feed",Post.class);
		return result;
	
	}
	
	/*
	  public List<Post> getPostsList() {
	 
			
			Connection<Post> result = fbClient.fetchConnection("me/posts",Post.class);
			
			List<Post> page = result;
			return page;
		}
		
	*/
	
	
	
	
	/**
	 * 
	 * Method to print what's being obtained from the current fetchConnection command.
	 * Printing to console - Currently being used to 'debug'/test the API and token access. 
	 * 
	 */
	
	public void printSys() {
		

		
		Connection<Post> result = fbClient.fetchConnection("me/feed",Post.class);
		System.out.println("\nPosts:");
		int counter5 = 0;
		int counterTotal = 0;
		
		for (List<Post> page : result) {
			
			for (Post aPost : page) {
				// Filters for posts. --- Many possibilities
				if (aPost.getLikesCount()>=0) {
					
					System.out.println("---- Post "+ counter5 + " ----");
					System.out.println("Id: "+"fb.com/"+aPost.getId());
					System.out.println("Message: "+aPost.getMessage());
					System.out.println("Created: "+aPost.getCreatedTime());
					System.out.println("Picture: "+aPost.getPicture());
					System.out.println("Attachments: "+aPost.getAttachments());
					System.out.println("Likes: "+aPost.getLikesCount());
					System.out.println("Comments: "+aPost.getCommentsCount());
					System.out.println("Full Picture: "+aPost.getFullPicture());
					System.out.println("Attachments:"+aPost.getAttachments());
					
					counter5++;
				}
				counterTotal++;
			}
			
		}
		
		System.out.println("-------------\nNº of Results: " + counter5+"/"+counterTotal);
		
		// Test Below
		/*System.out.println("Username:"+me.getId());
		unsigned int a = Integer.parseInt(me.getId());
		System.out.println("a"+a);
		*/
		
	}
	
	public static void main(String[] args) {	
		/* 
		 * Facebook API Tutorials in Java # 5 | Get User Timeline Posts
		 * https://www.youtube.com/watch?v=wiFif4gOdFE&index=6&list=PLYPFxrXyK0BwiXNe09hTPjFqYbsWv8gxb
		*/ 	
		
		FacebookMain fb = new FacebookMain();
		fb.init();
		fb.printSys();
		
		
	}
}
