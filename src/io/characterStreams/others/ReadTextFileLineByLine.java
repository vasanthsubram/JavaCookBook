package io.characterStreams.others;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadTextFileLineByLine {

	public static void main(String args[]) throws Exception {
		String line;
		BufferedReader buffReader;

		buffReader = new BufferedReader(new FileReader("output/linebyline.txt"));

		while ((line = buffReader.readLine()) != null) {
			System.out.println(line);
		}
		buffReader.close();
	}
}
