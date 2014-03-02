package ca.jchoi.HerritageMapper;

import java.util.List;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.InfoWindowAdapter;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {

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
		placePois(getLocation(this), 3);
	}

	private void placePois(LatLng location, int zoom) {

		myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, zoom));
		
		for (ParsedPointOfInterest p : pois) {
			MarkerOptions new_marker = new MarkerOptions();
			if (p.getLatitude() != 0 && p.getLongitude() != 0) {
				new_marker.position(new LatLng(p.getLatitude(), p
						.getLongitude()));
			} else
				continue;

			new_marker.title(p.getName() + "\n" + p.getNameFrench());
			new_marker.snippet(p.getDesignation() + "\n" + p.getDesignationFrench()).icon(BitmapDescriptorFactory.fromResource(R.drawable.red_marker));

			myMap.addMarker(new_marker);
		}

		// InfoWindowAdapter code adapted from
		// http://wptrafficanalyzer.in/blog/
		// customizing-infowindow-contents-in-google-map-android-api-v2-using-infowindowadapter/
		
		myMap.setInfoWindowAdapter(new InfoWindowAdapter() {

			@Override
			public View getInfoWindow(Marker marker) {
				return null;
			}

			@Override
			public View getInfoContents(Marker arg0) {

				// Getting view from the layout file info_window_layout
				View v = getLayoutInflater().inflate(
						R.layout.info_window_layout, null);

				String title = arg0.getTitle();
				
				
				
				String description = arg0.getSnippet();

				TextView poiTitle = (TextView) v.findViewById(R.id.poiTitle);
				TextView poiDescription = (TextView) v
						.findViewById(R.id.poiDescription);

				poiTitle.setText(title);
				poiDescription.setText(description);

				return v;

			}
		});

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

	public LatLng getLocation(Context ctx) {
		LocationManager lm = (LocationManager) ctx
				.getSystemService(Context.LOCATION_SERVICE);
		List<String> providers = lm.getProviders(true);

		/*
		 * Loop over the array backwards, and if you get an accurate location,
		 * then break out the loop
		 */
		Location l = null;

		for (int i = providers.size() - 1; i >= 0; i--) {
			l = lm.getLastKnownLocation(providers.get(i));
			if (l != null)
				break;
		}
		return new LatLng(l.getLatitude(), l.getLongitude());
	}

}