package java8;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;


public class OptionalTest {

	public static void main(String[] args) {

			Optional<String> opt = Optional.empty();
			try{
				System.out.println(opt.get());
			} catch(NoSuchElementException e){
				System.out.println("Exception: no value");
			}
			
			opt=Optional.of("Hello");
			opt.ifPresent(System.out::println);


			//ifPresent
			Stream.of("a1", "a2", "a3")
			.findFirst()
			.ifPresent(System.out::println); // a1
			
			Stream.of()
			.findFirst()
			.ifPresent(System.out::println);	//nothing
	}
}
