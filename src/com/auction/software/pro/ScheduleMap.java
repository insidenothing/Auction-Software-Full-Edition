package com.auction.software.pro;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import insideNothing.auction.master.R;


    		public class ScheduleMap extends MapActivity implements LocationListener {
    			public boolean onCreateOptionsMenu(Menu maps){
    				MenuInflater inflater = getMenuInflater();
    				inflater.inflate(R.menu.maps, maps);
    				return true;
    				}
 			   MapView mapView; 
 			   MapController mc;
			   GeoPoint p;
    				protected boolean isRouteDisplayed() {
    				    return false;
    				}
   					public void onLocationChanged(Location location) {
					}
					public void onProviderDisabled(String provider) {
					}
					public void onProviderEnabled(String provider) {
					}
					public void onStatusChanged(String provider, int status, Bundle extras) {
					}					
    				public void onCreate(Bundle savedInstanceState) {
    				    super.onCreate(savedInstanceState);
    				    setContentView(R.layout.map_view);
    					mapView = (MapView) findViewById(R.id.mapView);
   				        mapView.setBuiltInZoomControls(true);
    					mapView.setSatellite(false);
    				    LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    				    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100L, 50.0f, this);
    				    Location currentGPS = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    				    Log.i("patrick-debug", "latitude: "+currentGPS.getLatitude());
    				    Log.i("patrick-debug", "longitude: "+currentGPS.getLongitude());
    				    p = new GeoPoint((int) (currentGPS.getLatitude() * 1000000), (int) currentGPS.getLongitude() * 1000000); 
    					mc = mapView.getController();
    					mc.animateTo(p);
    					mc.setZoom(10);
    					
    					
    					
    					
    					
    				}


    		           public boolean onOptionsItemSelected(MenuItem item){
    		    	
    		    	     if (item.hasSubMenu() == false){
    		    	   	 Log.i("patrick-debug", "Menu Command: "+item.getTitle());
    		    	     if (item.getTitle().equals("Satalite View")){
     		    	        Log.i("patrick-debug", "switch map to sat view.");
     		    	        mapView = (MapView) findViewById(R.id.mapView);
     		    	    	mapView.setSatellite(true);
     		    	     }
		    	    	 if (item.getTitle().equals("Map View")){
 		    	    		Log.i("patrick-debug", "switch back to map mode.");	 
     		    	        mapView = (MapView) findViewById(R.id.mapView);
     		    	    	mapView.setSatellite(false);
 		    	         }

    		    	    	 	   
    		    	     
    		    	   }	
    		    	     return true;
   		           }
    		}   		           