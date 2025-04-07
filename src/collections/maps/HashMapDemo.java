package collections.maps;

import java.util.HashMap;
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
		

		map.remove(null);
		System.out.println(map);

		if(map.containsKey("USA")) System.out.println("USA is present");
		if(map.containsValue("London")) System.out.println("London is present");


	}
}
