package java8.streams.pipeline;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by vasanth on 12/19/16.
 */
public class ReduceTest {

    public static void main(String[] args) {
        List<String> countries = Arrays.asList("Germany", "England", "China",
                "Denmark", "Brazil", "France", "Australia");

        Optional<String> longestCountryName = countries.stream().reduce(
                (c1, c2) -> c1.length() > c2.length() ? c1 : c2);

        longestCountryName.ifPresent(System.out::println);


        // sum of numbers
        final List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        int sum = numbers.stream().reduce(0,(num1,num2) -> num1+num2);
        System.out.println("Sum is " + sum);
    }

}
