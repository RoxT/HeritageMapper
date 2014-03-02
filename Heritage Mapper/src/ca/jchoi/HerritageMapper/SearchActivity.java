package ca.jchoi.HerritageMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
	
	private List<ParsedPointOfInterest> pois;
	private List<ParsedPointOfInterest> myPois;
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_search);
		pois = HeritageMapper.getInstance().getMasterList();
	}
	
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
    	myPois = new ArrayList<ParsedPointOfInterest>();
    	// Get entered text
    	EditText editText = (EditText) findViewById(R.id.edit_message);

    	String message = editText.getText().toString();
    	
    	// Get results
    	for (ParsedPointOfInterest poi : pois) {
    		if (poi.getProvince().toLowerCase(Locale.getDefault()).contains(message.toLowerCase()) ||
    				poi.getName().toLowerCase(Locale.getDefault()).contains(message.toLowerCase()) ||
    				poi.getDesignation().toLowerCase(Locale.getDefault()).contains(message.toLowerCase()) ||
    				poi.getStreet().toLowerCase(Locale.getDefault()).contains(message.toLowerCase())) {
    			myPois.add(poi);
    		}
    	}
    	int resultsLength = myPois.size();
    	
    	
    	// Refresh view
    	setContentView(R.layout.activity_search);
	    
    	// Create the text views, up to 6
    	if (resultsLength > 0) {
    		TextView textView = (TextView) findViewById(R.id.search_result_1);
    	    textView.setText(myPois.get(0).getName());
    	} else {
    		TextView textView = (TextView) findViewById(R.id.search_result_1);
    	    textView.setText("No results found");
    	}
    	
    	if (resultsLength > 1) {
    		TextView textView = (TextView) findViewById(R.id.search_result_2);
    	    textView.setText(myPois.get(1).getName());
    	} else {
    		TextView textView = (TextView) findViewById(R.id.search_result_2);
    	    textView.setText("");
    	}
    	
    	if (resultsLength > 2) {
    		TextView textView = (TextView) findViewById(R.id.search_result_3);
    	    textView.setText(myPois.get(2).getName());
    	} else {
    		TextView textView = (TextView) findViewById(R.id.search_result_3);
    	    textView.setText("");
    	}
    	
    	if (resultsLength > 3) {
    		TextView textView = (TextView) findViewById(R.id.search_result_4);
    	    textView.setText(myPois.get(3).getName());
    	} else {
    		TextView textView = (TextView) findViewById(R.id.search_result_4);
    	    textView.setText("");
    	}
    	
    	if (resultsLength > 4) {
    		TextView textView = (TextView) findViewById(R.id.search_result_5);
    	    textView.setText(myPois.get(4).getName());
    	} else {
    		TextView textView = (TextView) findViewById(R.id.search_result_5);
    	    textView.setText("");
    	}
    	
    	if (resultsLength > 5) {
    		TextView textView = (TextView) findViewById(R.id.search_result_6);
    	    textView.setText(myPois.get(5).getName());
    	} else {
    		TextView textView = (TextView) findViewById(R.id.search_result_6);
    	    textView.setText("");
    	}

    }
    
    public void onResultClick1(View view) {
    	Intent intent = new Intent(this, LocationInfoActivity.class);
    	int idNum = myPois.get(0).getSiteID();
    	intent.putExtra(EXTRA_MESSAGE, idNum);
        startActivity(intent);
    }
    
    public void onResultClick2(View view) {
    	Intent intent = new Intent(this, LocationInfoActivity.class);
    	int idNum = myPois.get(1).getSiteID();
    	intent.putExtra(EXTRA_MESSAGE, idNum);
        startActivity(intent);
    }
    
    public void onResultClick3(View view) {
    	Intent intent = new Intent(this, LocationInfoActivity.class);
    	int idNum = myPois.get(2).getSiteID();
    	intent.putExtra(EXTRA_MESSAGE, idNum);
        startActivity(intent);
    }
    
    public void onResultClick4(View view) {
    	Intent intent = new Intent(this, LocationInfoActivity.class);
    	int idNum = myPois.get(3).getSiteID();
    	intent.putExtra(EXTRA_MESSAGE, idNum);
        startActivity(intent);
    }
    
    public void onResultClick5(View view) {
    	Intent intent = new Intent(this, LocationInfoActivity.class);
    	int idNum = myPois.get(4).getSiteID();
    	intent.putExtra(EXTRA_MESSAGE, idNum);
        startActivity(intent);
    }
    
    public void onResultClick6(View view) {
    	Intent intent = new Intent(this, LocationInfoActivity.class);
    	int idNum = myPois.get(5).getSiteID();
    	intent.putExtra(EXTRA_MESSAGE, idNum);
        startActivity(intent);
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
