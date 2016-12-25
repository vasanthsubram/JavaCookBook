package streams.create;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitivesStreams {

		public static void main(String[] args) {

			IntStream.range(1, 10).forEach(System.out::println);

			IntStream.range(1, 3).forEach(System.out::println);

			LongStream.rangeClosed(100, 103).forEach(System.out::println);

			new Random().ints().limit(5).forEach(System.out::println);

		}
}
