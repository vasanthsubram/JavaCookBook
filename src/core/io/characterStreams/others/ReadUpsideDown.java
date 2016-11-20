package core.io.characterStreams.others;

import java.io.File;
import java.io.FileReader;

public class ReadUpsideDown {
	
	public static void main(String[] args) throws Exception {
		File f = new File("output/upsideDown.txt");
		FileReader reader = new FileReader("output/upsideDown.txt");

		char[] charArray = new char[(int) f.length()];
		int length = (int) f.length();
		reader.read(charArray, 0, length);

		System.out.println("length=" + length);
		for (int i = 0, j = length - 1; i < length; i++, j--) {
			System.out.print(charArray[j]);
		}
		reader.close();
	}
}