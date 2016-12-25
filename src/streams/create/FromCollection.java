package streams.create;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by vasanth on 12/18/16.
 */
public class FromCollection {

    public static void main(String args[]){
        //Stream can also be created of any type of Collection (Collection, List, Set):

        //From List
        List<String> list= new ArrayList<String>();
        list.add("Hello");
        list.add("world");
        list.stream().forEach(System.out::println);


        //From Arrays
        int[] numArr = {10, 20, 30, 40};
        IntStream numbersFromArray = Arrays.stream(numArr);
        numbersFromArray.forEach(System.out::println);
    }
}
