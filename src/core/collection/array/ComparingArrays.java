package core.collection.array;

import java.util.Arrays;

public class ComparingArrays {
	
	public static void main(String[] args) {
		
		// the elements must be in the same order in both arrays        
		System.out.println(Arrays.equals(new int[] { 1, 2, 3 }, new int[] {1,2,3 }));
		
                
		System.out.println(Arrays.equals(new int[] { 1, 2, 3 }, new int[] { 3,2, 1 }));
		// false
	}
}
