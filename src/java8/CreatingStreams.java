package java8;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreatingStreams {

	public static void main(String[] args) throws IOException {
		
		//From Stream
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4);
		numbers.forEach(System.out::println);
		
		Stream.of("A,B,C".split(",")).forEach(System.out::println);
		Stream.of(new String[]{"A1", "B1"}).forEach(System.out::println);
		
		//Stream.generate()
		//Returns an infinite sequential unordered stream 
		Stream.generate(() -> {return new Date();}).limit(2).forEach(System.out::println);
		
		//Use Stream.iterate()
		Stream<Integer> intStream = Stream.iterate(0, n -> n+1).limit(10);
		Integer[] intArr = intStream.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArr));
		
		
		//from String - creates an int stream
		"abc".chars().forEach(System.out::println);

		//From List
		List<String> list= new ArrayList<String>();
		list.add("Hello");
		list.add("world");
		list.stream().forEach(System.out::println);
		
		
		//From Arrays
		int[] numArr = {10, 20, 30, 40};
		IntStream numbersFromArray = Arrays.stream(numArr);
		numbersFromArray.forEach(System.out::println);
		
		
		//stream from a file
		long numberOfLines = Files.lines(Paths.get("src/java8/Streams.java"), Charset.defaultCharset()).count();
		System.out.println("Number of lines in this file = " + numberOfLines);
		
	}
}
