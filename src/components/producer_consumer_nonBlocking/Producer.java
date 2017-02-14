package components.producer_consumer_nonBlocking;

import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {

    private static int ctr;
    private final Queue<Message> messageQueue;

    public Producer(Queue<Message> messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            produce();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void produce() {
        Message m = new Message(++ctr, "Example message.");
        messageQueue.offer(m);
        synchronized (messageQueue) {
            messageQueue.notifyAll();
        }
        System.out.println("Producer: " +Thread.currentThread().getId() +" "+ m);
    }
}
