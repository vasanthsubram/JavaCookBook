package io.characterStreams.others;

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
public class CompareTwoFiles {

	public static void main(String[] args) throws Exception {
		BufferedReader first = null, second = null;
		String file1 = "c:/prod/txnref_blob_id1.txt";
		String file2 = "C:/prod/cent_blob_id1.txt";
			
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

			List<String> result_a = (ArrayList<String>) CollectionUtils.subtract(
					firstList, secondList);

			List<String> result_b = (ArrayList<String>) CollectionUtils
					.subtract(secondList, firstList);

			if (result_a.isEmpty() & (result_b.isEmpty())) {
				System.out.println("No difference between files");
			} else {
				System.out.println("Lines that are in "+ file1 + "  but not in " + file2);
				for (String s : result_a) {
					System.out.println(s);
				}
				System.out.println();
				System.out.println("*************************");
				System.out.println();
				System.out.println("Lines that are in "+ file2 + "  but not in " + file1);
				for (String s : result_b) {
					System.out.println(s);
				}
			}
		} finally {
			first.close();
			second.close();
		}
	}
}

