package logging.log4j.xmlConfig;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jXmlExample {

    public static void main(String[] args) {
        DOMConfigurator.configure("src/logging/log4j/xmlConfig/log4j.xml");
        Logger logger = Logger.getLogger(Log4jXmlExample.class);
        for (int i = 0; i < 10; i++) {
            logger.info("Warning");
        }
    }
}
