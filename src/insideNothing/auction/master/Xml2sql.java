package insideNothing.auction.master;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class Xml2sql extends Activity {
	Button btnXML;
	TextView tvData;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmlprocess);
        
        
        tvData = (TextView) findViewById(R.id.txtData);
        btnXML = (Button) findViewById(R.id.btnXML);
        btnXML.setOnClickListener(new Button.OnClickListener()
        {
        	public void onClick(View v)
        	{ 
        		examineXMLFile();
				startActivity(new Intent(Xml2sql.this,
						AuctionContainer.class));
				//startActivity(new Intent(SplashScreenActivity.this,
				//		Xml2sql.class));
				finish();

        	}
        });
        

   
        
    }
    
    void examineXMLFile()
    {
    	try {
    		 final String PATH = "/data/data/insideNothing.auction.master/";  //put the downloaded file here
			  final String fileName = "auctions.xml";  //put the downloaded file here	
		     
    		InputSource is = new InputSource(new FileInputStream(PATH+fileName));
    		Log.i("insideNothing.Xml2sql", "open file name:" + PATH + fileName);
    		//InputSource is = new InputSource(getResources().openRawResource(R.raw.xmltwitter));
    		Log.i("insideNothing.Xml2sql", "create the factory");	
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	
	        Log.i("insideNothing.Xml2sql", "create a parser");
	        SAXParser parser = factory.newSAXParser();

	        Log.i("insideNothing.Xml2sql", "create the reader (scanner)");
	        XMLReader xmlreader = parser.getXMLReader();

	        Log.i("insideNothing.Xml2sql", "instantiate our handler");
	        XmlHandler tfh = new XmlHandler();

	        Log.i("insideNothing.Xml2sql", "assign our handler");
	        xmlreader.setContentHandler(tfh);

	        Log.i("insideNothing.Xml2sql", "perform the synchronous parse");
	        xmlreader.parse(is);
	        
	        Log.i("insideNothing.Xml2sql", "should be done... ");
	        tfh.getResults();
		}
    	catch (Exception e) {
    		Log.e("insideNothing.Xml2sql", "oops.. "+e.getMessage());
    	}

    
  
    }
}