package core.numbers;

public class ParanthesisProblem {
	public static void main(String[] args) {
		//// this gives a compile error; as  2147483648 is out of range for int
		//to fix this remove the paranthesis
		//int a = -(2147483648);
		
		int i = (Integer.MIN_VALUE); 
			System.out.println(i);
			
		int j= -(Integer.MIN_VALUE);
		System.out.println(j);
		
		System.out.println(-(-5));
		
		System.out.println(Integer.MAX_VALUE+Integer.MIN_VALUE);
	}

}
