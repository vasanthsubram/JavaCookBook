package core.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

public class ReadPropertiesFile {

	public static void main(String[] args) throws Exception {

	    //under "resources" source folder
	    String configFileName = "imageClient.config";
	    
		ClassPathResource resource = new ClassPathResource(configFileName);
    			
		BufferedReader reader = null;
	    InputStream inputStream =  resource.getInputStream();

    	reader = new BufferedReader(new InputStreamReader(inputStream));

    	Properties props = new Properties();
    	props.load(reader);
    	
    	System.out.println(props);
    	reader.close();
    	inputStream.close();
	}
}
