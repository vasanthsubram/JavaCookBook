package core.collection.conversions;

import java.util.ArrayList;
import java.util.List;

public class CollectionToArray {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Gold");
		list.add("Silver");
		list.add("Platinum");

		for (Object s : list.toArray()) {
			System.out.println(s);
		}
		
		//let toArray() determine the right size of the return array
		String[] strArr =list.toArray(new String[0]);
		for (String s : strArr) {
			System.out.println(s);
		}
	}
}
