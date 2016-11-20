package core.collection.iterators;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Demonstrate Iterator usage
 * @author chq-vasanthakumars
 *
 */
public class ListIteratorSetDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("c");
		list.add("c");
		list.add("d");
		ListIterator<String> it = list.listIterator();

			System.out.println(list);
		it.next();
		it.next();
		
		//replaces the element last returned by next or previous
		it.set("z");
		System.out.println(it.nextIndex());
		
			System.out.println(list);
		it.previous();
		it.set("b");
			System.out.println(list);
		System.out.println(it.nextIndex());
	}
}
