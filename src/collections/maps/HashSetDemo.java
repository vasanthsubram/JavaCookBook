package collections.maps;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		//does not add duplicates
		set.add("str1");
		set.add("str1");
		set.add("str2");
		
		//prints the elements in underlying array - that is why the order is not guarantted
		//as new elements are added they may be put in any index of the array
		System.out.println(set);
		
		set.remove(5);
		System.out.println(set);

		set.add(null);
		System.out.println(set);		
		System.out.println(set.contains(null));

		System.out.println(set);
	}
}
