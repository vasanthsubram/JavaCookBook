package collections.Collections;

import java.util.ArrayList;

/**
 *
 * @author vsubramanian
 */
public class SubListDemo {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");

        System.out.println(list.subList(0, 1).get(0));
         System.out.println(list.subList(1, list.size()).get(0));
    }
}
