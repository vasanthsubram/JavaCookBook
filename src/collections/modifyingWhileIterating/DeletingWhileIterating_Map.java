package collection_lambda.collection.modifyingWhileIterating;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DeletingWhileIterating_Map {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("USA", "Washington DC");
		map.put("India", "New Delhi");
		map.put("England", "London");
		map.put("Heaven", null);

		Iterator<String> it = map.keySet().iterator();
		while (it.hasNext()) {
			String s = it.next();
			if (s.equals("Heaven") | (s.equals("Hell"))) {
				// while iterating through iterator, remove using the iterator
				// in this case the set returned by keySet() is backed by the map
				// therefore it.remove() actually deletes the key-value pair in the map
				it.remove();
			}
		}
		System.out.println(map);
	}
}
