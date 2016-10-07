/*
 * Copyright (c) 2016. CMPUT 301 University of Alberta. All rights reserved.
 * You may use, distribute or copy this code under terms and conditions in the
 * University of Alberta Code of Student Behavior.
 */

package ca.ualberta.cs.lonelytwitter;

/**
 * A tweet of high importance
 * @since   1.4
 * @author  watts1
 * @see     Tweet
 */
public class ImportantTweet extends Tweet{

    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     */
    public ImportantTweet(String message){
        super(message);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }


}
