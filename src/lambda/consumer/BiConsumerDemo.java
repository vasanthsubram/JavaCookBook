package lambda.consumer;

import java.util.HashMap;

/**
 * Created by vasanthakumarsubramanian on 12/25/16.
 */
public class BiConsumerDemo {
    public static void main(String[] args) {

        HashMap<String, String> hash = new HashMap<>();
        hash.put("cat", "orange");
        hash.put("dog", "black");
        hash.put("snake", "green");
        // Use lambda expression that matches BiConsumer to display HashMap.
        hash.forEach((string1, string2) -> System.out.println(string1 + "..." + string2 + ", " + string1.length()));
    }
}
