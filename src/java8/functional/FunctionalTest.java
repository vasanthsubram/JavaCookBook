package java8.functional;

public class FunctionalTest {

		public static void main(String[] args) {
			Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
			Integer converted = converter.convert("123");
			System.out.println(converted);    // 123
			
			Converter<String, Integer> converter2 = Integer::valueOf;
			Integer converted2 = converter2.convert("456");
			System.out.println(converted2);   // 456
			
		}
}
