package insideNothing.auction.master;

import insideNothing.auction.master.R;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.DatePicker;
import android.widget.Toast;


public class ScheduleList extends Activity {
	
	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
		}	

    private int mYear;
    private int mMonth;
    private int mDay;

    static final int DATE_DIALOG_ID = 0;        
        
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.date_list);
       final Calendar c = Calendar.getInstance();
       mYear = c.get(Calendar.YEAR);
       mMonth = c.get(Calendar.MONTH);
       mDay = c.get(Calendar.DAY_OF_MONTH);
       // display the current date (this method is below)
       updateDisplay();
     }        
        
   private void updateWeb(int mMonth,int mDay,int mYear) {
	   Toast.makeText(ScheduleList.this, R.string.list_loading_text,
               Toast.LENGTH_LONG).show();
	   Log.d("insideNothing.ScheduleList", "run web display update code. month:"+mMonth+" day:"+mDay+" year:"+mYear); 
       WebView mWebView;
       //setContentView(R.layout.date_list);
       mWebView = (WebView) findViewById(R.id.webview);
   	   mWebView.getSettings().setJavaScriptEnabled(true);
   	   mWebView.loadUrl("http://mobile.hwestauctions.com?month="+mMonth+"&day="+mDay+"&year="+mYear);
   }
   
   
   // updates the date in the TextView
   private void updateDisplay() {
       // reset the web page to new date
       updateWeb(mMonth + 1,mDay,mYear);
   }
   
   // the callback received when the user "sets" the date in the dialog
   private DatePickerDialog.OnDateSetListener mDateSetListener =
           new DatePickerDialog.OnDateSetListener() {

               public void onDateSet(DatePicker view, int year, 
                                     int monthOfYear, int dayOfMonth) {
                   mYear = year;
                   mMonth = monthOfYear;
                   mDay = dayOfMonth;
                   updateDisplay();
              }
           };
           
           @Override
           protected Dialog onCreateDialog(int id) {
               switch (id) {
               case DATE_DIALOG_ID:
                   return new DatePickerDialog(this,
                               mDateSetListener,
                               mYear, mMonth, mDay);
               }
               return null;
           }

           public boolean onOptionsItemSelected(MenuItem item)
    	   {
    	
    	     if (item.hasSubMenu() == false)
    	     {
    	  
    	    	 Log.d("insideNothing.ScheduleList", "Menu Command: "+item.getTitle());
    	    	 if (item.getTitle().equals("Change date"))
    	    		Log.d("insideNothing.ScheduleList", "process date change.");	 
    	    	    showDialog(DATE_DIALOG_ID);
    	         }
    	    	 	   
    	     return true;
    	   }
}