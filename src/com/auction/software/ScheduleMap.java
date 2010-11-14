package com.auction.software;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TextView;

import com.auction.software.pro.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;



    		public class ScheduleMap extends MapActivity implements OnTabChangeListener {

    		    private static final String LIST_TAB_TAG = "List";
    		    private static final String MAP_TAB_TAG = "Map";
    		 
    		    private TabHost tabHost;
    		 
    		    private ListView listView;
    		    private MapView mapView;
    		 
    		    public void onCreate(Bundle savedInstanceState) {
    		        super.onCreate(savedInstanceState);

    		        setContentView(R.layout.map_view);

    		 
    		        tabHost = (TabHost) findViewById(android.R.id.tabhost);
    		 
    		        // setup must be called if you are not inflating the tabhost from XML
    		        tabHost.setup();
    		        tabHost.setOnTabChangedListener(this);
    		 
    		        // setup list view
    		        listView = (ListView) findViewById(R.id.list);
    		        listView.setEmptyView((TextView) findViewById(R.id.empty));
    		 
    		        // create some dummy coordinates to add to the list
    		        List<GeoPoint> pointsList = new ArrayList<GeoPoint>();
    		        pointsList.add(new GeoPoint((int)(32.864*1E6), (int)(-117.2353*1E6)));
    		        pointsList.add(new GeoPoint((int)(37.441*1E6), (int)(-122.1419*1E6)));
    		        listView.setAdapter(new ArrayAdapter<GeoPoint>(this, android.R.layout.simple_list_item_1, pointsList));
    		 
    	        	Log.i("patrick-code", "add an onclicklistener to see point on the map");
    	        	// add an onclicklistener to see point on the map
    		        listView.setOnItemClickListener(new OnItemClickListener() {

    		        	@SuppressWarnings("rawtypes")
    					public void onItemClick(AdapterView parent, View view, int position, long id) {
    		                GeoPoint geoPoint = (GeoPoint) listView.getAdapter().getItem(position);
    		                if(geoPoint != null) {
    		                    // have map view moved to this point
    		                    setMapZoomPoint(geoPoint, 12);
    		                    // programmatically switch tabs to the map view
    		                    tabHost.setCurrentTab(1);
    		                }
    		            }
    		        });
    		 
    		        // setup map view
    		        Log.i("patrick-code", "start mapview");
    		        mapView = (MapView) findViewById(R.id.mapView);
    		        mapView.setBuiltInZoomControls(true);
    		        mapView.postInvalidate();
    		        Log.i("patrick-code", "finish mapview");
    		        // add views to tab host
    		        tabHost.addTab(tabHost.newTabSpec(LIST_TAB_TAG).setIndicator("List").setContent(new TabContentFactory() {
    		            public View createTabContent(String arg0) {
    		                return listView;
    		            }
    		        }));
    		        tabHost.addTab(tabHost.newTabSpec(MAP_TAB_TAG).setIndicator("Map").setContent(new TabContentFactory() {
    		            public View createTabContent(String arg0) {
    		                return mapView;
    		            }
    		        }));
    		 
    		        //HACK to get the list view to show up first,
    		        // otherwise the mapview would be bleeding through and visible
    		        tabHost.setCurrentTab(1);
    		        tabHost.setCurrentTab(0);
    		    }
    		 
    		    /**
    		     * Instructs the map view to navigate to the point and zoom level specified.
    		     * @param geoPoint
    		     * @param zoomLevel
    		     */
    		    private void setMapZoomPoint(GeoPoint geoPoint, int zoomLevel) {
    		    	Log.i("patrick-code", "go to: "+geoPoint+" at zoom "+zoomLevel);
    		        mapView.getController().setCenter(geoPoint);
    		        mapView.getController().setZoom(zoomLevel);
    		        mapView.postInvalidate();
    		    }
    		 
    		    /**
    		     * From MapActivity, we ignore it for this demo
    		     */
    		    @Override
    		    protected boolean isRouteDisplayed() {
    		        return false;
    		    }
    		 
    		    /**
    		     * Implement logic here when a tab is selected
    		     */
    		    public void onTabChanged(String tabName) {
    		        if(tabName.equals(MAP_TAB_TAG)) {
    		        	Log.i("patrick-code", "do something on the map");
    		            //do something on the map
    		        }
    		        else if(tabName.equals(LIST_TAB_TAG)) {
    		        	Log.i("patrick-code", "do something on the list");
    		            //do something on the list
    		        }
    		    }
    		}    	  