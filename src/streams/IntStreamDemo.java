package streams;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by vasanthakumarsubramanian on 12/25/16.
 */
public class IntStreamDemo {

    public static void main(String args[]){
        int[] array = { 1, 2, 3 };
        IntStream s = Arrays.stream(array);
        int sum = s.reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
