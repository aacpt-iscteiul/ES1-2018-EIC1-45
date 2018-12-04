package twitterApp;

import java.util.ArrayList;
import java.util.List;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Classe de exibir Tweets na consola
 * 
 * @author Stéphanie Andrade
 * @version 1.01
 *
 */
public class TwitterApp {

	private String authConsumerKey = "FaI6Q7K5LmhNQC6U87n2qffpe";
	private String authConsumerSecret = "vE0BgXPhwWg1obzg4y68NE79ebJspgiXsRk74tINiMbEYVshn3";
	private String authAccessToken = "1054111224428986368-Q1PHXRIo9vq7IjeI1HvOGJkOoBGNxX";
	private String authAccessTokenSecret = "vcqLcZosIvFZecOE8bgx13fE79CRTc2VNt7CjXZQoOBAX";

	/**
	 * Instancia do twitter
	 */
	private Twitter twitter;
	/**
	 * Lista dos estados retirados do twitter
	 */
	private List<Status> statuses;

	/**
	 * Construtor da classe
	 */
	public TwitterApp() {
		getTwitterInstance();
	}

	/**
	 * Metodo para por os tokens do twitter
	 */
	public void getTwitterInstance() {
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey(authConsumerKey).setOAuthConsumerSecret(authConsumerSecret)
					.setOAuthAccessToken(authAccessToken).setOAuthAccessTokenSecret(authAccessTokenSecret);
			TwitterFactory tf = new TwitterFactory(cb.build());
			twitter = tf.getInstance();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Metodo que devolve lista com os tweets do utilizador
	 */
	public ArrayList<String> getUsertimeline() {
		ArrayList<String> result = new ArrayList<String>();

		try {

			statuses = twitter.getUserTimeline();

			for (Status status : statuses) {

				result.add(status.getUser().getName() + ":" + status.getText());

			}

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Metodo devolve lista dos tweets do feed principal
	 */

	public ArrayList<String> getTimeline() {
		ArrayList<String> result = new ArrayList<String>();
		try {
			statuses = twitter.getHomeTimeline();

			for (Status status : statuses) {
				result.add(status.getUser().getName() + ":" + status.getText());

			}

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Metodo que devolve lista de tweets do utilizador procurado
	 * 
	 * @param search
	 * @return
	 */
	public ArrayList<String> getTimelineSearchUserTweets(String search) {

		ArrayList<String> result = new ArrayList<String>();
		try {
			statuses = twitter.getHomeTimeline();

			for (Status status : statuses) {

				if (status.getUser().getName() != null && status.getUser().getName().contains(search)) {
					result.add(status.getUser().getName() + ":" + status.getText());
				}
			}

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Metodo que devolve lista de tweets que contêm a palavra procurada
	 * 
	 * @param search
	 * @return
	 */

	public ArrayList<String> getTimelineSearchTweets(String search) {

		ArrayList<String> result = new ArrayList<String>();
		try {
			statuses = twitter.getHomeTimeline();

			for (Status status : statuses) {

				if (status.getUser().getName() != null && status.getText().contains(search)) {
					result.add(status.getUser().getName() + ":" + status.getText());
				}
			}

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Metodo que devolve o username do utilizador
	 * 
	 * @return
	 */
	public String getUsername() {

		try {

			return twitter.getScreenName();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> getFavorites() {

		ArrayList<String> result = new ArrayList<String>();
		try {
			statuses = twitter.getFavorites();

			for (Status status : statuses) {

				result.add(status.getUser().getName() + ":" + status.getText());
			}

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public void updateStatus(String status) {

		try {
			twitter.updateStatus(status);

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getAuthConsumerKey() {
		return authConsumerKey;
	}

	public String getAuthConsumerSecret() {
		return authConsumerSecret;
	}

	public String getAuthAccessToken() {
		return authAccessToken;
	}

	public String getAuthAccessTokenSecret() {
		return authAccessTokenSecret;
	}
	
	

}