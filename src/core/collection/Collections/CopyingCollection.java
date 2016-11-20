package core.collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The destination collection cannot be empty - bizzare
 * 
 * @author chq-vasanthakumars
 *
 */
public class CopyingCollection {

	public static void main(String[] args) {
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(1);
		aList.add(2);
		aList.add(3);

		List<Integer> aList2 = new ArrayList<Integer>();
		
		//destination collection cannot be empty - WTF ?
		aList2.add(-1);
		aList2.add(-1);
		aList2.add(-1);
						  //dest, source
		Collections.copy(aList2, aList);

		System.out.println("Copied list");
		for (int i : aList2) {
			System.out.println(i);
		}

	}

}
