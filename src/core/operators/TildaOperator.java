package core.operators;

public class TildaOperator {
	public static void main(String[] args) {
		
		//using the 
		int x = 100;
		x = - (~x); // increment
		System.out.println(x);
		
		int y=100;
		y=~(-y);	//decrement
		System.out.println(y);

	}

}
