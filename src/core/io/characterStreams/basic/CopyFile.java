package core.io.characterStreams.basic;

import java.io.FileReader;
import java.io.FileWriter;

public class CopyFile {

	public static void main(String[] args) throws Exception {
		int in;

		FileReader reader = new FileReader("output/ReaderWriterInput.txt");
		FileWriter writer = new FileWriter("output/ReaderWriterOuput.txt");
		while ((in = reader.read()) != -1) {
			writer.write(in);
		}
		reader.close();
		writer.close();
	}
}
