package core.collection.array;

import java.util.Arrays;

//Easier way to print any array, instead of looping through the elements

public class PrintingArray {
	
	public static void main(String[] args) {
	
		int[] arr = { 8, 4, 2, 1 };
		int[] nullArr = null;
		
		System.out.println(Arrays.toString(arr));
		
		System.out.println(Arrays.toString(nullArr));
		
		String[] strArr={"1 small","2 medium","3 large"};
		System.out.println(Arrays.toString(strArr));
	}
}
