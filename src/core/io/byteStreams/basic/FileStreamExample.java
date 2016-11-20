package core.io.byteStreams.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileStreamExample {

	public static void main(String[] args) throws Exception {
		String fileName="output/file_Stream.txt";
		FileOutputStream out = new FileOutputStream(fileName);
		for (int i = 'A'; i < 'Z'; i++) {
			out.write(i);
		}
		out.close();
		System.out.println("Write to file complete");
		
		int aByte;
		FileInputStream in = new FileInputStream(fileName);
		while ((aByte = in.read()) != -1) {
			System.out.println(aByte);
		}
		in.close();
	}
}
