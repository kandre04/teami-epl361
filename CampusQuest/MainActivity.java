package com.example.findingooglemaps;



import java.io.IOException;



import java.util.List;
import java.util.Locale;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.content.Intent;
import android.graphics.Color;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.SupportMapFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends FragmentActivity {

	private GoogleMap googleMap;
	private double lat, lon = 0;

	protected void onCreate(Bundle savedInstanceState)  {
		 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTheme(android.R.style.Theme_Black_NoTitleBar_Fullscreen);
		

		
		ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cm
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
			//View view = null;
		   // view = inflater.inflate(R.layout.activity_main, container, true);
			SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
			googleMap = mapFragment.getMap();
			googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			googleMap.setMyLocationEnabled(true);
			LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
			Criteria criteria = new Criteria();
			String provider = service.getBestProvider(criteria, false);
			Location location = service.getLastKnownLocation(provider);

			lat = location.getLatitude();
			lon = location.getLongitude();
			googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.144424,33.411309) , 14.0f));

			addUCYtoMap();
			PolylineOptions rectOptions = new PolylineOptions()
	        .add(new LatLng(35.142424,33.405309))
	        .add(new LatLng(35.149424,33.411309))  //pa, North of the previous point, but at the same longitude
	        .add(new LatLng(35.147424,33.417309))  //pd,Same latitude, and 30km to the west
	        .add(new LatLng(35.141424,33.407309))  //,kd Same longitude, and 16km to the south
	        .add(new LatLng(35.142424,33.405309)); //,ka Closes the polyline.

	// Set the rectangle's color to red
	rectOptions.color(Color.RED);

	// Get back the mutable Polyline
	Polyline polyline = googleMap.addPolyline(rectOptions);
			
					

		}
	}
	

	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.location, menu);
	        return true;
	    }
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		
	}

	public void addUCYtoMap(){
		LatLng pos= new LatLng(35.144424,33.411309);
		googleMap.addMarker(new MarkerOptions()
				 .title("UCY")
				 .snippet("UCY Panepistimioupoli")
				 .position(pos)
				 .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
				 );
		}
	
}
