package lambda.custom;

import java.util.function.Function;

public class FunctionalTest {

		public static void main(String[] args) {
			Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
			Integer converted = converter.convert("123");
			System.out.println(converted);    // 123
			
			Converter<String, Integer> converter2 = Integer::valueOf;
			Integer converted2 = converter2.convert("456");
			System.out.println(converted2);   // 456

			//instead you can use the built-in Function
			Function<String, Integer> converter3= from -> Integer.valueOf(from);
			Integer year = converter3.apply("1776");
			System.out.println(year);
		}
}

@FunctionalInterface
interface Converter<F, T> {
	T convert(F from);
}