package logging;

import org.apache.log4j.Logger;

public class LoggingTest {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger(LoggingTest.class);
		for (int i = 0; i < 10; i++) {
			logger.info("Warning");
		}
	}
}
