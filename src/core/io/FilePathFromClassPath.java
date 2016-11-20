package core.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;



public class FilePathFromClassPath {

	public static void main(String[] args) throws Exception {

	    //under "resources" source folder
	    String configFileName = "imageClient.config";
	    
		ClassPathResource resource = new ClassPathResource(configFileName);
    	
		System.out.println(resource.getFile().getAbsolutePath());

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
