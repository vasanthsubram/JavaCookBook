package core.operators;

public class XOROperator {

	public static void main(String[] args) {

		//boolean
		System.out.println(true ^ true);
		System.out.println(true ^ false);
		System.out.println(false ^ true);
		System.out.println(false ^ false);
				
		//integer
		System.out.println("\nXOR-ing self, gives zero");
		System.out.println(4 ^ 4);
		
		System.out.println("\nXOR-ing zero, gives self");
		System.out.println(4 ^ 0);
		
		System.out.println("\nXOR-ing twice gets the initial value");
		System.out.println(127 ^ (489 ^ 127));
		
		
		System.out.println("\nSwapping two variables using XOR");
		int a2 = 45, b2 = 67;
		System.out.println("a2 = "+ a2 + " b2 =" + b2);
		a2 = a2 ^ b2;
		b2 = b2 ^ a2;	// b2 = b2 ^(a2 ^ b2)
		a2 = a2 ^ b2;	//a2 = (a2 ^ b2) ^(b2 ^(a2 ^ b2))
		System.out.println("a2 = "+ a2 + " b2 =" + b2);
		
		System.out.println("\nSwapping three variables using XOR");
		int x1 = 45, x2 = 67, x3=100;
		System.out.println("x1 = "+ x1 + " x2 =" + x2 + " x3 =" + x3);
		x1 = x1 ^ x2 ^ x3 ^ x1 ^ x2 ^ x3;
		System.out.println(x1);
		
		
		
	}
}
