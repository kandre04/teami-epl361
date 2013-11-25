package com.example.findingooglemaps;




import java.io.IOException;

import java.util.List;
import java.util.Locale;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class MapChooseInfoActivity extends FragmentActivity {

	private GoogleMap googleMap;
	private double lat, lon = 0;
	private String english, postal1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(android.R.style.Theme_Black_NoTitleBar);
		setContentView(R.layout.activity_map_choose_info);

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		postal1 = bundle.getString("postal");
		String service1 = bundle.getString("service");
		String cuisine = bundle.getString("food");
		english = bundle.getString("SearchText");

		ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cm
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
			SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map);
			googleMap = mapFragment.getMap();
			googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			googleMap.setMyLocationEnabled(true);

			if (service1.equals("restaurant") == true
					&& cuisine.equals("Italian") == true) {
				Toast.makeText(getApplicationContext(),
						"Service Restaurants chosen", Toast.LENGTH_SHORT)
						.show();

				Marker rest = googleMap.addMarker(new MarkerOptions().position(
						new LatLng(35.161479, 33.358627)).title(
						"Aperitivo Jetset Lounge"));
				rest.showInfoWindow();
			}

			else if (service1.equals("restaurant") == true
					&& cuisine.equals("Italian") == false) {

				Toast.makeText(getApplicationContext(),
						"No restaurants available", Toast.LENGTH_SHORT).show();
			}

			else if (service1.equals("landmarks") == true) {
				Toast.makeText(getApplicationContext(),
						"Service Landmarks chosen", Toast.LENGTH_SHORT).show();
				Marker amathounta = googleMap.addMarker(new MarkerOptions()
						.position(new LatLng(34.710202, 33.142182)).title(
								"Amathounta"));

				Marker kourio = googleMap.addMarker(new MarkerOptions()
						.position(new LatLng(34.664152, 32.888001)).title(
								"Kourion"));
				amathounta.showInfoWindow();
				kourio.showInfoWindow();

			}

			else if (service1.equals("ekko") == true) {
				Toast.makeText(getApplicationContext(),
						"Service Petrol Station chosen", Toast.LENGTH_SHORT)
						.show();

				Marker luk = googleMap.addMarker(new MarkerOptions().position(
						new LatLng(35.164185, 33.364509)).title(
						"Lukoil Gas Station"));
				luk.showInfoWindow();

				Marker eko = googleMap.addMarker(new MarkerOptions().position(
						new LatLng(35.155437, 33.398596)).title(
						"Eko Gas Station"));
				eko.showInfoWindow();
			} else if (service1.equals("coin") == true) {
				Toast.makeText(getApplicationContext(), "Service Banks chosen",
						Toast.LENGTH_SHORT).show();
			} else if (service1.equals("geniko") == true) {
				Toast.makeText(getApplicationContext(),
						"Service Hospitals chosen", Toast.LENGTH_SHORT).show();
				Marker lim = googleMap.addMarker(new MarkerOptions().position(
						new LatLng(34.706919, 32.983221)).title(
						"General Hospital of Limassol"));
				lim.showInfoWindow();

				Marker nic = googleMap.addMarker(new MarkerOptions().position(
						new LatLng(35.126993, 33.377130)).title(
						"General Hospital of Nicosia"));
				nic.showInfoWindow();
			} else if (service1.equals("gloria") == true) {

				Toast.makeText(getApplicationContext(), "Service Caffe chosen",
						Toast.LENGTH_SHORT).show();
				Marker star = googleMap.addMarker(new MarkerOptions().position(
						new LatLng(34.696663, 33.091740)).title(
						"Starbucks Limassol"));
				star.showInfoWindow();

				Marker glo = googleMap.addMarker(new MarkerOptions().position(
						new LatLng(35.163133, 33.359883)).title(
						"Gloria Jeans Cafe"));
				glo.showInfoWindow();

				Marker starn = googleMap.addMarker(new MarkerOptions()
						.position(new LatLng(35.163174, 33.358672)).title(
								"Starbucks Nicosia"));
				starn.showInfoWindow();

			} else if (service1.equals("hotels") == true) {
				Toast.makeText(getApplicationContext(),
						"Service Hotels chosen", Toast.LENGTH_SHORT).show();
				Marker sea = googleMap.addMarker(new MarkerOptions().position(
						new LatLng(34.709162, 33.128090)).title(
						"Four Seasons Hotel"));
				sea.showInfoWindow();

				Marker gra = googleMap.addMarker(new MarkerOptions().position(
						new LatLng(34.713747, 33.162720)).title(
						"Grant Resort Hotel"));
				gra.showInfoWindow();
				Marker hilto = googleMap.addMarker(new MarkerOptions()
						.position(new LatLng(35.159090, 33.371849)).title(
								"Hilton Hotel"));
				hilto.showInfoWindow();
			} else if (service1.equals("rio") == true) {
				Toast.makeText(getApplicationContext(),
						"Service Cinemas chosen", Toast.LENGTH_SHORT).show();
				Marker rion = googleMap.addMarker(new MarkerOptions().position(
						new LatLng(34.678556, 33.040676)).title("Rio Cinema"));
				rion.showInfoWindow();
				Marker kc = googleMap.addMarker(new MarkerOptions().position(
						new LatLng(34.705773, 33.106946)).title(
						"Kcineplex Cinema"));
				kc.showInfoWindow();
			} else if (service1.equals("bazaar") == true) {
				Toast.makeText(getApplicationContext(),
						"Service Clothe Stores chosen", Toast.LENGTH_SHORT)
						.show();

				Marker mal = googleMap.addMarker(new MarkerOptions().position(
						new LatLng(34.652359, 32.997104)).title(
						"My Mall Limassol"));
				mal.showInfoWindow();

				Marker ike = googleMap.addMarker(new MarkerOptions().position(
						new LatLng(35.129699, 33.373343)).title("IKEA"));
				ike.showInfoWindow();

				Marker malnic = googleMap.addMarker(new MarkerOptions()
						.position(new LatLng(35.129857, 33.371304)).title(
								"Mall of Cyprus"));

				malnic.showInfoWindow();
			}

			

			
			LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
			Criteria criteria = new Criteria();
			String provider = service.getBestProvider(criteria, false);
			Location location = service.getLastKnownLocation(provider);

			lat = location.getLatitude();
			lon = location.getLongitude();

			if (postal1.equals("") == true) {

				Geocoder gcd = new Geocoder(getBaseContext(),
						Locale.getDefault());
				List<Address> addresses;

				try {
					addresses = gcd.getFromLocation(lat, lon, 1);
					if (addresses.size() > 0) {

						LatLng Position_mark = new LatLng(lat, lon);
						googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
								Position_mark, 15));
						googleMap.animateCamera(CameraUpdateFactory.zoomTo(11),
								2000, null);

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			else {

				int postalcode = Integer.parseInt(postal1);
				String city = null;

				if (postalcode >= 1000 && postalcode <= 2999)
					city = "Nicosia";
				else if (postalcode >= 3000 && postalcode <= 4999)
					city = "Limassol";
				else if (postalcode >= 5000 && postalcode <= 5999)
					city = "Ammochostos";
				else if (postalcode >= 6000 && postalcode <= 7999)
					city = "Larnaka";
				else if (postalcode >= 8000 && postalcode <= 8999)
					city = "Paphos";
				else if (postalcode >= 9000 && postalcode <= 9999)
					city = "Girne";

				Geocoder gcd = new Geocoder(getBaseContext());
				List<Address> addresses;
				try {
					addresses = gcd.getFromLocationName(city, 1);
					if (addresses.size() > 0) {

						double lad = addresses.get(0).getLatitude();
						double longcent = addresses.get(0).getLongitude();

						LatLng Position_mark = new LatLng(lad, longcent);
						googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
								Position_mark, 15));
						googleMap.animateCamera(CameraUpdateFactory.zoomTo(11),
								2000, null);

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} else {

			Toast.makeText(getApplicationContext(), "No internet connection",
					Toast.LENGTH_SHORT);
		}

	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		
	}
}
