package core.collection.sorting;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Even though strings are comparable but that comparison is case sensitive
 * To do case insensitive comparison use the comparator provided in String
 * class
 */
public class CaseInsensitiveStringSorting {

	public static void main(String[] args) {

		SortedSet<String> set = new TreeSet<String>(
				String.CASE_INSENSITIVE_ORDER);
		set.add("Banana");
		set.add("apple");

		System.out.println(set);
	}
}
