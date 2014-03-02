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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SearchActivity extends android.support.v4.app.FragmentActivity {
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_search);
	}
	
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
 
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String results = editText.getText().toString();
    	setContentView(R.layout.activity_search);
	    // Create the text view
    	TextView textView = (TextView) findViewById(R.id.search_result_1);
	    textView.setText(results);
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
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

	private void openWishlist() {
        Intent i = new Intent(this, WishlistActivity.class);
        startActivity(i);
		
	}

	private void openSearch() {

		
	}
}
