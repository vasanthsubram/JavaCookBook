package core.io.byteStreams.others;

import java.io.File;
import java.io.FileInputStream;

/**
 * Compare two files, one byte at a time.
 * 
 * If each character in one file matches the byte in the other file then files
 * are identical. If at least one character does not match, the files are not
 * identical
 * 
 * @author chq-vasanthakumars
 * 
 */
public class CompareByteByByte {

	public static void main(String[] args) throws Exception {
		File file1 = new File("output/identical1.txt");
		File file2 = new File("output/identical2.txt");

		if (file1.length() != file2.length()) {
			System.out.println(file1 + " \n" + file2
					+ "\n  are unequal in length");
			System.exit(0);
		}

		FileInputStream stream1 = new FileInputStream(file1);
		FileInputStream stream2 = new FileInputStream(file2);
		int f1;
		while ((f1 = stream1.read()) != -1) {
			if (f1 != stream2.read()) {
				System.out.println(file1 + "\n " + file2
						+ "\n  are NOT identical");
				stream1.close();
				stream2.close();
				System.exit(0);
			}
		}
		System.out.println(file1 + "\n " + file2 + "\n  are identical");
	}
}
