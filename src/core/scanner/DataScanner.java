package core.scanner;

import java.io.File;
import java.util.Scanner;

public class DataScanner {

	public static void main(String args[]) throws Exception {
		Scanner scanner = new Scanner(new File("output/data_scanner.txt"));
		scanner.useDelimiter(System.getProperty("line.separator"));
		while (scanner.hasNext()) {
			parseLine(scanner.next());
		}
		scanner.close();
	}

	private static void parseLine(String line) {
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter("\\s*,\\s*");
		String name = lineScanner.next();
		int age = lineScanner.nextInt();
		boolean isCertified = lineScanner.nextBoolean();
		System.out.println("It is " + isCertified + " that " + name + ", age "
				+ age + ", is certified.");
	}
}