package collection_lambda.collection.modifyingWhileIterating;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Use 'iterator' to delete or copy of a collection, while enumerating a
 * collection. Using other means to delete while enumerating is unsafe
 * 
 * @author chq-vasanthakumars
 */
public class DeletingWhileIterating {

	public static void main(String[] args) throws Exception{

		/* *****************************
		 *  UNSAFE
		 *  ****************************/
		List<String> list1 = new ArrayList<String>();
		list1.add("AAA");
		list1.add("BBB");
		list1.add("CCC");
		System.out.println("Delete while iterating -1");
		try {
			for (String s : list1) {
				System.out.println(list1);
				Thread.sleep(100);
				//modifying the underlying collection after the iterator is created throws an exception
				list1.remove(s);
			}
		} catch (java.util.ConcurrentModificationException e) {
			e.printStackTrace();
		}
		Thread.sleep(100);

		/* *****************************
		 *  SAFE - Copy
		 *  *****************************/
		List<String> list2 = new ArrayList<String>();
		list2.add("DDD");
		list2.add("EEE");
		list2.add("FFF");
		List<String> listCopy = new  ArrayList<String>(list2);
		System.out.println("Delete while iterating -Copy method");

		for (String s : listCopy) {
			System.out.println(list2);
			list2.remove(s);
		}
		
		/* *****************************
		 *  SAFE - Iterator
		 *  ****************************/
		List<String> list3 = new ArrayList<String>();
		list3.add("SSS");
		list3.add("TTT");
		list3.add("UUU");
		Iterator it = list3.iterator();
		System.out.println("Delete while iterating -Iterator method");
		while (it.hasNext()) {
			System.out.println(list3);
			it.next();
			it.remove();
		}
	}
}
