package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;
import java.util.List;

/**
 * Unit tests for TweetList
 * @author  makepeac
 * @since   1.4
 * @see     android.test.ActivityInstrumentationTestCase2
 * @see     TweetList
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {

    /**
     * Instantiates a new Tweet list test.
     */
    public TweetListTest(){
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    /**
     * Test add tweet.
     */
    public void testAddTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));

        try {
            tweets.add(new NormalTweet("adding tweet"));
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
        }
    }

    /**
     * Test delete.
     */
    public void testDelete(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        list.delete(tweet);
        assertFalse(list.hasTweet(tweet));
    }

    /**
     * Test get tweet.
     */
    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("test");
        tweets.add(tweet);
        Tweet returnedTweet = tweets.getTweet(0);
        assertEquals(returnedTweet.getMessage(), tweet.getMessage());
    }

    /**
     * Test get tweets.
     */
    public void testGetTweets() {
        TweetList tweets = new TweetList();
        String[] expectedOrder = {"1", "2", "3", "4"};
        tweets.add(new NormalTweet("3"));
        tweets.getTweet(0).setDate(new Date(300));
        tweets.add(new NormalTweet("4"));
        tweets.getTweet(1).setDate(new Date(400));
        tweets.add(new NormalTweet("2"));
        tweets.getTweet(2).setDate(new Date(200));
        tweets.add(new NormalTweet("1"));
        tweets.getTweet(3).setDate(new Date(100));

        final List<Tweet> results = tweets.getTweets();
        for (int i = 0; i < expectedOrder.length; i++)
            assertTrue(results.get(i).getMessage().equals(expectedOrder[i]));
    }

    /**
     * Test has tweet.
     */
    public void testHasTweet(){
        TweetList list = new TweetList();
        Tweet tweet = new NormalTweet("test");
        list.add(tweet);
        assertTrue(list.hasTweet(tweet));
        Tweet testTweet = new NormalTweet("test");
        testTweet.setDate(tweet.getDate());
        assertTrue(list.hasTweet(testTweet));
    }

    /**
     * Test get count.
     */
    public void testGetCount() {
        TweetList list = new TweetList();
        assertTrue(list.getCount() == 0);
        list.add(new NormalTweet("test1"));
        list.add(new NormalTweet("test2"));
        list.add(new NormalTweet("test3"));
        assertTrue(list.getCount() == 3);
    }
}
