package java8;

import java.util.function.Function;

public class FunctionExamples {

		public static void main(String[] args) {
			//Functions also represent a single argument function but they return a result of an arbitrary type:
			Function<String, Integer> stringLength = (s) -> s.length();

			// Will print 11
			System.out.println(stringLength.apply("Hello world"));
			
			
			//function chaining example
			Function<Integer, Boolean> greaterThanFive = (i) -> i > 5;

			// Will print true
			System.out.println(stringLength.andThen(greaterThanFive).apply("Hello world"));
			
			
			//function chaining example
			Function<Integer, Boolean> lowerThanTen = (i) -> i < 10;
			Function<String, Boolean> function = stringLength.andThen(lowerThanTen);

			// Will print false
			System.out.println(function.apply("Hello world"));
			
		}
}
