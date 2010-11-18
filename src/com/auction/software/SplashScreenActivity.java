package com.auction.software;


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;



public class SplashScreenActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		/** set time to splash out */
		final int welcomeScreenDisplay = 1000;
		/** create a thread to show splash up to splash time */
		Thread welcomeThread = new Thread() {

			int wait = 0;

			@Override
			public void run() {
				try {
					super.run();
						URL updateURL = null;
						try {
							updateURL = new URL("http://insidenothing.com/socket.php?transmit=lite_application_started");
						} catch (MalformedURLException e) {
							Log.e("insideNothing.ScheduleMap", "access tracking failure: "+e);
						}
   		                
						URLConnection conn = null;
						try {
							conn = updateURL.openConnection();
						} catch (IOException e) {
							Log.e("insideNothing.ScheduleMap", "access tracking failure: "+e);
						}
 						
   						
						try {
							@SuppressWarnings("unused")
							InputStream is = conn.getInputStream();
						} catch (IOException e) {
							Log.e("insideNothing.ScheduleMap", "access tracking failure: "+e);
						} 

					/**
					 * use while to get the splash time. Use sleep() to increase
					 * the wait variable for every 100L.
					 */
					while (wait < welcomeScreenDisplay) {
						sleep(100);
						wait += 100;
					}
				} catch (Exception e) {
					System.out.println("EXc=" + e);
				} finally {
					/**
					 * Called after splash times up. Do some action after splash
					 * times up. Here we moved to another main activity class
					 */
					startActivity(new Intent(SplashScreenActivity.this,
							HelloTabWidget.class));
					finish();
				}
			}
		};
		welcomeThread.start();

	}
}
