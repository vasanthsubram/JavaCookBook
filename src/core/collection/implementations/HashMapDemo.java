package core.collection.implementations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo {

	public static void main(String[] args) {
		//pick the initial capacity (num of buckets) to be a power of 2 (2^n)
		//if not the constructor makes sure, that it is
		Map<String,String> map = new HashMap<String,String>(2);
			//in this it allocates 8
		
		map.put("USA", "Washington DC");
		map.put("India", "New Delhi");
		map.put("England", "London");
		System.out.println(map);
		
		//key can be null
		map.put(null, "GoldCity");
		//value can be null
		map.put("Heaven", null);
		
		System.out.println(map.get("India"));
		
		// get() could return null in two situations- 
		//there could be mapping with null as the value 
		// or there is no mapping with the given key
		//the null returned is ambiguous
		System.out.println(map.get("Heaven"));
		System.out.println(map.get("Hell"));
		
		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String s = it.next();
			//key could be null
			if (s != null) {
				if (s.equals("Heaven") | (s.equals("Hell"))) {
					//while iterating through iterator, remove using the iterator
					//in this case the set returned by keySet() is backed by the map
					//therefore removing through the iterator deletes the key-value pair in the map
					it.remove();
				}
			}
		}		
		map.remove(null);
		System.out.println(map);
	}
}
