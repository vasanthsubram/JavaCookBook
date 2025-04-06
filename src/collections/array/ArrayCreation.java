package collection_lambda.collection.array;

import java.util.List;

public class ArrayCreation {

	public static void main(String[] args) {
		
		//array initializer, not a constructor
		int[] arr1 = {1,2,3};
		
		int[] arr2 = new int[]{1,2,3};
		
		int[] arr3 = new int[3];
		arr3[0]=1;
		arr3[1]=2;
		arr3[2]=3;

		Integer[] intArr1 = List.of(1,2,3).toArray(new Integer[0]);

		//int[] intArr2 = List.of(1, 2, 3).toArray(new int[0]);
		// Because List.of(1, 2, 3) creates a List<Integer>, and the toArray(T[] a) method
		// only works with reference types — not with primitive types like int.


		int[] intArr = List.of(1,2,3).stream().mapToInt(Integer::intValue).toArray();
		// Print the array
		for (int num : intArr) {
			System.out.print(num + " ");
		}
	}
}
