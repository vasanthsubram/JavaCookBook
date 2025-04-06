package collection_lambda.collection.iterators;

import java.util.Collection;
import java.util.Iterator;

/**
 * Demonstrate Iterator usage
 * @author chq-vasanthakumars
 *
 */
public class IteratorDemo {

	public static void main(String[] args) {
		Collection coll = System.getProperties().keySet();
		Iterator it = coll.iterator();
		
		while (it.hasNext()) {
			if (((String) it.next()).length() > 10) {
				// remove the most recent element returned by next()
				// IllegalStateException if the next is not yet called
				// or remove has already been called since the last call to next
				it.remove();
			}
		}
		System.out.println(coll);
	}
}
