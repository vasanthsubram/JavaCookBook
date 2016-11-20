package core.scanner;

import java.io.File;
import java.util.Scanner;

public class TextScanner {

	public static void main(String args[]) throws Exception {
		Scanner scanner = new Scanner(new File("output/data_scanner.txt"));
		scanner.useDelimiter(System.getProperty("line.separator"));
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
		scanner.close();
	}
}