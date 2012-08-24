import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.yammer.metrics.reporting.ConsoleReporter;


public class FileReaderTest {

	@Test
	public void test() throws InterruptedException {
		ConsoleReporter.enable(1, TimeUnit.SECONDS);
		FileReader r = new FileReader();
		
		for(int i = 0; i < 1000; i++){ 
		r.countRowsInFile("/Users/eaplin/Documents/ThoughtWorks/Projects/the_amazing_file_reader/myfile");
		}
		Thread.sleep(1000);
	}

}
