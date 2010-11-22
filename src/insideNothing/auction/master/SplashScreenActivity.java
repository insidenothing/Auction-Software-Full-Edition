package insideNothing.auction.master;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;

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
							updateURL = new URL("http://insidenothing.com/socket.php?transmit=application_started");
						} catch (MalformedURLException e) {
							Log.e("insideNothing.Splash", "access tracking failure: "+e);
						}
   		                
						URLConnection conn = null;
						try {
							conn = updateURL.openConnection();
						} catch (IOException e) {
							Log.e("insideNothing.Splash", "access tracking failure: "+e);
						}
 						
   						
						try {
							@SuppressWarnings("unused")
							InputStream is = conn.getInputStream();
						} catch (IOException e) {
							Log.e("insideNothing.Splash", "access tracking failure: "+e);
						} 

						
						
						Log.i("insideNothing.Splash", "Start Updating Database");
						
					
					      final String imageURL = "xml.php?android=1";  //put the downloaded file here
						  final String PATH = "/data/data/insideNothing.auction.master/";  //put the downloaded file here
						  final String fileName = "auctions.xml";  //put the downloaded file here	
					       
					
					 
					
					        //this is the downloader method
					
					                try {
					
					                        URL url = new URL("http://staff.hwestauctions.com/" + imageURL); //you can write here any link
					
					                        File file = new File(fileName);
					
					 
					
					                        long startTime = System.currentTimeMillis();
					
					                        Log.i("insideNothing.Splash", "download begining");
					
					                        Log.i("insideNothing.Splash", "download url:" + url);
					
					                        Log.i("insideNothing.Splash", "downloaded file name:" + fileName);
					
					                        /* Open a connection to that URL. */
					
					                        URLConnection ucon = url.openConnection();
					
					 
					
					                        /*
					
					                         * Define InputStreams to read from the URLConnection.
					
					                         */
					
					                        final int BUFFER_SIZE = 23 * 1024;
					                        InputStream is = ucon.getInputStream();
					                        BufferedInputStream bis = new BufferedInputStream(is, BUFFER_SIZE);
					                        FileOutputStream fos = new FileOutputStream(PATH+fileName);
					                        byte[] baf = new byte[BUFFER_SIZE];
					                        int actual = 0;
					                        while (actual != -1) {
					                            fos.write(baf, 0, actual);
					                            Log.i("insideNothing.Splash", "downloading baf: " + baf);
					                            Log.i("insideNothing.Splash", "downloading actual: " + actual);
					                            actual = bis.read(baf, 0, BUFFER_SIZE);
					                        }

					                        fos.close();
				                        
					                        
					                        
					                        Log.i("insideNothing.Splash", "download ready in"
					
					                                        + ((System.currentTimeMillis() - startTime) / 1000)
					
					                                        + " sec");
					
					 
					
					                } catch (IOException e) {
					
					                        Log.e("insideNothing.Splash", "Error: " + e);
					
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
					//startActivity(new Intent(SplashScreenActivity.this,
					//		AuctionContainer.class));
					startActivity(new Intent(SplashScreenActivity.this,
							Xml2sql.class));
					finish();
				}
			}
		};
		welcomeThread.start();

	}

}
