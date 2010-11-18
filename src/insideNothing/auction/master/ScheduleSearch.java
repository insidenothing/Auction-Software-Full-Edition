package insideNothing.auction.master;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;
import insideNothing.auction.master.R;



	public class ScheduleSearch extends Activity {
	    @Override
		public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        Log.d("insideNothing.ScheduleSearch", "Loaded Search Tab");
	       // TextView textview = new TextView(this);
	       // textview.setText("Search will be included in the next version release. Working on it every night.");
	       // setContentView(textview);
	        setContentView(R.layout.search);
	        
	        updateDisplay();
	        
	    

	}
	    
	    private void updateDisplay() {
	        // reset the web page to new date
		    final EditText edittext = (EditText) findViewById(R.id.edittext);
		    edittext.setOnKeyListener(new View.OnKeyListener() {
		        public boolean onKey(View v, int keyCode, KeyEvent event) {
		            // If the event is a key-down event on the "enter" button
		            if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
		                (keyCode == KeyEvent.KEYCODE_ENTER)) {
		              // Perform action on key press
		              Toast.makeText(ScheduleSearch.this, "Searching database for "+edittext.getText(), Toast.LENGTH_SHORT).show();
		              updateWeb(edittext.getText());
		              return true;
		            }
		            return false;
		        }
		    });

	    }
	    
	    private void updateWeb(Editable editable) {
	 	   Log.d("insideNothing.ScheduleSearch", "run web query. q:"+editable); 
	        WebView mWebView;
	        mWebView = (WebView) findViewById(R.id.webview);
	    	mWebView.getSettings().setJavaScriptEnabled(true);
	    	mWebView.loadUrl("http://mobile.hwestauctions.com?q="+editable);
	    }
	}