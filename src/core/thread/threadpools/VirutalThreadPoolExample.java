package core.thread.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirutalThreadPoolExample {

    public static void main(String[] args) {
        // Create an ExecutorService where each task gets its own virtual thread
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            // Submit multiple tasks
            for (int i = 1; i <= 10; i++) {
                int taskId = i;
                executor.submit(() -> {
                    System.out.println("Task " + taskId + " running in " + Thread.currentThread());
                });
            }

        } // automatically calls shutdown() at the end of try-with-resources block
    }
}
