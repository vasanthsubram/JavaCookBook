package core.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Writer;
import java.nio.charset.Charset;

public class CharacterEncoding {

	public static void main(String[] args) throws Exception {
		String str = "Aa1234";
		writeToFile("ASCII", str);
		writeToFile("UTF-8", str);
		// UTF-16 - there is a byte-order-marking in the beginning of the file
		writeToFile("UTF-16", str);
	}

	public static void writeToFile(String charSetName, String content)
			throws Exception {
		System.out.println(charSetName);
		Charset c = Charset.forName(charSetName);
		File f = new File("output/coding" + charSetName);
		final Writer fw = new OutputStreamWriter(new FileOutputStream(f), c);
		fw.write(content);
		fw.close();

		RandomAccessFile raf2 = new RandomAccessFile("output/coding"
				+ charSetName, "r");

		for (int i = 0; i < raf2.length(); i++) {
			System.out.format("%x", raf2.readUnsignedByte());
		}
		raf2.close();
		System.out.println();
	}
}
