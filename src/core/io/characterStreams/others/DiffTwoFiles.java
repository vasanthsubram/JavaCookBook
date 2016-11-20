package core.io.characterStreams.others;

import java.io.FileReader;
import java.io.LineNumberReader;

/**
 * Compare two files - line by line.
 * If line x is different between two files print it; otherwise ignore 
 * 
 * @author chq-vasanthakumars
 *
 */
public class DiffTwoFiles {

	public static void main(String[] args) throws Exception {
		LineNumberReader first = null, second = null;
		boolean diff = false;
		String file1 = "C:/Temp/prod-query/dfw.txt";
		String file2 = "C:/Temp/prod-query/sea.txt";
		try {
			first = new LineNumberReader(new FileReader(file1));
			second = new LineNumberReader(new FileReader(file2));

			System.out.println("Comparing " + file1 + "  and  " + file2 + "\n");
			String line1, line2;
			String indicator="-->";
			while (((line1 = first.readLine()) != null)
					& ((line2 = second.readLine()) != null)) {
				if (!line1.equals(line2)) {
					diff = true;
					System.out.println("LineNumber :" + first.getLineNumber());
					if (line1 != null) {
						System.out.println(indicator + line1);
					}else{
						System.out.println(indicator);
					}
					if (line2 != null) {
						System.out.println(indicator+line2);
					}else{
						System.out.println(indicator);
					}
					System.out.println();
				}
			}

			if (!diff) {
				System.out.println("No difference between files");
			} else {
				System.out.print("Line Number: "  );
				if (line1 == null) {
					System.out.println(second.getLineNumber());
					System.out.println(indicator);
				} else {
					System.out.println("Line Number: "  + first.getLineNumber());
					System.out.println(indicator + line1);
				}
				if (line2 == null) {
					System.out.println(indicator);
				} else {
					System.out.println(indicator + line2);
				}
				System.out.println();
				while ((line1 = first.readLine()) != null) {
					System.out.println("Line Number: "  + first.getLineNumber());
					System.out.println(indicator + line1);
					System.out.println(indicator);
					System.out.println();
				}
				while ((line2 = second.readLine()) != null) {
					System.out.println("Line Number: "  + second.getLineNumber());
					System.out.println(indicator);
					System.out.println(indicator + line2);
					System.out.println();
				}
				System.out.println("******** Comparsion Completed ********");
			}
		} finally {
			first.close();
			second.close();
		}
	}
}

