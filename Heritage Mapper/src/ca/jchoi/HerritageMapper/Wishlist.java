package ca.jchoi.HerritageMapper;

import java.util.LinkedList;

public class Wishlist extends LinkedListLocation{

	LinkedList<PointOfInterest> poi;
	
	// list of places to go to
	
	public Wishlist(LinkedList<PointOfInterest> allPoi){
		this.poi = new LinkedList<PointOfInterest>();
		for (PointOfInterest index: allPoi){
			if (index.isVisited()){
				poi.add(index);
			}
		}
	}
	
	public void MakeList(){
		//makes list	
	}
	
	public void AddToList(){
		//add items to list
	}
	
	public void RemoveFromList(){
		//remove item from list
		// (item from poi).setVisited(false);
	}
	
	
}
