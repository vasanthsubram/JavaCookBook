package java8;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) {

		List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList.stream()
				.filter(s -> s.startsWith("c"))
				.map(String::toUpperCase)
				.sorted()
				.forEach(System.out::println);
		
		//creates only a sorted view of the stream without manipulating the backed collection
		System.out.println(myList);

		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> twoEvenSquares = 
		    numbers.stream()
		           .filter(n -> { return n % 2 == 0;})
		           .map(n -> {return n * n;})
		           .limit(2)
		           .collect(Collectors.toList());
		System.out.println(twoEvenSquares);
		
		
		
		List<String> words = Arrays.asList("Oracle", "Java", "Magazine");
		 List<Integer> wordLengths = 
		    words.stream()
		         .map(String::length)
		         .collect(Collectors.toList());
		 System.out.println(wordLengths);
		 
		
		int totalCount = words.stream().collect(Collectors.summingInt(String::length));
		System.out.println(totalCount);
		 
		
		int totalLength = 
		    words.stream()
		         .mapToInt(String::length)
		         .sum();
		 System.out.println("total length = " + totalLength);
	
		
	}
}
