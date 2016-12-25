package streams;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by vasanth on 12/19/16.
 */
public class StreamToCollection {
    public static void main(String args[]){
        Set<Integer> collected = Stream.of(1,2,3,4,5).collect(Collectors.toSet());
        collected.forEach(System.out::println);
    }
}
