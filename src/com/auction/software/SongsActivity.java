package com.auction.software;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


	public class SongsActivity extends Activity {
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        Log.i("patrick-code", "full edition holder");
	        TextView textview = new TextView(this);
	        textview.setText("This will be available in the full edition.");
	        setContentView(textview);
	    }
	}