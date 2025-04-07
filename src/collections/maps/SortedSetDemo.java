package collections.maps;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

	public static void main(String[] args) {
		SortedSet s = new TreeSet();
		s.add("mello");
		s.add("jello");
		s.add("hello");
		s.add("fello");
		s.add("bello");
		s.add("tello");

		System.out.println(s);

		// create a subset with elements starting between a and f
		SortedSet sub1 = s.subSet("g", "m");
		System.out.println(sub1);

		//elements from top to upto elements starting with "g"
		SortedSet sub2 = s.headSet("g");
		System.out.println(sub2);

		//from elements starting with "g" and all the way to the end
		SortedSet sub3 = s.tailSet("g");
		System.out.println(sub3);
		
		//subsetting results in a view that is backed by the original collection
		//changes in subset affects the original collection and vice versa
		sub3.remove("tello");
		System.out.println(s); //now "tello" is removed from original collection
	}
}
