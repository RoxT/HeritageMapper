package ca.jchoi.HerritageMapper;

public class PointOfInterest {

	int SiteID;
	String name;
	String nameFrench;
	String province;
	String town;
	String street;
	String designation;
	String designationFrench;
	String coordinates;
	boolean wantToVisit;
	boolean Visited;
	
	public PointOfInterest(){
		
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
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
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
