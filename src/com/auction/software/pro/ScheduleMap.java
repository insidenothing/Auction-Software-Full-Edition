package com.auction.software.pro;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;


    		public class ScheduleMap extends MapActivity implements LocationListener {
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
    					
    					 LinearLayout zoomLayout = (LinearLayout)findViewById(R.id.zoom);  
    				        @SuppressWarnings("deprecation")
							View zoomView = mapView.getZoomControls(); 
    				 
    				        zoomLayout.addView(zoomView, 
    				            new LinearLayout.LayoutParams(
    				                LayoutParams.WRAP_CONTENT, 
    				                LayoutParams.WRAP_CONTENT)); 
    				        mapView.displayZoomControls(true);    					
    					
    					
    					mapView.setSatellite(true);
    				    LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    				    lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000L, 500.0f, this);
    				    Location currentGPS = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
    				    p = new GeoPoint((int) (currentGPS.getLatitude() * 1000000), (int) currentGPS.getLongitude() * 1000000); 
    					mc = mapView.getController();
    					mc.setCenter(p);
    					mc.setZoom(11);

    				
    				}


    				
 
    					

    			
    				
  		}