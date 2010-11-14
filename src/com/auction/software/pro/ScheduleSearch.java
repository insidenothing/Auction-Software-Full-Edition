package com.auction.software.pro;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


	public class ScheduleSearch extends Activity {
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        Log.i("patrick-code", "Loaded Search Tab");
	        TextView textview = new TextView(this);
	        textview.setText("Search will be included in the next version release. Working on it every night.");
	        setContentView(textview);
	    }
	}