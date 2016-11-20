package core.collection.Collections;

import java.util.*;

public class ReverseList {

	public static void main(String[] args) {
		List<Integer> aList = new ArrayList<Integer>(3);
		aList.add(1);
		aList.add(2);
		aList.add(3);

		Collections.reverse(aList);
		System.out.println("Reverse order");
		for (int i : aList) {
			System.out.println(i);
		}
	}
}