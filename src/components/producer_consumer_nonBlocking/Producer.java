package components.producer_consumer_nonBlocking;

import java.util.Queue;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {

    private static int ctr;
    private final Queue<Message> messageQueue;
    private final Random r;

    public Producer(Queue<Message> messageQueue) {
        this.messageQueue = messageQueue;
        r = new Random();
    }

    @Override
    public void run() {
        while (true) {
            produce();
            int wait = r.nextInt(5000);
            try {
                Thread.sleep(wait);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
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
