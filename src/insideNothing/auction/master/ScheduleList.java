package insideNothing.auction.master;




import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;



public class ScheduleList extends ListActivity {
	
	final static String MY_DB_NAME = "TestingDatab.db";
	final static String MY_DB_TABLE = "testingtable";
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);      
    
    	SQLiteDatabase myDB = null; 
    	try {
    		myDB = this.openOrCreateDatabase(MY_DB_NAME, MODE_PRIVATE, null);
    		myDB.execSQL("CREATE TABLE IF NOT EXISTS " + MY_DB_TABLE + " ( carID INTEGER PRIMARY KEY autoincrement,  name varchar(100));");
    		myDB.execSQL("INSERT INTO " + MY_DB_TABLE + " (name)" + " VALUES ('Audi TT');"); 
    		myDB.execSQL("INSERT INTO " + MY_DB_TABLE + " (name)" + " VALUES ('Honda Civic');");

    		Cursor mCursor = myDB.rawQuery("SELECT name" + ", carID as _id FROM " + MY_DB_TABLE, null);
    		startManagingCursor(mCursor);
    		
    		ListAdapter adapter = new SimpleCursorAdapter(this, R.layout.schedule, mCursor, new String[] { "_id", "name" }, new int[] {R.id.ID, R.id.Name });
    		this.setListAdapter(adapter);
    		this.getListView().setTextFilterEnabled(true);

    	} finally {
        	if (myDB != null) {
        		myDB.close();
        	}
        }
    }    
}
