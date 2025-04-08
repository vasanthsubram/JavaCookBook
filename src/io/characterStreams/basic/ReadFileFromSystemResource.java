package io.characterStreams.basic;

import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileFromSystemResource {

	public static void main(String[] args){
		FileReader reader=null;
		try {
			reader = new FileReader(ClassLoader.getSystemResource("imageClient.config").getFile());
			System.out.println("opened the file");
			
		} catch (FileNotFoundException e) {
			fail();
		} finally{
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
