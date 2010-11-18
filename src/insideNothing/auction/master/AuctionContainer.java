package insideNothing.auction.master;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TabHost;
import insideNothing.auction.master.R;


public class AuctionContainer extends TabActivity {
	



	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    Log.d("insideNothing.AuctionContainer", "Starting Auction Container");
	    requestWindowFeature(Window.FEATURE_NO_TITLE);  
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,   
	    WindowManager.LayoutParams.FLAG_FULLSCREEN);  
	    Log.d("insideNothing.AuctionContainer", "about to set content view");
	    setContentView(R.layout.main);
	    Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab
	    // Create an Intent to launch an Activity for the tab (to be reused)
	    Log.d("insideNothing.AuctionContainer", "init ScheduleMap.class");
	    intent = new Intent().setClass(this, ScheduleMap.class);
	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("artists").setIndicator("Around Me Now",
	                      res.getDrawable(R.drawable.tab_map))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    // Do the same for the other tabs
	    Log.d("insideNothing.AuctionContainer", "init ScheduleList.class");
	    intent = new Intent().setClass(this, ScheduleList.class);
	    spec = tabHost.newTabSpec("albums").setIndicator("Schedule",
	                      res.getDrawable(R.drawable.tab_list))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    Log.d("insideNothing.AuctionContainer", "init ScheduleSearch.class");
	    intent = new Intent().setClass(this, ScheduleSearch.class);
	    spec = tabHost.newTabSpec("songs").setIndicator("Search",
	                      res.getDrawable(R.drawable.tab_search))
	                  .setContent(intent);
	    tabHost.addTab(spec);
	    Log.d("insideNothing.AuctionContainer", "about to set tab");
	    tabHost.setCurrentTab(1);
	}
	

	
	 }

