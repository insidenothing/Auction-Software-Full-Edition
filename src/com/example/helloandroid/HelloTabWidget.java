package com.example.helloandroid;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;

public class HelloTabWidget extends TabActivity {
	
	public void onCreate(Bundle savedInstanceState) {
		Log.i("patrick-code", "starting onCreate");
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.main);
	    Log.i("patrick-code", "2 onCreate");
	    Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab
	    Log.i("patrick-code", "3 onCreate");
	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, ArtistsActivity.class);
	    Log.i("patrick-code", "4 onCreate");
	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("artists").setIndicator("Artists",
	                      res.getDrawable(R.drawable.ic_tab_artists))
	                  .setContent(intent);
	    
	    
	    
	    
	    Log.i("patrick-code", "4a onCreate: "+spec);
	    tabHost.addTab(spec);
	    
	    
	    
	    
	    
	    Log.i("patrick-code", "5 onCreate");
	    // Do the same for the other tabs
	    intent = new Intent().setClass(this, AlbumsActivity.class);
	    spec = tabHost.newTabSpec("albums").setIndicator("Albums",
	                      res.getDrawable(R.drawable.ic_tab_albums))
	                  .setContent(intent);
	    Log.i("patrick-code", "5a onCreate: "+spec);
	    tabHost.addTab(spec);
	    Log.i("patrick-code", "6 onCreate");
	    intent = new Intent().setClass(this, SongsActivity.class);
	    spec = tabHost.newTabSpec("songs").setIndicator("Songs",
	                      res.getDrawable(R.drawable.ic_tab_songs))
	                  .setContent(intent);
	    Log.i("patrick-code", "6a onCreate: "+spec);
	    tabHost.addTab(spec);
	    Log.i("patrick-code", "7 onCreate");
	    tabHost.setCurrentTab(2);
	    Log.i("patrick-code", "ending onCreate");
	}
}