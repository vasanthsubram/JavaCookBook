package collections.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveNullElementsFromACollection {

	public static void main(String[] args) {
		List list = new ArrayList();
		
		list.add(2);
		list.add('e');
		list.add(null);
		list.add("asda");
		list.add(null);
		list.add(3);
		System.out.println(list);
		
		list.removeAll(Collections.singleton(null));
		System.out.println("\n After removing all nulls");
		
		System.out.println(list);
	}

}
