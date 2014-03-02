package ca.jchoi.HerritageMapper;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public abstract class Activity {
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
                return onOptionsItemSelected(item);
        }
    }


	private void openVisitedlist() {
		// TODO Auto-generated method stub

	}


	private void openWishlist() {
		// TODO Auto-generated method stub
		
	}


	private void openSearch() {
		// TODO Auto-generated method stub
		
	}
}
