package ca.jchoi.HerritageMapper;

import java.util.ArrayList;
import java.util.List;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {

	private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;


	public static final String EXTRA_MESSAGE = "ca.jchoi.HerritageMapper";
	

	private GoogleMap myMap;
	private List<ParsedPointOfInterest> pois;
	


	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		pois = HeritageMapper.getInstance().getMasterList();

		setContentView(R.layout.activity_main);
		setUpMapIfNeeded();
	}

	private void setUpMapIfNeeded() {
		if (myMap == null) {
			myMap = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map)).getMap();
			if (myMap != null) {
				setUpMap();
			}
		}
	}

	private void setUpMap() {

		myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(62.7125, -109.1647), 3));

		
		

		for (ParsedPointOfInterest p : pois) {
			MarkerOptions new_marker = new MarkerOptions();
			if (p.getLatitude() != 0 && p.getLongitude() != 0) {
				new_marker.position(new LatLng(p.getLatitude(), p.getLongitude())); }
			else continue;
			
			new_marker.title(p.getName());
			new_marker.snippet(p.getDesignation());

			myMap.addMarker(new_marker);

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar items
		switch (item.getItemId()) {
		case R.id.action_search:
			openSearch();
			return true;
		case R.id.action_wishlist:
			openWishlist();
			return true;
		case R.id.action_visited_list:
			openVisitedlist();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void openVisitedlist() {
		Intent i = new Intent(MainActivity.this, VisitedListActivity.class);
		startActivity(i);
	}

	private void openWishlist() {
		Intent i = new Intent(MainActivity.this, WishlistActivity.class);
		startActivity(i);

	}

	private void openSearch() {
		Intent i = new Intent(this, SearchActivity.class);
		startActivity(i);
	}

	public LatLng getLocation(Context ctx) 
	{
	    LocationManager lm = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
	    List<String> providers = lm.getProviders(true);

	    /*
	     * Loop over the array backwards, and if you get an accurate location,
	     * then break out the loop
	     */
	    Location l = null;

	    for (int i = providers.size() - 1; i >= 0; i--) 
	    {
	        l = lm.getLastKnownLocation(providers.get(i));
	        if (l != null)
	            break;
	    }
	    return new LatLng(l.getLatitude(),l.getLongitude());
	}
	





}
