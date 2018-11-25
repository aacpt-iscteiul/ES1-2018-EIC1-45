package twitterApp;

import java.util.List;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterApp {

	private List<Status> statuses;
	private Twitter twitter;

	public TwitterApp() {
		getStatus();
		getTimeline();
		getUsertimeline();
	}

	public void getStatus() {
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("FaI6Q7K5LmhNQC6U87n2qffpe")
					.setOAuthConsumerSecret("vE0BgXPhwWg1obzg4y68NE79ebJspgiXsRk74tINiMbEYVshn3")
					.setOAuthAccessToken("1054111224428986368-Q1PHXRIo9vq7IjeI1HvOGJkOoBGNxX")
					.setOAuthAccessTokenSecret("vcqLcZosIvFZecOE8bgx13fE79CRTc2VNt7CjXZQoOBAX");
			TwitterFactory tf = new TwitterFactory(cb.build());
			twitter = tf.getInstance();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void getUsertimeline() {
		try {
			statuses = twitter.getUserTimeline();
			System.out.println("------------------------\n Showing user timeline \n------------------------");
			int counter = 0;

			for (Status status : statuses) {

				System.out.println(status.getUser().getName() + ":" + status.getText());
				counter++;

			}
			System.out.println("-------------\nN� of Results: " + counter);

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getTimeline() {
		try {
			statuses = twitter.getHomeTimeline();
			System.out.println("------------------------\n Showing home timeline \n------------------------");
			int counter = 0;

			for (Status status : statuses) {

				System.out.println(status.getUser().getName() + ":" + status.getText());
				counter++;

			}
			System.out.println("-------------\nN� of Results: " + counter);

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getTimelineSearch(String search) {

		try {
			statuses = twitter.getHomeTimeline();
			System.out.println("------------------------\n Showing home timeline \n------------------------");
			int counter = 0;

			for (Status status : statuses) {

				if (status.getUser().getName() != null && status.getUser().getName().contains(search)) {
					System.out.println(status.getUser().getName() + ":" + status.getText());
					counter++;
				}
			}
			System.out.println("-------------\nN� of Results: " + counter);

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}