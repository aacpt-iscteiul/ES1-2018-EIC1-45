package twitterApp;

import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public final class TwitterMain {
	public static void main(String[] args) {
		// http://twitter4j.org
		// http://twitter4j.org/en/code-examples.html
		// https://www.youtube.com/watch?v=uYPmkzMpnxw
		try {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey("FaI6Q7K5LmhNQC6U87n2qffpe")
					.setOAuthConsumerSecret("vE0BgXPhwWg1obzg4y68NE79ebJspgiXsRk74tINiMbEYVshn3")
					.setOAuthAccessToken("1054111224428986368-Q1PHXRIo9vq7IjeI1HvOGJkOoBGNxX")
					.setOAuthAccessTokenSecret("vcqLcZosIvFZecOE8bgx13fE79CRTc2VNt7CjXZQoOBAX");
			TwitterFactory tf = new TwitterFactory(cb.build());
			Twitter twitter = tf.getInstance();
			List<Status> statuses = twitter.getHomeTimeline();
			System.out.println("------------------------\n Showing home timeline \n------------------------");
			int counter = 0;
			int counterTotal = 0;
			for (Status status : statuses) {
				
				if (status.getUser().getName() != null && status.getUser().getName().contains("ISCTE")) {
					System.out.println(status.getUser().getName() + ":" + status.getText());
					counter++;
				}
				counterTotal++;
			}
			System.out.println("-------------\nNº of Results: " + counter + "/" + counterTotal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
