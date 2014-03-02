package ca.jchoi.HerritageMapper;

import ca.jchoi.HerritageMapper.R;
import ca.jchoi.HerritageMapper.R.id;
import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class DisplayMessageActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    // Get the message from the intent
	    Intent intent = getIntent();
	    String message = intent.getStringExtra(SearchActivity.EXTRA_MESSAGE);

	    // Create the text view
	    TextView textView = new TextView(this);
	    textView.setTextSize(40);
	    textView.setText(message);

	    // Set the text view as the activity layout
	    setContentView(textView);
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

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
