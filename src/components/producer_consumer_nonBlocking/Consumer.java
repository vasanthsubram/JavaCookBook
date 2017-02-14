package components.producer_consumer_nonBlocking;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable {

    private final Queue<Message> queue;

    public Consumer(Queue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            consume();
            try {
                synchronized (queue) {
                    queue.wait();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void consume() {
        while (!queue.isEmpty()) {
            Message m = queue.poll();
            if (m != null) {
                System.out.println("Consumer: " +Thread.currentThread().getId() +" " + m.toString());
            }
        }
    }
}
