package core.collection.zz_smartIterator;
import java.util.*;

/**
 * Define blocks - render behaviour as objects, which then can be 
 * passed around and executed at a later time
 *
 */
interface BooleanBlock {
	public static BooleanBlock IsOddBooleanBlock = new BooleanBlock() {
		public boolean value(Integer o) {
			return o.intValue() % 2 != 0;
		}
	};
	public boolean value(Integer o);
}

interface DoBlock{
	public static DoBlock addOneToEachElementBlock = new DoBlock() {
		public Integer value(Integer o) {
			return Integer.valueOf((o.intValue()+1));
		}
	};
	
	public Integer value(Integer o);
}

/**
 * A special iterator class that accepts a collection and a block as parameter.
 * It then iterates over the collection and executes the block on each element.
 * The result of each execution is collected in another collection.
 * The resultant collection is then returned
 *
 */
class SmalltalkLikeIterator {
	// return only the odd elements of the source collection
	public static ArrayList<Integer> select(ArrayList<Integer> source, BooleanBlock block) {
		ArrayList<Integer> result = null;
		result = new ArrayList();
		for (Integer each : source) {
			if ((block.value(each)))
				result.add(each);
			}
		return result;
	}
	// add 1 to each element in the source collection and return the resulting collection
	public static ArrayList<Integer> doToEachElement(ArrayList<Integer> source, DoBlock block){
		ArrayList<Integer> result = null;
		result = new ArrayList();
		for (Integer each : source) {
			result.add(block.value(each));
		}
		return result;
	}
}


/**
 * Test program 
 *
 */
public class SmalltalkBlockImpl {
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		list.add(100);
		list.add(201);
		list.add(400);
		list.add(501);
		ArrayList<Integer>  newList = (ArrayList<Integer> ) SmalltalkLikeIterator.select(list,	BooleanBlock.IsOddBooleanBlock);
		System.out.println("Odd number List");
		for (Integer e : newList) {
			System.out.println(e);
		}
		
		System.out.println("Increment List");
		ArrayList<Integer>  incrementList = (ArrayList<Integer> ) SmalltalkLikeIterator.doToEachElement(list, DoBlock.addOneToEachElementBlock);
		for (Object e : incrementList) {
			System.out.println(e);
		}
	}
}
