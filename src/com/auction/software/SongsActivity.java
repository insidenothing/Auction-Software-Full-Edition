package com.auction.software;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


	public class SongsActivity extends Activity {
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        Log.i("patrick-code", "Loaded Search Tab");
	        TextView textview = new TextView(this);
	        textview.setText("Search feature is in development.");
	        setContentView(textview);
	    }
	}