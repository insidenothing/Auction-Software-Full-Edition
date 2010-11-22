package insideNothing.auction.master;

import android.app.ListActivity;


public class ScheduleList2 extends ListActivity {
/*
	private static final List<? extends Map<String, ?>> list = null;
	DatabaseHelper eventsData;
	  TextView output;

	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        
	        //setContentView(R.layout.date_list);
		    //output = (TextView) findViewById(R.id.output);
		    eventsData = new DatabaseHelper(this);
		    addEvent("Testing Database");
		    Cursor cursor = getEvents();
		    showEvents(cursor);
	  }
	  
	  @Override
	  public void onDestroy() {
		  super.onDestroy();
		  eventsData.close();
	  }

	  private void addEvent(String title) {
		  Log.d("insideNothing.ScheduleList", "4");

	    SQLiteDatabase db = eventsData.getWritableDatabase();
	    ContentValues values = new ContentValues();
	    values.put(DatabaseHelper.TIME, System.currentTimeMillis());
	    values.put(DatabaseHelper.TITLE, title);
	    db.insert(DatabaseHelper.TABLE, null, values);

	  }

	  private Cursor getEvents() {
		  Log.d("insideNothing.ScheduleList", "5");

	    SQLiteDatabase db = eventsData.getReadableDatabase();
	    Cursor cursor = db.query(DatabaseHelper.TABLE, null, null, null, null,
	        null, null);
	    
	    startManagingCursor(cursor);
	    return cursor;
	  }

	  private void showEvents(Cursor cursor) {
		  Log.d("insideNothing.ScheduleList", "6");
	    StringBuilder RET = new StringBuilder("Saved Events:\n\n");
	    while (cursor.moveToNext()) {
	      long id = cursor.getLong(0);
	      long time = cursor.getLong(1);
	      String title = cursor.getString(2);
	      RET.append(id + ": " + time + ": " + title + ", ");
	      
	    }

/*	    
	    setContentView(R.layout.date_list);
	    ListView lv= (ListView)findViewById(R.id.listview);
	    
	    //output.setText(RET);
	    SimpleAdapter notes = new SimpleAdapter(
	    		this,
	    		list,
	    		R.layout.date_list,
	    		new String[] { "line1","line2" },
	    		new int[] { R.id.text1, R.id.text2 } );
	    lv.setAdapter(notes);
* /
    
		  Log.d("insideNothing.ScheduleList", "end");

	  }
	 
	
}/*	
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
   */ 
	
	
}

	
	
