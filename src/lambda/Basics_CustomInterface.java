package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class Basics_CustomInterface {
    public static void main(String[] args) {
        CollectionClearer<Integer> clearer = collection -> {
            int previousSize = collection.size();
            collection.clear();
            return previousSize;
        };
        List list = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(clearer.clearAndGetPreviousSize(list));
    }

    @FunctionalInterface
    public interface CollectionClearer<T> {
        int clearAndGetPreviousSize(Collection<T> collection);
    }


}
