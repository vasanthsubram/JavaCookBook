package core.collection.conversions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author vsubramanian
 */
public class ArrayToList {

    public static void main(String[] args) {
            //creates a list but novel array creation
		List<String> list = Arrays.asList("Jello", "Hello");

		//convert list to array
		list.toArray();

      Set<String> set = new HashSet<>(Arrays.asList("Stree", "Cars", "Ardvark"));

      String[]  strArr = set.toArray(new String[0]);


    }
}
