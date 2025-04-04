package core.thread;

import java.util.LinkedList;

/*
You are required to implement a Producer-Consumer system using Java threads where:

The Producer thread generates numbers from 1 to 10 and puts them in a shared buffer
(a Queue<Integer> with a maximum size of 5).

The Consumer thread removes numbers from the buffer and prints them.

The buffer should never overflow (Producer must wait() when the buffer is full).

The buffer should never be empty (Consumer must wait() when the buffer is empty).

Use synchronized methods, wait(), and notify() for thread coordination.
 */
public class NotifyWaitExample {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int MAX_SIZE = 5;

        Thread p = new Thread(new Producer(linkedList, MAX_SIZE));
        Thread c = new Thread(new Consumer(linkedList, MAX_SIZE));
        p.start();
        c.start();
    }
}

 class Producer implements Runnable {
    private LinkedList<Integer> linkedList;
     private int MAX_SIZE;
    public Producer(LinkedList<Integer> linkedList, int size) {
        this.linkedList = linkedList;
        MAX_SIZE = size;
    }
     @Override
     public void run() {
        for(int i=1;i<=10;i++) {
            synchronized (linkedList) {
                while (linkedList.size() >= MAX_SIZE) {
                    try {
                        linkedList.wait();

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                linkedList.add(i);
                System.out.println("Added " + i);
                linkedList.notifyAll();
            }
        }
     }
 }

class Consumer implements Runnable {
    private LinkedList<Integer> linkedList;
    private int MAX_SIZE;
    public Consumer(LinkedList<Integer> linkedList, int size) {
        this.linkedList = linkedList;
        MAX_SIZE = size;
    }
    @Override
    public void run() {
        for(int i=1;i<=10;i++) {
            synchronized (linkedList) {
                while (linkedList.size() == 0) {
                    try {
                        linkedList.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println("Removed " + linkedList.remove());
                linkedList.notifyAll();
            }
        }
    }
}