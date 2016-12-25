package lambda.function.predicate;

import java.util.ArrayList;

/**
 * Created by vasanthakumarsubramanian on 12/24/16.
 */
public class PredicateWithCollection {

    public static void main(String[] args) {

        // Create ArrayList and add four String elements.
        ArrayList<String> list = new ArrayList<>();
        list.add("cat");
        list.add("dog");
        list.add("cheetah");
        list.add("deer");

        // Remove elements that start with c.
        list.removeIf(element -> element.startsWith("c"));
        System.out.println(list.toString());
    }
}
