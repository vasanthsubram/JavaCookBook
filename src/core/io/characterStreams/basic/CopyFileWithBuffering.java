package core.io.characterStreams.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyFileWithBuffering {

	public static void main(String[] args) throws Exception {
		String line;

		BufferedReader buffReader = new BufferedReader(new FileReader(
				"output/buffReaderWriter.txt"));
		BufferedWriter buffWriter = new BufferedWriter(new FileWriter(
				"output/buffReaderWriterOut.txt"));

		while ((line = buffReader.readLine()) != null) {
			buffWriter.write(line);
			buffWriter.newLine();
		}
		buffWriter.close();
		buffReader.close();
	}
}
