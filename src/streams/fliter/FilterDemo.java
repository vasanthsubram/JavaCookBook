package streams.fliter;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class FilterDemo {
    public static void main(String[] args) {

        int[] array = { 10, 20, 30, 40, 50, 60 };
        // Convert array to Stream.
        IntStream stream = Arrays.stream(array);

        // Filter outvalues less than 40.
        OptionalInt result = stream.filter(value -> value >= 40).findFirst();
        // If a result is present, display it as an int.
        if (result.isPresent()) {
            // This is the first value returned by the filter.
            System.out.println(result.getAsInt());
        }
    }
}
