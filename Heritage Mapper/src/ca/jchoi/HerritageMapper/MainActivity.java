package ca.jchoi.HerritageMapper;


import java.util.ArrayList;
import java.util.List;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.content.Intent;
import android.os.Bundle;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
	 
	public class MainActivity extends android.support.v4.app.FragmentActivity {

    private GoogleMap myMap;
    private List<ParsedPointOfInterest> pois;
 
    @Override
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);
        pois = HeritageMapper.getInstance().getMasterList(); 
        
       
        
       
        setContentView(R.layout.activity_main);
        setUpMapIfNeeded();
    }
    
    private void setUpMapIfNeeded() {
        if (myMap == null) {
            myMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            if (myMap != null) {
                setUpMap();
            }
        }
    }
    
    private void setUpMap() {
    
       for(ParsedPointOfInterest p: pois) {
    	   MarkerOptions new_marker = new MarkerOptions();
    	   new_marker.position(new LatLng(p.getLatitude(), p.getLongitude()));
    	   new_marker.title(p.getName());
    	   new_marker.snippet(p.getDesignation());
    	   
    	   myMap.addMarker(new_marker);
    	
       }

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
