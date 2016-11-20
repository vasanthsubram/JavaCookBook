package core.numbers.floatingpoints;

import java.math.BigDecimal;

public class FloatingPointIsNotPrecise {

	public static void main(String[] args) {
		//WRONG
		System.out.println(2.00 - 1.10);	//prints 0.8999999999999999
		
		
		//CORRECT
		System.out.println((200 - 110) + " cents");
			//use the BigDecimal(String) constructor, never BigDecimal(double)
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
                

		//adding float and integer
		  float f = 33554432.0f;
		    
		    System.out.println("adding float and integer");
		    System.out.println("f =	" + f);
		    System.out.println("f+1 =	" + (f+1));
		    System.out.println(f==(f+1));
		    
		    System.out.println();
		    System.out.println("adding float and float");
		    System.out.println("f =	" + f);
		    System.out.println("f+1.0 =	" + (f+1.0));
		    System.out.println(f==(f+1.0));
	
	}



}
