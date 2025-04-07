package io.zip;

import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class PrintZipFileEntries {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println("Contents of zip file" );
		System.out.println("--------------------------");
		ZipFile zipFile = new ZipFile("output/zip-test.zip");
		Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zipFile.entries();
		
		while(entries.hasMoreElements()) {	
			ZipEntry entry = (ZipEntry) entries.nextElement();
			System.out.println("Name :" + entry.getName());
			System.out.println("Timestamp : " + new Timestamp(entry.getTime()));
		}
	}
}
