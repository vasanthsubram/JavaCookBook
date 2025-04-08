package lambda;

import java.util.function.BiFunction;
import java.util.*;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;

public class LambdaExcercise {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sum = (x, y) -> x +y;
        System.out.println(sum.apply(5,10));

        Predicate<String> isEmpty = s -> s==null || s.length()==0;
        System.out.println(isEmpty.test("Hello"));

        LongUnaryOperator factorial = x -> {
            int product=1;
            for (int i=1;i <= x; i++){
                product = product * i;
            }
            return product;
        };
        System.out.println(factorial.applyAsLong(5));


        // Create a list of strings
        List<String> stringList = Arrays.asList("Red", "Green", "Blue", "PINK");

        stringList.replaceAll(e -> e.toUpperCase());
        System.out.println(stringList);

        List<Integer> integerList =  new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        integerList.removeIf(e -> e %2 ==0);
        System.out.println(integerList);

    }
}
