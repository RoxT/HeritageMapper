package ca.jchoi.HerritageMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Application;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import ca.jchoi.HerritageMapper.NameComparator;
import ca.jchoi.HerritageMapper.ParsedPointOfInterest;

public class HeritageMapper extends Application {
	
	private static HeritageMapper sInstance;
	
	private List<ParsedPointOfInterest> masterList = new ArrayList<ParsedPointOfInterest>();; 
	private List<ParsedPointOfInterest> wishList = new ArrayList<ParsedPointOfInterest>();
	private List<ParsedPointOfInterest> visitedList = new ArrayList<ParsedPointOfInterest>();
	
	public static HeritageMapper getInstance() {
		return sInstance;
	}
	
	public List<ParsedPointOfInterest> getMasterList() {
		return masterList;
	}
	
	public List<ParsedPointOfInterest> getWishList() {
		return wishList;
	}
	
	public List<ParsedPointOfInterest> getVisitedList() {
		return visitedList;
	}
	
	
	@Override
	public void onCreate() {	
		sInstance = this;
		try {
			// Check if master list is already created
			boolean masterExists = checkFileExists("masterlist.csv"); 
			if (!masterExists) { 
				// If master list does not exist then parse and load original template 
				masterList = loadTemplateFile("NHSC_LHNC_TB.csv");
				// This line is for faster search functionality
				Collections.sort(getMasterList(), new NameComparator());  
				// Write master list of point of interest objects out as a CSV file
				saveCSVFile("masterlist.csv", masterList);
			} else { 
				// If master list does exist then read the master list CSV file back in and print it out 
				masterList = loadCSVFile("masterlist.csv");
			}
			// Check if wish list is already created
			boolean wishExists = checkFileExists("wishlist.csv"); 
			if (!wishExists) { 
			} else { 
				// If wish list does exist then read the wish list CSV file back in and print it out 
				wishList = loadCSVFile("wishlist.csv");
				// This line is for faster search functionality
				Collections.sort(getWishList(), new NameComparator());
			}
			// Check if wish list is already created
			boolean visitedExists = checkFileExists("visitedlist.csv"); 
			if (!visitedExists) { 
			} else { 
				// If wish list does exist then read the wish list CSV file back in and print it out 
				visitedList = loadCSVFile("visitedlist.csv");
				// This line is for faster search functionality
				Collections.sort(getVisitedList(), new NameComparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// HELPER FUNCTIONS FOR onCreate()
	
	// Check if master list is already created
	public boolean checkFileExists(String listType) {
		boolean fileExists = false; 
		try {
			FileInputStream temp = openFileInput(listType);
			fileExists = true;
			temp.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileExists;
	}
	
	// If master list does not exist then parse and load original template
	public List<ParsedPointOfInterest> loadTemplateFile(String fileName) {
		List<ParsedPointOfInterest> myList = new ArrayList<ParsedPointOfInterest>();
		InputStream assetStream;
		try {
			assetStream = getAssets().open(fileName);
			InputStreamReader reader = new InputStreamReader(assetStream);
			CSVReader csvReader = new CSVReader(reader);
			String columns[];
			while ((columns = csvReader.readNext()) != null) {
				ParsedPointOfInterest poi = ParsedPointOfInterest.create(columns);
				myList.add(poi); // LOOK INTO THIS!!!!!!!!
			}
			csvReader.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myList;
	}
	
	// Write master list of point of interest objects out as a CSV file
	public void saveCSVFile(String fileName, List<ParsedPointOfInterest> myList) throws IOException {
		FileOutputStream output = openFileOutput(fileName, MODE_PRIVATE);
		OutputStreamWriter writer = new OutputStreamWriter(output);
		CSVWriter csvWriter = new CSVWriter(writer);
		String columns[];
		for (ParsedPointOfInterest poi : myList) {
			columns = poi.getColumns();
			csvWriter.writeNext(columns);
		}
		writer.close();
		csvWriter.flush();
		csvWriter.close();
	}
	
	// If master list does exist then read the master list CSV file back in and print it out
	public List<ParsedPointOfInterest> loadCSVFile(String fileName) { 
		List<ParsedPointOfInterest> myList = new ArrayList<ParsedPointOfInterest>();
		FileInputStream input;
		try {
			input = openFileInput(fileName);
			InputStreamReader reader = new InputStreamReader(input);
			CSVReader csvReader = new CSVReader(reader);
			String columns[];
			while ((columns = csvReader.readNext()) != null) {
				ParsedPointOfInterest poi = ParsedPointOfInterest.create(columns);
				myList.add(poi);
			}
			csvReader.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myList;
	} 
	
	

}
