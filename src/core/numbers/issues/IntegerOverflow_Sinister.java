package core.numbers.issues;

public class IntegerOverflow_Sinister {
	public static void main(String args[]) {
		/*
		Even though the long variable is big enough to hold the result,
		 because the computation is all performed in int, the value overflows
		 even before the result of the computation is assigned to the variable
		*/
	   //INCORRECT
		final long MICROS_PER_DAY_1= 24*60*60*1000*1000; 
		System.out.println(MICROS_PER_DAY_1);

		//CORRECT
		final long MICROS_PER_DAY_2= 24L*60*60*1000*1000;
		System.out.println(MICROS_PER_DAY_2);
	}

}
