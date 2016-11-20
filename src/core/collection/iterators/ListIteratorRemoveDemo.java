package core.collection.iterators;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorRemoveDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		ListIterator<String> it = list.listIterator();
		
		it.next();
		it.next();
		
		// Removes from the list the last element that was returned by next or
		// previous (optional operation). This call can only be made once per
		// call to next or previous. 
		it.remove();
		System.out.println(list);
	}
}
