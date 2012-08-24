import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Timer;
import com.yammer.metrics.core.TimerContext;


public class FileReader {
	public FileReader(){
	}
	
	private final Timer derptastic = Metrics.newTimer(FileReader.class, "derptastic", TimeUnit.MILLISECONDS, TimeUnit.SECONDS);

	public int countRowsInFile(String filename) {
	    final TimerContext context = derptastic.time();
	    int rowCount = 0;
	    try {
	    	FileInputStream fstream = new FileInputStream(filename);
	    	  DataInputStream in = new DataInputStream(fstream);
	    	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    	  
	    	  while (( br.readLine()) != null)   {
	    		  rowCount++;
	    	  }
	    	  
	    	  in.close();
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        context.stop();
	    }
	    
	    return rowCount;
	}
}
