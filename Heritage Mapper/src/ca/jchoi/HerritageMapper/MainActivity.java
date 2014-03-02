package ca.jchoi.HerritageMapper;


import ca.jchoi.HerritageMapper.R;
import ca.jchoi.HerritageMapper.R.id;
import ca.jchoi.HerritageMapper.R.layout;
import ca.jchoi.HerritageMapper.R.menu;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;


public class MainActivity extends Activity {


	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

  //  public void startMapTestActivity(View view) {
  //  	Intent intent = new Intent(this, MapTest.class);
  //  	startActivity(intent);
  //  }
    

}
