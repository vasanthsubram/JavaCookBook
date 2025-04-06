package collection_lambda.collection.iterators;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Demonstrate Iterator usage
 * @author chq-vasanthakumars
 *
 */
public class ListIteratorAddDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("c");
		list.add("d");
		ListIterator<String> it = list.listIterator();

		System.out.println(list);
		it.next();
		
		//inserts element into the list in front of the next element 
		//that would be returned
		it.add("b");
		
		//the iterator is moved forward after an add
		//if you invoke previous after an add you will get the added element
		System.out.println(it.previous());
		System.out.println(list);
		
		while(it.hasNext()){
			it.next();
		}
		//inserts element at the end, if hasNext returns false
		it.add("e");
		System.out.println(list);
		
	}
}
