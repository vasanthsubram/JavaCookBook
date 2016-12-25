package streams;

import java.io.File;
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

		//list files and directories and files in the subdirectory
		Stream<File> fileStream = Stream.of(new File("./src/lambda/").listFiles());
		fileStream.flatMap(file -> file.listFiles() == null ? Stream.of(file) : Stream.of(file.listFiles()))
				.forEach(System.out::println);
	}
}
