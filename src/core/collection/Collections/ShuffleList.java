package core.collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleList {

	static Random r = new Random();

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(i);
		}
		System.out.println(list);
		shuffle(list);
		System.out.println(list);
//		Collections.shuffle(list);
//		System.out.println(list);
	}

	static void shuffle(List<Integer> list) {
		int max = list.size();
		for (int i = 0; i < max; i++) {
			int randIdx = r.nextInt(max);
			int valAtRandIdx=list.get(randIdx);
			int valAtCurrIdx=list.set(i, valAtRandIdx);  //set() returns the original value
			list.set(randIdx, valAtCurrIdx);
		}
	}
}
