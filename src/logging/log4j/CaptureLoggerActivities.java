package logging.log4j;

import java.io.ByteArrayOutputStream;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import static org.junit.Assert.*;

public class CaptureLoggerActivities {

	public static void main(String[] args) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		WriterAppender writerAppender = new WriterAppender(new PatternLayout(),
				baos);
		writerAppender.setName("TestLogger");
		Logger logger = Logger.getLogger(CaptureLoggerActivities.class.getSimpleName());
//		logger.addAppender(writerAppender);

		try {
			logger.error("Capture this error");

			assertTrue(baos.toString().contains("Capture this error"));
			System.out.println(baos.toString());
		} finally {

//			Appender appender = logger.getAppender("TestLogger");
//			if (appender != null) {
//				logger.removeAppender(appender);
//			}

		}
	}
}
