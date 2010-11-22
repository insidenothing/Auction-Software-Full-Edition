package insideNothing.auction.master;

import java.util.ArrayList;
import java.util.jar.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.util.Log;




public class XmlHandler extends DefaultHandler {
	 private Person person;
	   private ArrayList<Person> personList;
	   private StringBuffer buffer = new StringBuffer();   

	
	class Person {
		
		    public String score;
		    public String popularity;
		    public String name;
		    public String id;
		    public String biography;
		    public String url;
		    public String version;
		    public String lastModifiedAt;
		//    public ArrayList<img> imagesList;
		 
		}

	
 

    XmlHandler() {
    	Log.d("insideNothing.XmlHandler", "XmlHandler()");
    }

    void getResults()
    {
    	Log.d("insideNothing.XmlHandler", "String getResults");
    }
    @Override

    public void startDocument() throws SAXException {
    	Log.d("insideNothing.XmlHandler", "startDocument()");
    	// initialize "list"
    }

    @Override
    public void endDocument() throws SAXException {
    	Log.d("insideNothing.XmlHandler", "endDocument()");
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
    	Log.i("insideNothing.XmlHandler", "startElement(namespaceURI: "+namespaceURI);
    	Log.i("insideNothing.XmlHandler", "startElement(localName: "+localName);
    	Log.i("insideNothing.XmlHandler", "startElement(qName: "+qName);
    	Log.i("insideNothing.XmlHandler", "startElement(atts: "+atts);
    	//buffer.setLength(0);
    		         
    		        if (localName.equals("markers")) {
    		            personList = new ArrayList<Person>();
    		        }
    		        else if (localName.equals("marker")) {
    		            person = new Person();
    		        }
    }



    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
    	Log.i("insideNothing.XmlHandler", "endElement(namespaceURI: "+namespaceURI);
    	Log.i("insideNothing.XmlHandler", "endElement(localName: "+localName);
    	Log.i("insideNothing.XmlHandler", "endElement(qName: "+qName);
    	 if (localName.equals("marker")) {
   	           // personList.add(person);
         }
    }



    @Override

    public void characters(char ch[], int start, int length) {
	        String theString = new String(ch, start, length);
	        Log.i("insideNothing.XmlHandler", "data: "+theString);
	       
    }

}

