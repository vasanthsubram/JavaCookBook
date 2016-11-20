package core.basicJava;

import java.util.ArrayList;

/**
 * This code compile but generates run time exception
 * @author vasanth
 *
 */
public class CrazyCasting {

	public static void main(String[] args) {
		//compile error
		// ArrayList aList1 = new Object();   
		
		//compiles ok but runtime error
		ArrayList aList2 = (ArrayList) new Object();   
		
		
		//compiles ok but runtime error
		Object o1 = new Object(); 
		 ArrayList aList3 = (ArrayList) o1;
		 
	}

}
