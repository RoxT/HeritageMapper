package ca.jchoi.HerritageMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class SearchActivity extends android.support.v4.app.FragmentActivity {

	private ListView listView;
	
	private List<ParsedPointOfInterest> pois;
	private List<String> myPois = new ArrayList<String>();
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_search);
	    listView = (ListView) findViewById(R.id.list);
	    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myPois);
	    listView.setAdapter(adapter);
	    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	    	@Override
	    	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	    		String name = (String) parent.getItemAtPosition(position);
	    		for (ParsedPointOfInterest poi : pois) {
	    			if (poi.getName().equals(name)) {
	    				openLocationInfoActivity(poi);
	    			}
	    		}
	    	}
		});
		pois = HeritageMapper.getInstance().getMasterList();
	}
	
	private void openLocationInfoActivity(ParsedPointOfInterest poi) {
		Intent intent = new Intent(this, LocationInfoActivity.class);
		int idNum = poi.getSiteID();
		intent.putExtra(EXTRA_MESSAGE, idNum);
		startActivity(intent);
	}
	
    /** Called when the user clicks the Send button */
	public void sendMessage(View view) {
    	myPois.clear();
    	// Get entered text
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	for (ParsedPointOfInterest poi : pois) {
    		if (poi.getProvince().toLowerCase(Locale.getDefault()).contains(message.toLowerCase()) ||
    				poi.getName().toLowerCase(Locale.getDefault()).contains(message.toLowerCase()) ||
    				poi.getDesignation().toLowerCase(Locale.getDefault()).contains(message.toLowerCase()) ||
    				poi.getStreet().toLowerCase(Locale.getDefault()).contains(message.toLowerCase()) ||
    				poi.getNameFrench().toLowerCase(Locale.getDefault()).contains(message.toLowerCase())) {
    			myPois.add(poi.getName());
    		}
    	}
    	((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
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
		case R.id.action_about:
			openAbout();
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
	
	private void openAbout() {
		Intent i = new Intent(this, AboutActivity.class);
		startActivity(i);
	}

	private void openSearch() {
		//TODO What does this do?
	}
}
