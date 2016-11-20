package core.io.byteStreams.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFile {

	public static void main(String[] args) throws Exception {
		int aByte;
		FileInputStream in = new FileInputStream("output/CopySource.txt");
		FileOutputStream out = new FileOutputStream(
				"output/CopyDestination.txt");
		while ((aByte = in.read()) != -1) {
			out.write(aByte);
		}
		in.close();
		out.close();
	}
}
