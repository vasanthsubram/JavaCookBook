package core.io.characterStreams.basic;

import java.io.FileReader;
import java.io.PrintWriter;

public class WriteToFile {

	public static void main(String[] args) throws Exception {
		PrintWriter w = new PrintWriter("output/print_writer.txt");
		w.println("Hello World");
		w.println(false);
		w.println('c');
		w.println(new Object());
		
		try {
			new FileReader("Non-ExistingFile");
		} catch (Exception e) {
			w.println(e);
		}
		w.close();
	}
}
