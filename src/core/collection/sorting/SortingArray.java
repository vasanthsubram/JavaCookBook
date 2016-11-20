package core.collection.sorting;

import java.util.Arrays;

public class SortingArray {
	public static void main(String[] args) {
		int[] arr = {8,4,2,1};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		String[] strArr={"2 medium","1 small","3 large"};
		System.out.println(Arrays.toString(strArr));
		
		Arrays.sort(strArr);
		System.out.println(Arrays.toString(strArr));
	}
}
