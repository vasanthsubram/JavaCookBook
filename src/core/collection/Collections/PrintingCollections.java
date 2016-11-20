package core.collection.Collections;

import java.util.ArrayList;
import java.util.List;

public class PrintingCollections {
	
	public static void main(String[] args) {
		List list = new ArrayList();
		
		list.add(2);
		list.add('e');
		list.add(null);
		list.add("asda");
		list.add(null);
		list.add(3);
	
		/*
		 * System.out.println(Collection c) already print any type of collection in readable format. 
		 * Only if collection contains user defined objects , then you need to implement toString() in user defined 
		 * class to display content
		 */
		System.out.println(list);
	}
}
