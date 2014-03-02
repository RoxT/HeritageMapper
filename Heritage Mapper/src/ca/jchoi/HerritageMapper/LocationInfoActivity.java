package ca.jchoi.HerritageMapper;

import java.io.IOException;
import java.util.List;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ca.jchoi.HerritageMapper.R;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

@SuppressLint("NewApi")

public class LocationInfoActivity extends
android.support.v4.app.FragmentActivity {

	public static final String EXTRA_MESSAGE = "ca.jchoi.HerritageMapper.MESSAGE";
	private List<ParsedPointOfInterest> pois; 
	private List<ParsedPointOfInterest> visitedPois;
	private List<ParsedPointOfInterest> wishPois;
	private GoogleMap myMap;

	// Create views
	TextView tvName;
	TextView tvStreet;
	TextView tvTown;
	TextView tvProv;
	TextView tvPlaque;
	TextView tvDesignation;

	// This item
	ParsedPointOfInterest poi;

	// To know for the check boxes
	CheckBox poiVisited;
	CheckBox poiWish;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set Layout
		setContentView(R.layout.activity_location_info);

		// Get info from previous activity
		Intent intent = getIntent();
		int idNum = intent.getIntExtra(SearchActivity.EXTRA_MESSAGE, 1);

		// Get Lists
		pois = HeritageMapper.getInstance().getMasterList();
		visitedPois = HeritageMapper.getInstance().getVisitedList();
		wishPois = HeritageMapper.getInstance().getWishList();

		poiVisited = (CheckBox) findViewById(R.id.cbVisted);
		poiWish = (CheckBox) findViewById(R.id.cbWish);

		// Return the specific poi
		for (ParsedPointOfInterest poii : pois) {
			if (poii.getSiteID() == idNum)
				poi = poii;
		}

		// Set list booleans
		for (ParsedPointOfInterest vpoi : visitedPois) {
			if (poi.getSiteID() == vpoi.getSiteID())
				poiVisited.setChecked(true);
		}
		for (ParsedPointOfInterest wpoi : wishPois) {
			if (poi.getSiteID() == wpoi.getSiteID())
				poiWish.setChecked(true);
		}

		// Update all text views
		TextView tvName = (TextView) findViewById(R.id.tvName);
		tvName.setText("Name: " + poi.getName());

		TextView tvStreet = (TextView) findViewById(R.id.tvStreet);
		tvStreet.setText("");
		if (!poi.getStreet().equals(poi.getName()) && !poi.getStreet().equals("<Null>"))
			tvStreet.setText("Street: " + poi.getStreet());

		TextView tvTown = (TextView) findViewById(R.id.tvTown);
		tvTown.setText("Town: " + poi.getTown());

		TextView tvProv = (TextView) findViewById(R.id.tvProv);
		tvProv.setText("Province: " + poi.getProvince());

		TextView tvDesignation = (TextView) findViewById(R.id.tvDes);
		tvDesignation.setText("Reason for Designation: " + poi.getDesignation());
		
		TextView tvPlaque = (TextView) findViewById(R.id.tvPlaque);
		tvPlaque.setText("");
		if (!poi.getPlaqueLocation().equals("<Null>"))
				tvPlaque.setText("Plaque location: " + poi.getPlaqueLocation());
		
		myMap = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map)).getMap();

		myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(poi.getLatitude(), poi.getLongitude()), 5));
		myMap.addMarker(new MarkerOptions().position(new LatLng(poi.getLatitude(), poi.getLongitude()))).setIcon(BitmapDescriptorFactory.fromResource(R.drawable.red_marker));
	}


	public void clickVisited(View view) {
		if (poiVisited.isChecked()) {
			visitedPois.add(poi);
		} else {
			visitedPois.remove(poi);
		}
	}

	public void clickWish(View view) {
		if (poiWish.isChecked()) {
			wishPois.add(poi);
		} else {
			wishPois.remove(poi);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.location_info, menu);
		return true;
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	@SuppressLint("NewApi")
	private void setupActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	protected void onPause() {
		super.onPause();
		try {
			HeritageMapper.getInstance().saveCSVFile("wishlist.csv", wishPois);
			HeritageMapper.getInstance().saveCSVFile("visitedlist.csv", visitedPois);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	protected void onStop() {
		super.onPause();
		try {
			HeritageMapper.getInstance().saveCSVFile("wishlist.csv", wishPois);
			HeritageMapper.getInstance().saveCSVFile("visitedlist.csv", visitedPois);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		wishPois = HeritageMapper.getInstance().loadCSVFile("wishlist.csv");
		visitedPois = HeritageMapper.getInstance().loadCSVFile("visitedlist.csv");
		visitedPois = HeritageMapper.getInstance().getVisitedList();
		wishPois = HeritageMapper.getInstance().getWishList();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.action_search:
			openSearch();
			return true;
		case R.id.action_wishlist:
			openWishlist();
			return true;
		case R.id.action_visited_list:
			openVisitedlist();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void openVisitedlist() {
		Intent i = new Intent(this, VisitedListActivity.class);
		startActivity(i);
	}

	private void openWishlist() {
		Intent i = new Intent(this, WishlistActivity.class);
		startActivity(i);
	}

	private void openSearch() {
		Intent i = new Intent(this, MainActivity.class);
		startActivity(i);
	}
}
