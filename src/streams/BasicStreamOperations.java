package streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//        Java Stream API - Common Operations Cheat Sheet
public class BasicStreamOperations {

    public static void main(String[] args) {

        System.out.println("map - transform each element");
        List<String> names = List.of("alice", "bob");
        List<String> upper = names.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(upper);


        System.out.println("filter() – Keep only elements that match a condition");
        List<Integer> evens = List.of(1, 2, 3, 4).stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(evens);


        System.out.println("distinct() – Remove duplicates");
        List<Integer> unique = List.of(1, 2, 2, 3).stream()
                .distinct()
                .toList();
        System.out.println(evens);


        System.out.println("sorted() – Sort elements");
        List<String> sorted = List.of("banana", "apple").stream()
                .sorted()
                .toList();
        System.out.println(sorted);

        System.out.println("sorted() – Sort elements - With length comparator");
        List<String> sortedByLength = List.of("aa", "b", "ccc").stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        System.out.println(sortedByLength);


        System.out.println("limit() / skip() – Truncate or skip elements");
        List<Integer> firstTwo = List.of(1, 2, 3, 4).stream()
                .limit(2)
                .toList();

        List<Integer> skipTwo = List.of(1, 2, 3, 4).stream()
                .skip(2)
                .toList();

        System.out.println("peek() – Debug or perform side-effects (use cautiously)");
        List<String> result = List.of("a", "b").stream()
                .peek(System.out::println)
                .map(String::toUpperCase)
                .toList();
        System.out.println(result);

        System.out.println("flatMap() – Flatten nested collections");
        List<List<String>> nested = List.of(List.of("a", "b"), List.of("c"));
        List<String> flat = nested.stream()
                .flatMap(List::stream)
                .toList();
        System.out.println(nested);

        System.out.println("collect() – Collect results (e.g., into list, map)");
        List<String> collected = List.of("x", "y").stream().collect(Collectors.toList());
        System.out.println(collected);

        System.out.println("count() – Count elements");
        long count = List.of(1, 2, 3).stream()
                .filter(n -> n > 1)
                .count();
        System.out.println(count);

        System.out.println("anyMatch(), allMatch(), noneMatch() – Check conditions");
        boolean anyEven = List.of(1, 2, 3).stream().anyMatch(n -> n % 2 == 0);
        boolean allPositive = List.of(1, 2).stream().allMatch(n -> n > 0);

        System.out.println(anyEven);
        System.out.println(allPositive);


        System.out.println("reduce() – Aggregate elements");
        int sum = List.of(1, 2, 3).stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);  //6

        System.out.println("forEach() – Terminal operation for side-effects");
        List.of("a", "b").stream()
                .forEach(System.out::println);
    }
}
