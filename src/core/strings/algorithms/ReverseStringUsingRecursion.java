package core.strings.algorithms;

public class ReverseStringUsingRecursion {

	public static void main(String[] args) {

		String x = "Hell World";
		
		System.out.println("\nReverse of  " + x + " is \n" + reverse(x) );

	}

	public static String reverse(String s) {
		int N = s.length();
	    if (N <= 1) {
	    	System.out.println(s);
	    	return s;
	    }
	    System.out.println(s);
	    String a = s.substring(0, N/2);
	    String b = s.substring(N/2, N);
	    return reverse(b) + reverse(a);
	}
}
