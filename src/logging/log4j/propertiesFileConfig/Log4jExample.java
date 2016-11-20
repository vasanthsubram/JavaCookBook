package logging.log4j.propertiesFileConfig;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jExample {

    public static void main(String[] args) {
        PropertyConfigurator.configure("src/logging/log4j/propertiesFileConfig/log4j.properties");
        Logger logger = Logger.getLogger(Log4jExample.class);
        for (int i = 0; i < 10; i++) {
            logger.info("Warning");
        }
    }
}
