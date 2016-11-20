package core.collection.implementations;

import java.util.Iterator;
import java.util.TreeMap;

public class SortedMapDemo {

	public static void main(String[] args) {
		//Objects that implement comparable interface can be used as 
		//elements in the TreeMap collection
		TreeMap<String,String> map = new TreeMap<String,String>();
		map.put("USA", "Washington DC");
		map.put("England", "London");
		map.put("India", "New Delhi");
		System.out.println(map);

		System.out.println(map.firstKey());
		System.out.println(map.lastKey());
		System.out.println(map.keySet());
		System.out.println(map.values());
		System.out.println(map.comparator());

		System.out.println(" *** regular iteration");
		Iterator it = map.keySet().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		/*
		 * TreeMap implements NavigableMap interface and following methods are
		 * available
		 */
		System.out.println("descending map " + map.descendingMap());
		
		System.out.println(" ****  descending iteration");
		Iterator descendingIterator = map.navigableKeySet().descendingIterator();
		while(descendingIterator.hasNext()){
			System.out.println(descendingIterator.next());
		}
		
		
	}
}
