package lambda.function;

import java.util.function.Function;

public class FunctionExample {

		public static void main(String[] args) {
			//Represents a function that accepts one argument and produces a result.
			Function<Integer, Integer> func = x -> x * 2;

			// Apply the function to an argument of 10.
			int result = func.apply(10);
			System.out.println(result);
			
		}
}
