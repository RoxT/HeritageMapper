package ca.jchoi.HerritageMapper;

import ca.jchoi.HerritageMapper.R;
import ca.jchoi.HerritageMapper.R.id;
import ca.jchoi.HerritageMapper.R.layout;
import ca.jchoi.HerritageMapper.R.menu;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

@SuppressLint("NewApi")
public class LocationInfoActivity extends android.support.v4.app.FragmentActivity {
	
	TextView tvName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_info);
		
		TextView tvName = (TextView) findViewById(R.id.tvName);
		tvName.setText("Name goes Here");
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
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:

			finish();
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
