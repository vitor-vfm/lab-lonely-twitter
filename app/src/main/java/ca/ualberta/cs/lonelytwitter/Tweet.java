/*
 * Copyright (c) 2016. CMPUT 301 University of Alberta. All rights reserved.
 * You may use, distribute or copy this code under terms and conditions in the
 * University of Alberta Code of Student Behavior.
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Basic abstract implementation of a Tweetable
 *
 * @author  watts1
 * @since   1.4
 * @see     Tweetable
 */
public abstract class Tweet implements Tweetable {

    /**
     * The message in the tweet
     */
    private String message;
    /**
     * The date when the tweet was posted
     */
    private Date date;

    /**
     * Instantiates a new Tweet. Generates a Date based on system
     * date when the object is created
     *
     * @param message the message in the tweet
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Instantiates a new Tweet that was posted in a date different from
     * the current date.
     *
     * @param message the message
     * @param date    the date where the tweet was posted
     */
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    @Override
    public String toString(){
        return message;
    }

    /**
     * Whether the Tweet is classified as important.
     *
     * @return <code>true</code> if the Tweet is important, <code>false</code> otherwise
     */
    public abstract Boolean isImportant();


    /**
     * Sets message.
     *
     * @param message the message
     * @throws TweetTooLongException if the tweet message is above the upper limit of 140 characters
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140){
            //Do Something!
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tweet tweet = (Tweet) o;

        if (message != null ? !message.equals(tweet.message) : tweet.message != null) return false;
        return date != null ? date.equals(tweet.date) : tweet.date == null;

    }

    @Override
    public int hashCode() {
        int result = message != null ? message.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
