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
			boolean fileExists = checkFileExists("masterlist.csv"); 

			if (!fileExists) { 
				// If master list doesn't exist then: 
				masterList = loadTemplateFile("NHSC_LHNC_TB.csv");
				
				Collections.sort(getMasterList(), new NameComparator());  // and this line for search functionality

				// Write master list of point of interest objects out as a CSV file
				saveCSVFile("masterlist.csv", masterList);

			} else { 
				// Read the master list CSV file back in and print it out 
				masterList = loadCSVFile("masterlist.csv");
			}
		} catch (IOException e) {//input & output reading exception
			e.printStackTrace();
		}
	}
	
	public boolean checkFileExists(String listType) {
		boolean fileExists = false; // assume that file doesn't exists so try to open file
		try {
			FileInputStream temp = openFileInput(listType); // open file correctly means that we have file
			fileExists = true; // so set it to true
			temp.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileExists;
	}
	
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
