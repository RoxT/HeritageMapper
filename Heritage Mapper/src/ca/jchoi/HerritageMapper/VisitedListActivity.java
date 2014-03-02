package ca.jchoi.HerritageMapper;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class VisitedListActivity extends android.support.v4.app.FragmentActivity {

	private ListView listView;
	
	private List<ParsedPointOfInterest> pois;
	private List<String> myPois = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_visited_list);
		listView = (ListView) findViewById(R.id.list);
	    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myPois);
	    listView.setAdapter(adapter);
	    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	    	@Override
	    	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//	    		String name = (String) parent.getItemAtPosition(position);
//	    		for (ParsedPointOfInterest poi : pois) {
//	    			if (poi.getName().equals(name)) {
//	    				openLocationInfoActivity(poi);
//	    			}
//	    		}
	    	}
		});
	    pois = HeritageMapper.getInstance().getVisitedList();
	    for (ParsedPointOfInterest poi : pois) {
	    	myPois.add(poi.getName());
	    }
	    ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.visited_list, menu);
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
		}
		return super.onOptionsItemSelected(item);
	}

	private void openWishlist() {
        Intent i = new Intent(this, WishlistActivity.class);
        startActivity(i);
	}

	private void openSearch() {
		Intent i = new Intent(this, SearchActivity.class);
        startActivity(i);	
	}
}