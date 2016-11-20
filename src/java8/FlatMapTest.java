package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapTest {

	public static void main(String[] args) {
		
		String[]  words={"hello", "world"};
		List<String> list = Stream.of(words)
		.map(w -> w.split(""))
		.flatMap(Arrays::stream)
		.distinct()
		.collect(Collectors.toList());
		
		System.out.println(list);
	}
}
