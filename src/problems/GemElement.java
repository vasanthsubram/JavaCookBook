package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GemElement {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int NUM = in.nextInt();
		String[] rocks=new String[NUM];
		
		for (int i = 0; i < NUM; i++) {
			rocks[i] = in.next();
		}

		Map<Character, Integer> allCounts = new HashMap<Character, Integer>();
		
		for (int i = 0; i < NUM; i++) {
			//elements for one rock
			Map<Character, Integer> counts = new HashMap<Character, Integer>();
			for (int j = 0; j < rocks[i].length(); j++) {
				counts.put(rocks[i].charAt(j), 1);
			}
			Set<Character> keys = counts.keySet();
			
			//add to the total
			for(Character c: keys){
				if(allCounts.containsKey(c)){
					int occurence = allCounts.get(c);
					allCounts.put(c, occurence+1);
				} else{
					allCounts.put(c, 1);
				}
			}
		}
		
		Set<Character> keys = allCounts.keySet();
		int result=0;
		for(Character c: keys){
			if(allCounts.containsKey(c)){
				if(allCounts.get(c) == NUM){
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
