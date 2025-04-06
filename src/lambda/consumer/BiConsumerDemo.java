package lambda.consumer;

import java.util.HashMap;

//Consumers represents operations to be performed on a two input arguments.
public class BiConsumerDemo {
    public static void main(String[] args) {

        HashMap<String, String> hash = new HashMap<>();
        hash.put("cat", "orange");
        hash.put("dog", "black");
        hash.put("snake", "green");
        // Use collection_lambda.collection.lambda expression that matches BiConsumer to display HashMap.
        hash.forEach((string1, string2) -> System.out.println(string1 + "..." + string2));
    }
}
