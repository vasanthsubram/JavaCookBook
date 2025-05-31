package _Important;

import java.util.*;

public class DifferentWaysToIterateCollections {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        //For Loop
        // iterate over collections like List or arrays.
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println();


        //Enhanced For Loop
        //Works with any Iterable (e.g., List, Set). Does not work with Maps or Arrays
        for (String item : list) {
            System.out.println(item);
        }

        System.out.println();


        //------------------Iterable----------------------


        Set set = new HashSet();
        set.iterator();
        //iterator
        //Useful for Set or when you need to remove elements
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
            // Example: Remove item
            if (item.equals("B")) {
                iterator.remove();
            }
        }

        System.out.println();

        //List iterator (for lists only)
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String item = listIterator.next();
            System.out.println(item);
            if (item.equals("C")) {
                listIterator.set("X"); // Replace C with X
            }
        }

        System.out.println();

        //forEach Method (Java 8+)
        //Works with any Iterable (e.g., List, Set). Does not work with Maps
        list.forEach(item -> System.out.println(item));
        // Or with method reference
        list.forEach(System.out::println);

        System.out.println();

        //Stream API
        list.stream()
                .filter(item -> !item.equals("B"))
                .forEach(System.out::println);


        //---------------------Maps

        //Maps (HashMap, TreeMap, etc.) require special handling since they store key-value pairs. Common approaches:

        //Using entrySet() (Recommended)
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }


        //Using keySet()
        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }


        //Using values()
        for (String value : map.values()) {
            System.out.println("Value: " + value);
        }


        //Using forEach (Java 8+)
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        System.out.println();


        //while loop
        int i = 0;
        while (i < list.size()) {
            System.out.println(list.get(i));
            i++;
        }

    }
}
