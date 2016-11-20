package others.puzzler;

public class IsOdd {
	public static void main(String[] args) {
		
		System.out.println(isOdd_1(10));
		System.out.println(isOdd_1(9));
		System.out.println(isOdd_1(-10));
		System.out.println(isOdd_1(-9));
		System.out.println();
		
		System.out.println(isOdd_2(10));
		System.out.println(isOdd_2(9));
		System.out.println(isOdd_2(-10));
		System.out.println(isOdd_2(-9));
		System.out.println();
		
		System.out.println(isOdd_3(10));
		System.out.println(isOdd_3(9));
		System.out.println(isOdd_3(-10));
		System.out.println(isOdd_3(-9));
		
	}

	// fails if the input is negative odd integers
	private static boolean isOdd_1(int x){
		return ((x%2)==1);
	}
	
	//succeeds in both positive and negative integers
	private static boolean isOdd_2(int x){
		return ((x%2)!= 0);
	}
	
	//faster and succeeds in both positive and negative integers
	private static boolean isOdd_3(int x){
		return ((x&1)!= 0);
	}
}
