package io.characterStreams.basic;

import java.io.OutputStreamWriter;

public class OutputStreamWriterExample {

	public static void main(String args[]) throws Exception {
		OutputStreamWriter writer = new OutputStreamWriter(System.out);
		for (int i = 0; i < 127; i++) {
			writer.write(i);
		}
		writer.close();
	}
}
