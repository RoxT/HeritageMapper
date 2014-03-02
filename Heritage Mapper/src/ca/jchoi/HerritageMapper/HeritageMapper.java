package ca.jchoi.HerritageMapper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import android.app.Application;
import android.util.Log;
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class HeritageMapper extends Application {
	
	private static final String TAG = "HeritageMapper";
	private List<PointOfInterest> masterList = new ArrayList<PointOfInterest>();

	// Add method to check if master list is already created
	
	@Override
	public void onCreate() {
		try { // Reading CSV template from the assets directory and creating a master list of point of interest objects
			String assetPath = "NHSC_LHNC_TB.csv";
			InputStream assetStream = getAssets().open(assetPath);
			InputStreamReader reader = new InputStreamReader(assetStream);
			CSVReader csvReader = new CSVReader(reader);
			String columns[];
			while ((columns = csvReader.readNext()) != null) {
//				PointOfInterest poi = PointOfInterest.create(columns);
	//			masterList.add(poi);
			}
			// Writing master list of point of interest objects out as a CSV file
			FileOutputStream output = openFileOutput("masterlist.csv", MODE_APPEND); // may have to revisit mode_append b/c there should be a MODE_REPLACE so Append will have duplicate files
			OutputStreamWriter writer = new OutputStreamWriter(output);
			CSVWriter csvWriter = new CSVWriter(writer);
			for (PointOfInterest poi : masterList) {
//				columns = poi.getColumns();
				csvWriter.writeNext(columns);
			}
			// Read the master list CSV file back in and print it out THIS IS FOR TESTING ONLY!!!
			FileInputStream input = openFileInput("masterlist.csv");
			reader = new InputStreamReader(input);
			csvReader = new CSVReader(reader);
			while ((columns = csvReader.readNext()) != null) {
				for (String value : columns) {
					Log.i(TAG, value);
				}
			}
		} catch (IOException e) {//input & output reading exception
			e.printStackTrace();
		}
		//need to add an accessor in this application class to get the master list so that all the activities can use the master list
	}
}
