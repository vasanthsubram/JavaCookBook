package core.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Java9CollectionFeatures {
    public static void main(String[] args) {

        //Of() creates an immutable collection
        List list = List.of(1,2,3);
        //list.clear(); //fails

        System.out.println(List.of(1,2,3));
        System.out.println(Set.of(3,4,5));

        System.out.println(Map.of(1,3, 2,4));
        System.out.println(Map.of(1,"New York", 2,"Seattle"));

    }
}
