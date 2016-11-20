package core.collection.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("2 medium");
		list.add("1 small");
		list.add("3 large");
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
               
	}

}
