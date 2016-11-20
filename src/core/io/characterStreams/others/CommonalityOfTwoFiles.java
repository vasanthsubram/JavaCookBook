package core.io.characterStreams.others;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * Compare two files - line by line.
 * Report lines that are in first file but not in second file.
 * Report lines that are in second file but not in first file.
 * Ignores if the lines are out of order.
 * 
 * @author chq-vasanthakumars
 *
 */
public class CommonalityOfTwoFiles {

	public static void main(String[] args) throws Exception {
		BufferedReader first = null, second = null;
		String file1 = "output/file1.txt";
		String file2 = "output/file2.txt";
			
		try {
			first = new BufferedReader(new FileReader(file1));
			second = new BufferedReader(new FileReader(file2));

			List<String> firstList = new ArrayList<String>(128);
			List<String> secondList = new ArrayList<String>(128);
			String line;
			while ((line = first.readLine()) != null) {
				firstList.add(line);
			}

			while ((line = second.readLine()) != null) {
				secondList.add(line);
			}

			List<String> common = (ArrayList<String>) CollectionUtils.intersection(firstList, secondList);


			if (common.isEmpty()) {
				System.out.println("No similiarty between files");
			} else {
				System.out.println("Lines that are in both files");
				for (String s : common) {
					System.out.println(s);
				}
			}
		} finally {
			first.close();
			second.close();
		}
	}
}

