package core.strings;

public class Literal_Dynamic {

	public static void main(String args[]) {
		
		// Literal strings are always the same
		//one string instance is created on the heap, s1 and s2 and a pointer from the String Literal Pool point to the object
		String s1 = "cat";
		String s2 = "cat";
		System.out.println("s1 == s2   " + (s1 == s2)); // true 
		
				
		// Strings computed by constant expressions are computed at compile time
		// and then treated as if they are literals.
		// For ex, the following will return true:
		String str = "Hello";
		System.out.println(str == "Hel" + "lo"); // true
		
		
		// Strings computed at runtime are newly created and therefore distinct.
		// The following will return false:
		String a = "Hel", b = "lo";
		System.out.println(a + b == a + b); // false
		
		
		//Dynamically created strings are distinct
		//Two distinct objects are created on the heap
		String t1 = new String("cat");
		String t2 = new String("cat");
		System.out.println("t1 == t2   " + (t1 == t2)); // false
		
	}
}
