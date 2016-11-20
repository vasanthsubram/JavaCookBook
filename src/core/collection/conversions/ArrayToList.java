package core.collection.conversions;

import java.util.Arrays;
import java.util.List;

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
    }
}
