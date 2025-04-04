package core.thread.locks;

import java.util.concurrent.locks.ReentrantLock;

public class SimpleTryLockExample {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> attemptLock("Thread-1")); //Java implicitly creates an instance of Runnable.
        Thread t2 = new Thread(() -> attemptLock("Thread-2"));

        t1.start();
        t2.start();
    }

    static void attemptLock(String threadName) {
        if (lock.tryLock()) {  // Try to acquire the lock without waiting
            try {
                System.out.println(threadName + " acquired the lock.");
                Thread.sleep(2000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // Release the lock
                System.out.println(threadName + " released the lock.");
            }
        } else {
            System.out.println(threadName + " could not acquire the lock, moving on...");
        }
    }
}
