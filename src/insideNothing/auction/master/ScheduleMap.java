package insideNothing.auction.master;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;


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
   						
   						URL updateURL = null;
						try {
							updateURL = new URL("http://insidenothing.com/socket.php?transmit="+location);
						} catch (MalformedURLException e) {
							Log.e("insideNothing.ScheduleMap", "access tracking failure: "+e);
						}
   		                
						URLConnection conn = null;
						try {
							conn = updateURL.openConnection();
						} catch (IOException e) {
							Log.e("insideNothing.ScheduleMap", "access tracking failure: "+e);
						}
 						
   						
						try {
							@SuppressWarnings("unused")
							InputStream is = conn.getInputStream();
						} catch (IOException e) {
							Log.e("insideNothing.ScheduleMap", "access tracking failure: "+e);
						} 

						
						
						
   						Log.d("insideNothing.ScheduleMap", "location changed: "+location);
					}
					public void onProviderDisabled(String provider) {
   						Log.d("insideNothing.ScheduleMap", "provider disabled: "+provider);
   					}
					public void onProviderEnabled(String provider) {
   						Log.d("insideNothing.ScheduleMap", "provider enabled: "+provider);
					}
					public void onStatusChanged(String provider, int status, Bundle extras) {
   						Log.d("insideNothing.ScheduleMap", "status changed: "+status+" provider: "+provider);
					}					
    				public void onCreate(Bundle savedInstanceState) {
    				    super.onCreate(savedInstanceState);
   						Log.d("insideNothing.ScheduleMap", "set content view");
    				    setContentView(R.layout.map_view);
    					mapView = (MapView) findViewById(R.id.mapView);
   				        mapView.setBuiltInZoomControls(true);
    					mapView.setSatellite(false);
    					Log.d("insideNothing.ScheduleMap", "start location manager");
    				    LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    				    Log.d("insideNothing.ScheduleMap", "request gps");
    				    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 500.0f, this);
    				    Log.d("insideNothing.ScheduleMap", "access currentGPS");
    				    try {
    				    Location currentGPS = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    				    Log.v("insideNothing.ScheduleMap", "set latitude: "+currentGPS.getLatitude());
    				    Log.v("insideNothing.ScheduleMap", "set longitude: "+currentGPS.getLongitude());
    				    p = new GeoPoint((int) (currentGPS.getLatitude() * 1E6), (int) (currentGPS.getLongitude() * 1E6)); 
    				    mc = mapView.getController();
    				    Log.v("insideNothing.ScheduleMap", "set GeoPoint: "+p);
    					mc.animateTo(p);
    					mc.setZoom(8);
    					
    					
    					
   						URL updateURL = null;
						try {
							updateURL = new URL("http://insidenothing.com/socket.php?transmit="+currentGPS);
						} catch (MalformedURLException e) {
							Log.e("insideNothing.ScheduleMap", "access tracking failure: "+e);
						}
   		                @SuppressWarnings("unused")
						URLConnection conn = null;
						try {
							conn = updateURL.openConnection();
						} catch (IOException e) {
							Log.e("insideNothing.ScheduleMap", "access tracking failure: "+e);
						}

    					
    				    } catch (Exception err) {
    				    	Log.e("insideNothing.ScheduleMap", "gps failure: "+err);
    				    	Toast.makeText(ScheduleMap.this, R.string.gps_error_text,
    			                    Toast.LENGTH_LONG).show();
    				    }
    					
    					
    					
    					
    					
    				}


    		           public boolean onOptionsItemSelected(MenuItem item){
    		    	
    		    	     if (item.hasSubMenu() == false){
    		    	   	 Log.d("insideNothing.ScheduleMap", "Menu Command: "+item.getTitle());
    		    	     if (item.getTitle().equals("Satalite View")){
     		    	        Log.d("insideNothing.ScheduleMap", "switch map to sat view.");
     		    	        mapView = (MapView) findViewById(R.id.mapView);
     		    	    	mapView.setSatellite(true);
     		    	     }
		    	    	 if (item.getTitle().equals("Map View")){
	 		    	    		Log.d("insideNothing.ScheduleMap", "switch back to map mode");	 
	     		    	        mapView = (MapView) findViewById(R.id.mapView);
	     		    	    	mapView.setSatellite(false);
	 		    	    }
		    	    	 if (item.getTitle().equals("My Location")){
 		    	    		Log.d("insideNothing.ScheduleMap", "jump to current location");	 
     		    	        mapView = (MapView) findViewById(R.id.mapView);
     		    	    	mapView.setSatellite(true);
        					Log.d("insideNothing.ScheduleMap", "jump start location manager");
        				    LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        				    Log.d("insideNothing.ScheduleMap", "jump request gps");
        				    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 500.0f, this);
        				    Log.d("insideNothing.ScheduleMap", "jump access currentGPS");
        				    try {
        				    Location currentGPS = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        				    Log.v("insideNothing.ScheduleMap", "jump set latitude: "+currentGPS.getLatitude());
        				    Log.v("insideNothing.ScheduleMap", "jump set longitude: "+currentGPS.getLongitude());
        				    p = new GeoPoint((int) (currentGPS.getLatitude() * 1E6), (int) (currentGPS.getLongitude() * 1E6)); 
        				    mc = mapView.getController();
        				    Log.v("insideNothing.ScheduleMap", "set GeoPoint: "+p);
        				    Toast.makeText(ScheduleMap.this, R.string.my_location,
    			                    Toast.LENGTH_SHORT).show();
        				    mc.animateTo(p);
        					mc.setZoom(16);
        				    } catch (Exception err) {
        				    	Log.e("insideNothing.ScheduleMap", "jump gps failure: "+err);
        				    	Toast.makeText(ScheduleMap.this, R.string.gps_error_text,
        			                    Toast.LENGTH_LONG).show();
        				    }
		    	    	 }
    		    	   }	
   		    	     return true;
   		           }
    		}   		           