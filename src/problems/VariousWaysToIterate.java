package problems;

import java.util.*;

public class VariousWaysToIterate {
    public static void main(String[] args) {
        // Example Collection: List
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");

        // Example Map
        Map<String, Integer> fruitPrices = new HashMap<>();
        fruitPrices.put("Apple", 100);
        fruitPrices.put("Banana", 60);
        fruitPrices.put("Cherry", 150);

        // --- Iterating Collections (List, Set, etc.) ---

        System.out.println("1. For-each loop:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        System.out.println("\n2. Iterator:");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\n3. forEach with lambda:");
        fruits.forEach(fruit -> System.out.println(fruit));

        System.out.println("\n4. forEach with method reference:");
        fruits.forEach(System.out::println);

        System.out.println("\n5. Traditional for loop (List only):");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }

        // --- Iterating Maps ---

        System.out.println("\n6. Iterating over entrySet:");
        for (Map.Entry<String, Integer> entry : fruitPrices.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("\n7. Iterating over keySet:");
        for (String key : fruitPrices.keySet()) {
            System.out.println(key + " = " + fruitPrices.get(key));
        }

        System.out.println("\n8. Iterating over values:");
        for (Integer value : fruitPrices.values()) {
            System.out.println("Price: " + value);
        }

        System.out.println("\n9. forEach with lambda (Map):");
        fruitPrices.forEach((key, value) -> System.out.println(key + " = " + value));

        System.out.println("\n10. Using iterator on entrySet:");
        Iterator<Map.Entry<String, Integer>> mapIterator = fruitPrices.entrySet().iterator();
        while (mapIterator.hasNext()) {
            Map.Entry<String, Integer> entry = mapIterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println("\n11. Sorted iteration using TreeMap:");
        Map<String, Integer> sortedMap = new TreeMap<>(fruitPrices);  // Sorted by keys
        sortedMap.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}
