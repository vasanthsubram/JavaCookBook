package collection_lambda.collection.demos;

import java.util.Comparator;
import java.util.TreeMap;

public class SortedMapComparatorDemo {

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

		
		//***********using Comparator
		class Intcompare implements Comparator<Integer> {
			public int compare(Integer o1,Integer o2) {
				return o1.compareTo(o2);
			}
		}
		TreeMap<Integer,String> map2=new TreeMap<Integer,String>(new Intcompare());
		map2.put(100,"orange");
		map2.put(300,"apple");
		map2.put(200,"grapes");
		map2.put(400,"grapes");
		System.out.println("The TreeMap Is " +map2);
	}
}
