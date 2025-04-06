package collection_lambda.collection.iterators;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Demonstrate Iterator usage
 * 
 * A ListIterator has no current element; its cursor position always lies
 * between the element that would be returned by a call to previous() and the
 * element that would be returned by a call to next().
 * 
 * @author chq-vasanthakumars
 * 
 */
public class ListIteratorDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		ListIterator<String> it = list.listIterator();
		
		try {
			System.out.println(it.previous());
		} catch (NoSuchElementException ex) {
			System.out.println(ex.toString());
		}

		while (it.hasNext()) {
			// nextIndex does not advance the iterator
			System.out.print(it.nextIndex());
			System.out.print("\t");
			System.out.println(it.next());
		}

		try {
			System.out.println(it.next());
		} catch (NoSuchElementException ex) {
			System.out.println(ex.toString());
		}
		System.out.println();
		System.out.println();

		while (it.hasPrevious()) {
			System.out.print(it.previousIndex());
			System.out.print("\t");
			System.out.println(it.previous());
		}
	}
}
