/*
 * Copyright (c) 2016. CMPUT 301 University of Alberta. All rights reserved.
 * You may use, distribute or copy this code under terms and conditions in the
 * University of Alberta Code of Student Behavior.
 */

package ca.ualberta.cs.lonelytwitter;


import java.util.Date;

/**
 * Main interface or tweet-like objects
 * @author  watts1
 * @since   1.4
 */
public interface Tweetable {

    /**
     * Getter for the message in a tweet
     * @return the message in the tweet
     */
    public String getMessage();

    /**
     * Getter for the date when a tweet was posted
     * @return the date where the tweet was posted
     */
    public Date getDate();

}
