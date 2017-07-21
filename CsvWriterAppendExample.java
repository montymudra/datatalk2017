import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.csvreader.CsvWriter;
import java.text.DecimalFormat;

public class CsvWriterAppendExample {
	
	public static void main(String[] args) {
		
		String outputFile = "state.csv";
		
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
				csvOutput.write("seq");
				csvOutput.endRecord();
			}
			// tx + ok
			/*double start_lat = 26;
			double end_lat = 37;
			
			double start_lon = -106.6;
			double end_lon = -93.7;
			double increment_value = 0.02;
			int num = 1;*/
			
			//az
			double start_lat = 31.3;
			double end_lat = 36.95;
			
			double start_lon = -114.7;
			double end_lon = -109;
			double increment_value = 0.02;
			int num = 355301;
			
			for ( double index_lat = start_lat; index_lat < end_lat; index_lat += increment_value )
	          {
				for ( double index_lon = start_lon; index_lon < end_lon; index_lon += increment_value )
				{
				
				csvOutput.write(new DecimalFormat("0.00").format(index_lat));
				csvOutput.write(new DecimalFormat("0.00").format(index_lon));
				csvOutput.write(new DecimalFormat("0.00").format(index_lat + increment_value));
				csvOutput.write(new DecimalFormat("0.00").format(index_lon + increment_value));
				csvOutput.write(String.valueOf(num));
				csvOutput.endRecord();
				num++;
				}
	          }	
			
			
			
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}