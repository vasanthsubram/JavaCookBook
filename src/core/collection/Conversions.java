package core.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Conversions {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Hell");
		list.add("Boy");
		//convert list to array
		String[] arr = list.toArray(new String[list.size()]);
		
		for(String s: arr){
			System.out.println(s);
		}
		
		//convert array to list
		List<String> newList =Arrays.asList(arr);
		for(String s: newList){
			System.out.println(s);
		}

		//immutable empty list
		List<String> l1 =Collections.emptyList();
		try {
			l1.add("heaven");
			l1.add("sent");
		} catch (java.lang.UnsupportedOperationException ex) {
			System.out.println("Immutable list cannot be modified");
		}	
	}

}
