package core.collection.demos;

import java.util.HashMap;
import java.util.Map;

public class HashMapAdvancedDemo {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();

		for (int i = 0; i < 4; i++) {
		    map.putIfAbsent(i, "val" + i);
		}

		//apply the consumer for each of the key,value pair
		map.forEach((id, val) -> System.out.println(val));
		
		map.computeIfPresent(3, (num, val) -> val + num);
		System.out.println("key=3, value = " + map.get(3));             // val33

		map.computeIfPresent(4, (num, val) -> null);
		System.out.println("key=4 is present = " + map.containsKey(4));     // false

		map.computeIfAbsent(23, num -> "val" + num);
		System.out.println(map.containsKey(23));    // true

		map.computeIfAbsent(3, num -> "bam");
		System.out.println(map.get(3));             // val33


		//remove entries for a a given key, only if it's currently mapped to a given value:
		map.remove(3, "val3");
		System.out.println("failed to remove -> " + map.get(3));             // val33

		map.remove(3, "val33");
		System.out.println("now removed, as both key,value match  ->"+map.get(3));             // null


	}
}
