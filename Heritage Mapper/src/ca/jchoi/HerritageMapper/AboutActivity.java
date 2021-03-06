package ca.jchoi.HerritageMapper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;

public class AboutActivity extends
android.support.v4.app.FragmentActivity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
		return true;
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

	private void openSearch() {
		Intent i = new Intent(this, SearchActivity.class);
		startActivity(i);
	}
	
	private void openWishlist() {
		Intent i = new Intent(this, WishlistActivity.class);
		startActivity(i);
	}
	

}
