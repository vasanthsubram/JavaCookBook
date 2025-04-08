package streams.create;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) throws IOException {

		//empty stream
		Stream s = Stream.empty();

		//Its often the case that the empty() method is used upon creation
		// to avoid returning null for streams with no element:
//		public Stream<String> streamOf(List<String> list) {
//			return list == null || list.isEmpty() ? Stream.empty()
//		}

		//From Stream
		Stream.of(1, 2, 3, 4).forEach(System.out::println);
		Stream.of("A,B,C".split(",")).forEach(System.out::println);
		Stream.of(new String[]{"A1", "B1"}).forEach(System.out::println);

		IntStream integerStream = IntStream.of(1, 2, 3, 4);
//		System.out.println("greater than 2 " + integerStream.filter(v->v>2).collect();


		//Stream.builder()
		//When builder is used the desired type should be additionally specified in the right part of the statement,
		// //otherwise the build() method will create an instance of the Stream<Object>:
		Stream<String> stream =
				Stream.<String>builder().add("a").add("b").add("c").build();
		System.out.println("Stream builder");
		stream.forEach(System.out::println);


		//Stream.generate()
		//The generate() method accepts a Supplier<T> for element generation.
		//Returns an infinite sequential unordered stream
		Stream.generate(() -> {return new Date();}).limit(2).forEach(System.out::println);


		//Use Stream.iterate()
		Stream<Integer> intStream = Stream.iterate(0, n -> n+1).limit(10);
		Integer[] intArr = intStream.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArr));


		Map<String, Integer> map = new HashMap<>();
		map.put("Apple", 3);
		map.put("Banana", 2);
		map.put("Orange", 5);



	}
}
