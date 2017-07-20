import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvWriter;

public class CsvWriterAppendExample {
	
	public static void main(String[] args) {
		
		String outputFile = "users.csv";
		
		// before we open the file check to see if it already exists
		boolean alreadyExists = new File(outputFile).exists();
			
		try {
			// use FileWriter constructor that specifies open for appending
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
			
			// if the file didn't already exist then we need to write out the header line
			if (!alreadyExists)
			{
				csvOutput.write("lat1");
				csvOutput.write("lon1");
				csvOutput.write("lat2");
				csvOutput.write("lon2");
				csvOutput.endRecord();
			}
			// else assume that the file already has the correct header line
			float start_lat = 40;
			float end_lat = 50;
			
			double start_lon = -80;
			double end_lon = -70;
			double increment_value = 0.2;
			// write out a few records
			
			for ( double index_lat = start_lat; index_lat < end_lat; index_lat += increment_value )
	          {
				for ( double index_lon = start_lon; index_lon < end_lon; index_lon += increment_value )
				{
				
				csvOutput.write(String.valueOf(index_lat));
				csvOutput.write(String.valueOf(index_lon));
				csvOutput.write(String.valueOf(index_lat + 0.2));
				csvOutput.write(String.valueOf(index_lon + 0.2));
				
				csvOutput.endRecord();
				}
	          }	
			
			
			
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}