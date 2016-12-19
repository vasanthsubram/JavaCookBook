package java8.streams.create;

import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by vasanth on 12/18/16.
 */
public class FromString {

    public static void main(String args[]){
        //from String - creates an int stream
        "abc".chars().forEach(System.out::println);


        //breaks a String into sub-strings according to specified RegEx:
        Stream<String> stream =
                Pattern.compile(", ").splitAsStream("a, b, c");

        stream.forEach(System.out::println);

    }
}
