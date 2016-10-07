/*
 * Copyright (c) 2016. CMPUT 301 University of Alberta. All rights reserved.
 * You may use, distribute or copy this code under terms and conditions in the
 * University of Alberta Code of Student Behavior.
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A sequence-like collection of Tweets
 * @author  makepeac
 * @since   1.4
 * @see     Tweet
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Instantiates a new empty TweetList
     */
    public TweetList(){

    }

    /**
     * Gets a tweet at a given index
     * @param index index where the Tweet is in the sequence
     * @return the Tweet at the specified index
     */
    public Tweet getTweet(int index){
        return tweets.get(index);
    }

    /**
     * Verifies if a Tweet is contained in the list
     * @param tweet the Tweet looked for
     * @return <code>true</code> if there is a Tweet in the
     * list equal to the one supplied, <code>false</code> otherwise
     */
    public boolean hasTweet(Tweet tweet){
        return tweets.contains(tweet);
    }

    /**
     * Add a Tweet to the list
     * @param tweet the Tweet to be added
     * @throws IllegalArgumentException when there is already a Tweet equal to
     * it in the list
     */
    public void add(Tweet tweet) {
        if (tweets.contains(tweet))
            throw new IllegalArgumentException("Repeated tweet");
        tweets.add(tweet);
    }

    /**
     * Remove the first Tweet equal to the one passed in as a parameter
     * @param tweet Tweet to be deleted
     */
    public void delete(Tweet tweet) {
        tweets.remove(tweet);
    }

    /**
     * Retrieve all the tweets, sorted by date.
     * @return a List of the Tweets contained in the class, sorted by date
     */
    public List<Tweet> getTweets() {
        List<Tweet> result = new ArrayList<Tweet>(tweets);
        Collections.sort(result, new Comparator<Tweet>() {
            public int compare(Tweet lhs, Tweet rhs) {
                return lhs.getDate().compareTo(rhs.getDate());
            }
        });
        return result;
    }

    /**
     * Get the number of Tweets in the list
     * @return the number of Tweets as an integer
     */
    public int getCount() {
        return tweets.size();
    }
}
