package core.io.byteStreams.others;

import java.io.File;
import java.io.FileInputStream;

public class ReadStreamUpsideDown {
	
	public static void main(String[] args) throws Exception {
		File f = new File("output/upsideDown.txt");
		FileInputStream stream = new FileInputStream(f);
		int length = (int) f.length();
		byte[] byteArray = new byte[length];
		stream.read(byteArray, 0, length);
		for (int i = 0, j = length - 1; i < length; i++, j--) {
			System.out.print((char)byteArray[j]);
		}
		stream.close();
	}
}