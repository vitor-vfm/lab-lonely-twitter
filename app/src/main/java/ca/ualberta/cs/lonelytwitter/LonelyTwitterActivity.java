/*
 * Copyright (c) 2016. CMPUT 301 University of Alberta. All rights reserved.
 * You may use, distribute or copy this code under terms and conditions in the
 * University of Alberta Code of Student Behavior.
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * The first and main activity for the Lonely Twitter app.
 * @since 	1.4
 * @see Tweet
 * @see TweetList
 */
public class LonelyTwitterActivity extends Activity {

	/**
	 * The name of the file where the tweet information will be stored
	 * @see NormalTweet
	 */
	private static final String FILENAME = "file.sav";

	/**
	 * The message for the tweet to be added
	 */
	private EditText bodyText;
	/**
	 * Tweets from previous dates
	 */
	private ListView oldTweetsList;

	/**
	 * Internal list of Tweets used by the activity
	 */
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
	/**
	 * Adapter for old tweets list
	 */
	private ArrayAdapter<Tweet> adapter;
	
	/**
	 * Called when the activity is first created.
	 * */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				Tweet newTweet = new NormalTweet(text);
				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Load the tweets from a pre-existent data file. If the file doesn't exist,
	 * the tweet list is initialized as empty.
	 * @throws RuntimeException when there is an IOException when reading the file
	 */
	private void loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			//Code taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt Sept.22,2016
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, listType);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}

	/**
	 * Load the tweets in the data file with the name specified by <code>FILENAME</code>.
	 * If the file doesn't exist, the tweet list is initialized as empty.
	 * @throws RuntimeException when there is an IOException when reading the file or the file can't be opened
	 */
	private void saveInFile() {
		try {

			FileOutputStream fos = openFileOutput(FILENAME,0);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			Gson gson = new Gson();
			gson.toJson(tweetList, writer);
			writer.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}