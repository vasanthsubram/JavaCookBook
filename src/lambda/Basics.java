package lambda;

import hibernate.general.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Basics {
    public static void main(String[] args) {

        //Runnable - takes no arguments and returns nothing
        Runnable r = () -> {
            System.out.println("Hello World");
        };
        r.run();

        //Supplier - take no arg; return value
        Supplier<Integer> supplier = () -> 42;
        System.out.println(supplier.get());

        //Consumer - takes argument; return nothing
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());
        printUpperCase.accept("hello");

        //BiFunction - takes two arguments and returns a value
        BiFunction<Integer, Integer, Integer> function =  (Integer x, Integer y) -> x + y;
        System.out.println(function.apply(5,10));


        //non standard interface
        //look at Basics_CustomInterface
    }


}
