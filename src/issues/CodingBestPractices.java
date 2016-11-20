package issues;

import java.io.File;
import java.io.FileWriter;

public class CodingBestPractices {

	public static String newLine = System.getProperty("line.separator");
	
	public static void main(String[] args) throws Exception {
	
		StringBuffer buf = new StringBuffer();
		buf.append("Hello");
		buf.append(newLine);
		buf.append("World");

		 FileWriter writer = new FileWriter(new File("out.txt"));
		 writer.write(buf.toString());
		 writer.close();
		System.out.println(buf.toString());
	}

}
