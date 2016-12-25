package lambda.function.predicate;

import java.util.Objects;
import java.util.function.Predicate;

public class Predicates {

	public static void main(String[] args) {
		Predicate<String> predicate = (s) -> s.length() > 0;

		System.out.println(predicate.test("foo"));              // true
		System.out.println(predicate.negate().test("foo"));     // false

		Predicate<Boolean> nonNull = Objects::nonNull;
		System.out.println(nonNull.test(null));
		
		Predicate<Boolean> isNull = Objects::isNull;

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();
		
		//predicate chaining
		Predicate<Integer> greaterThanTen = (i) -> i > 10;
		Predicate<Integer> lowerThanTwenty = (i) -> i < 20;

		// Will print true
		System.out.println(greaterThanTen.and(lowerThanTwenty).test(15));

		// Will print false
		System.out.println(greaterThanTen.and(lowerThanTwenty).negate().test(15));
		
		
		//passing predicate to functions
		// Will print "Number 10 was accepted!"
		process(10, (i) -> i > 7);
		
	}
	
	static void process(int number, Predicate<Integer> predicate) {
		  if (predicate.test(number)) {
		    System.out.println("Number " + number + " was accepted!");
		  }
		}
}
