package core.strings.regex.replace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class ReplaceCharAtBeginningOfEachLineInFile {


	public static void main(String[] args) throws Exception {
	
		String line;

		Pattern p=Pattern.compile("^<");
		
		BufferedReader buffReader = new BufferedReader(new FileReader(
				"C:/Users/subramav/Documents/inventory/patches/inv.patch"));
		
		while ((line = buffReader.readLine()) != null) {
			System.out.println(p.matcher(line).replaceAll(""));
			
		}
		
		buffReader.close();

	}

}
