package components.producer_consumer_nonBlocking;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadedQueueExample {

    public static void main(String[] args) {

        Queue<Message> queue = new ConcurrentLinkedQueue<Message>();

        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}


