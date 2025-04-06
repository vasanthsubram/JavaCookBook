package core.flowcontrol;

import java.util.Iterator;
import java.util.List;

//various ways of iterating collections

public class Loops {
    public static void main(String[] args) {

        int[] arr = {4,5,6};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();

        //---------enhanced for loop - works with arrays and Iterables
        System.out.println("enhanced for loop....");
        for (int e : arr) {
            System.out.println(e);
        }
        System.out.println();

        // --- enhanced loop of Collection
        List<String> names = List.of("NewYork", "Seattle", "LosAngeles");
        System.out.println("enhanced for loop....");
        for (String name : names) {
            if (name.equals("Seattle")) continue;
            System.out.println(name);
        }

        System.out.println();

        //--------iterator
        Iterator<String> iterator = names.listIterator();
        System.out.println("Iterator....");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();

        //----- forEach method to loop
        System.out.println("forEach method");
        names.forEach(name-> {
            //does not allow continue/break
//            if (name.equals("Seattle")) continue;
            System.out.println(name);
        });
    }
}
