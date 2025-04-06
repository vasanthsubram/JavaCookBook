package core.anonymous;

import java.util.*;

public class AnonymousDemo {
    public static void main(String[] args) {
        //combine the process of definition and instantiation into a single step.
        // //compiler assigns a name
        //a reference to the anonymous class cannot be declared, the functionality of the class is only available through superclass references.
        List<String> list = new ArrayList<>() {
            {
                add("Hello");
                add("World");
            }
        };

        list.forEach(System.out::println);
        //compiler assigns a name
        System.out.println(list.getClass().getName());
    }
}
