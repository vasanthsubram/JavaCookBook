package others.ugly;

import java.util.ArrayList;

public class UglyAnonymous {
	public static void main(String args[]){
		int[] arr = new int[]{1,2,3};
		
		//ArrayList aList = new ArrayList(){add(1); add(2);};
		ArrayList aList = new ArrayList(){{add(1); add(2);}};
		
		for(Object o: aList){
			System.out.println(o);
		}
		System.out.println(aList.getClass().getName());
		System.out.println(aList.getClass().getSuperclass().getName());
	}
}
