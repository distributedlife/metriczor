import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.yammer.metrics.reporting.ConsoleReporter;


public class FileReaderTest {

	@Test
	public void test() {
		ConsoleReporter.enable(1, TimeUnit.SECONDS);
		
		FileReader r = new FileReader();
		
		r.countRowsInFile("/Users/rboucher/projects/the_amazing_file_reader/many_rows");
	}

}
