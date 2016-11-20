package interview_questions;

public class Java2 {

	public static void main(String[] args) {
		
		String x = "Hello";
		String y = x;
		System.out.println(x);
		System.out.println(y);
		System.out.println(x==y);
		
		x = x + " World";
		
		System.out.println(x);
		System.out.println(y);
		System.out.println(x==y);
	}
	
}
