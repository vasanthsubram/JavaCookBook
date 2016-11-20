package core.io.nio;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public final class CopyFile_bestWay {
	  
	  public static void main(String... aArgs) throws IOException {
	    Path FROM = Paths.get("resources/imageClient.config");
	    Path TO = Paths.get("output/copy.txt");
	    //overwrite existing file, if exists
	    CopyOption[] options = new CopyOption[]{
	      StandardCopyOption.REPLACE_EXISTING,
	      StandardCopyOption.COPY_ATTRIBUTES
	    }; 
	    Files.copy(FROM, TO, options);
	  }
	} 

