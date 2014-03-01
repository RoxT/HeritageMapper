package ca.jchoi.HerritageMapper;

public class PointOfInterest {

	private static final int SITE_ID = 0;
	private static final int NAME = 1;
	private static final int NAME_FRENCH = 2;
	private static final int STREET = 3;
	private static final int PLAQUE_LOCATION = 4;
	private static final int TOWN = 5;
	private static final int PROV = 6;
	private static final int REASON_FOR_DESIGNATION = 7;
	private static final int REASON_FOR_DESIGNATION_FRENCH = 8;
	private static final int LATITUDE= 9;
	private static final int LONGITUDE = 10;
	private static final int NUM_COLUMNS = 11;
	
	int SiteID;
	String name;
	String nameFrench;
	String street;
	String plaqueLocation;
	String province;
	String town;
	
	String designation;
	String designationFrench;
	float latitude;
	float longitude;
	boolean wantToVisit;
	boolean Visited;
	
	public static PointOfInterest create(String[] data) {
		PointOfInterest poi = new PointOfInterest();
		poi.setSiteID(getIntegerValue(data[SITE_ID]));
		poi.setName(getStringValue(data[NAME]));
		poi.setNameFrench(getStringValue(data[NAME_FRENCH]));
		poi.setStreet(getStringValue(data[STREET]));
		poi.setPlaqueLocation(getStringValue(data[PLAQUE_LOCATION]));
		poi.setTown(getStringValue(data[TOWN]));
		poi.setProvince(getStringValue(data[PROV]));
		poi.setDesignation(getStringValue(data[REASON_FOR_DESIGNATION]));
		poi.setDesignationFrench(getStringValue(data[REASON_FOR_DESIGNATION_FRENCH]));
		poi.setLatitude(getFloatValue(data[LATITUDE]));
		poi.setLongitude(getFloatValue(data[LONGITUDE]));
		return poi;
	}
	
	public PointOfInterest(){
		
	}
	
	private static String getStringValue(String data) {
		if (data == null || data.length() == 0) {
			return "";
		}
		return data;
	}
	
	private static float getFloatValue(String data) {
		try {
			float value = Float.valueOf(data);
			return value;
		} catch (NumberFormatException e) {
			return 0.0f;
		}
	}
	
	private static int getIntegerValue(String data) {
		try {
			int value = Integer.valueOf(data);
			return value;
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	public String[] getColumns() {
		String[] columns = new String[NUM_COLUMNS];
		columns[SITE_ID] = String.valueOf(getSiteID());
		columns[NAME] = getName();
		columns[NAME_FRENCH] = getNameFrench();
		columns[STREET] = getStreet();
		columns[PLAQUE_LOCATION] = getPlaqueLocation();
		columns[TOWN] = getTown();
		columns[PROV] = getProvince();
		columns[REASON_FOR_DESIGNATION] = getDesignation();
		columns[REASON_FOR_DESIGNATION_FRENCH] = getDesignationFrench();
		columns[LATITUDE] = String.valueOf(getLatitude());
		columns[LONGITUDE] = String.valueOf(getLongitude());
		return columns;
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

	public float getLatitude() {
		return latitude;
	}
	
	public float getLongitude() {
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
