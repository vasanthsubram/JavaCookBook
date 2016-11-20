package core.collection.array;

import java.util.Arrays;
import static org.junit.Assert.*;
public class CopyArray {
	public static void main(String[] args) {
		int[] original = { 10, 20, 30 };
		
		System.out.println("Copy using Arrays");
		int[] copy = Arrays.copyOf(original, original.length);
		assertFalse(original==copy);
		for (int i : copy) {
			System.out.println(i);
		}
		
		System.out.println("Copy using System");
		int[] secondCopy = new int[original.length];
		System.arraycopy(original, 0, secondCopy, 0, 3);
		for (Integer i : secondCopy) {
			System.out.println(i);
		}
		
		int two2Darray[][] = {{1,2,3} , {4,5,6} , {7,8,9}};
		int two2Copy[][]=new int[3][3];
		System.arraycopy(two2Darray, 0, two2Copy, 0, 3);
		assertFalse(two2Darray==two2Copy);
		assertTrue(two2Darray[0]==two2Copy[0]);
		
		System.out.println("Copying using cloning");
		Object[] objArr = new Object[] { new Object(), new Object() };
		Object[] cloneObjArr = objArr.clone();
		System.out
				.println("References at location 0 in both arrays is pointing to the same object:  "
						+ (objArr[0] == cloneObjArr[0]));
		System.out
				.println("References at location 1 in both arrays is pointing to the same object:  "
						+ (objArr[1] == cloneObjArr[1]));
	}
}
