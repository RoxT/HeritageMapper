package ca.jchoi.HerritageMapper;

public class PointOfInterest {
	
	private int SiteID;
	private String name;
	private String nameFrench;
	private String street;
	private String plaqueLocation;
	private String province;
	private String town;
	
	private String designation;
	private String designationFrench;
	private double latitude;
	private double longitude;
	boolean wantToVisit;
	boolean Visited;
	
	public PointOfInterest(String name, String designation, double lat, 
			double longi, boolean wantToVisit) {
		this.name = name;
		this.designation = designation;
		this.latitude = lat;
		this.longitude = longi;
		this.wantToVisit = wantToVisit;
		
	}
	
	public String getPlaqueLocation() {
		return plaqueLocation;
	}
	
	public void setPlaqueLocation(String plaque) {
		this.plaqueLocation = plaque;
	}

	public int getSiteID() {
		return SiteID;
	}

	public void setSiteID(int siteID) {
		SiteID = siteID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameFrench() {
		return nameFrench;
	}

	public void setNameFrench(String nameFrench) {
		this.nameFrench = nameFrench;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDesignationFrench() {
		return designationFrench;
	}

	public void setDesignationFrench(String designationFrench) {
		this.designationFrench = designationFrench;
	}

	public String getCoordinates() {
		return String.valueOf(latitude) + ", " + String.valueOf(longitude);
	}

	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public boolean isWantToVisit() {
		return wantToVisit;
	}

	public void setWantToVisit(boolean wantToVisit) {
		this.wantToVisit = wantToVisit;
	}

	public boolean isVisited() {
		return Visited;
	}

	public void setVisited(boolean visited) {
		Visited = visited;
	}
	
}
