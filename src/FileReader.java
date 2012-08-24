import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Histogram;
import com.yammer.metrics.core.Meter;


public class FileReader {
	private int rowCount;
	private int derpDevitiation;
	final Meter linesPerSecond = Metrics.newMeter(FileReader.class, "linesPerSecond", "derp", TimeUnit.SECONDS);
	final Histogram resultCounts = Metrics.newHistogram(FileReader.class, "result-counts");

	
	public FileReader() {	
	}
	
	public int countRowsInFile(String filename) {
		rowCount = 0;
		derpDevitiation = 0;
		
		DateTime start = DateTime.now(); 
		DateTime now = start;
		
	    try {	    
			FileInputStream fstream = new FileInputStream(filename);
	    	DataInputStream in = new DataInputStream(fstream);
	    	BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    	
	    	while (br.readLine() != null)   {
	    		rowCount++;
	    		derpDevitiation++;
	    		linesPerSecond.mark();
	    		resultCounts.update(derpDevitiation);
	    		
	    		now = DateTime.now();
	    		if (now.getMillis() - start.getMillis() >= 1000) {
	    			System.out.println(Integer.toString(derpDevitiation));
	    			derpDevitiation = 0;
	    			start = now;
	    		}
	    	}

	    	in.close();	    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	    
	    return getRowCount();
	}
	
	public int getRowCount() {
		return rowCount;
	}
}
