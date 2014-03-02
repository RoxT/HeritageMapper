package ca.jchoi.HerritageMapper;

import java.util.Comparator;

public class NameComparator implements Comparator<ParsedPointOfInterest> {
	//@Override
	public int compare(ParsedPointOfInterest poi1, ParsedPointOfInterest poi2) {
		return poi1.getName().compareTo(poi2.getName());
	}
}
