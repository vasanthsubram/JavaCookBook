package core.io.zip;

import java.io.FileInputStream;
import java.util.zip.GZIPInputStream;

public class ReadGZippedFile {

	public static void main(String args[]) throws Exception {
		
		GZIPInputStream reader = new GZIPInputStream(new FileInputStream(
				"output/a.xml.gzip"));
		byte[] buf = new byte[1024];
		while (reader.read(buf) > 0) {
			System.out.println(new String(buf));
		}
		reader.close();
	}
}
