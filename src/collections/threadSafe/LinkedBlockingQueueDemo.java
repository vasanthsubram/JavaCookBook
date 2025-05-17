package collections.threadSafe;
import java.util.concurrent.*;

public class LinkedBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(3);

        // Producer
        new Thread(() -> {
            try {
                queue.put("A");
                System.out.println("Put A");
                queue.put("B");
                System.out.println("Put B");
                queue.put("C");
                System.out.println("Put C");
                // Blocks until a take() is called
                queue.put("D");
                System.out.println("Put D");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Consumer
        new Thread(() -> {
            try {
                System.out.println("Took: " + queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
