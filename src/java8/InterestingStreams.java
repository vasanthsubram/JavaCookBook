package java8;

import java.util.Random;
import java.util.stream.IntStream;

public class InterestingStreams {

		public static void main(String[] args) {
			//never finishes
//			new Random().ints().forEach(System.out::println);
			
			
			IntStream.range(1, 10).forEach(System.out::println);
		}
}
