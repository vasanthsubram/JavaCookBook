package core.io.zip;

import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class PrintZipFileContents {

	public static void main(String[] args) throws Exception {

		System.out.println("Contents of zip file");
		System.out.println("--------------------------");
		ZipFile zipFile = new ZipFile("output/zip-test.zip");
		Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zipFile
				.entries();

		while (entries.hasMoreElements()) {
			ZipEntry entry = (ZipEntry) entries.nextElement();
			System.out.println("Entry name = " + entry.getName());
			InputStreamReader in = new InputStreamReader(zipFile
					.getInputStream(entry));
			int ch;
			while ((ch = in.read()) != -1) {
				System.out.print((char) ch);
			}
			System.out.println();
		}
		zipFile.close();
	}
}
