package collections.threadSafe;

import java.util.concurrent.*;

public class ConcurrentHashMapExample {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, Integer> wordCount = new ConcurrentHashMap<>();

        String[] words = {
                "apple", "banana", "apple", "orange", "banana", "apple"
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String word : words) {
            executor.submit(() -> {
                // Atomically update count using merge (Java 8+)
                wordCount.merge(word, 1, Integer::sum);
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.SECONDS);

        // Print word frequencies
        wordCount.forEach((word, count) ->
                System.out.println(word + " : " + count));
    }
}
