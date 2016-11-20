package core.collection;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsThatKeepsInsertOrder {

	public static void main(String[] args) {
		
		Set<String> set = new LinkedHashSet<String>();
		set.add("tomato");
		set.add("tomato");
		set.add("rice");
		set.add("apple");
		set.add("apple");
		
		//eliminates duplicates but keeps the order
		System.out.println(set.toString());
		
		//Map
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("tomato", "vegtable");
		map.put("rice", "grain");
		map.put("apple", "fruit");
		System.out.println(map.toString());
		
		//List
		List<String> list = new ArrayList<String>();
		list.add("tomato");
		list.add("rice");
		list.add("apple");
		System.out.println(list.toString());	
	}
}
