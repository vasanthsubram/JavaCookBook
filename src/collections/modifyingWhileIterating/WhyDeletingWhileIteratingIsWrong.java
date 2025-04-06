package collection_lambda.collection.modifyingWhileIterating;

import java.util.ArrayList;
import java.util.List;

public class WhyDeletingWhileIteratingIsWrong {

	/*
	 This gives a  Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 3, Size: 3.
      This because when the element is removed from the list, the size of the list is reduced but the �listSize� 
       is still 4 and the loop fails when index=3.
	 */
	public static void main(String[] args) {
		List<String> moocs = new ArrayList<String>();
		moocs.add("Coursera");
		moocs.add("Udacity");
		moocs.add("DIYComputerScience");
		moocs.add("Codecademy");

		int size = moocs.size();

		for (int i = 0; i < size; i++) {
			String mooc = moocs.get(i);
			if (mooc.startsWith("U")) {
				moocs.remove(i);
			}
		}

		System.out.println(moocs.toString());
	}

}
