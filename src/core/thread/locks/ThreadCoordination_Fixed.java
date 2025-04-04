package core.thread.locks;

public class ThreadCoordination_Fixed {

    static final Object lock = new Object();
    static boolean workDone = false;  // Shared condition

    public static void main(String[] args) {

        Runnable r1 = () -> {
            synchronized (lock) {
                try {
                    System.out.println("t1: going to do some work");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("t1: I am done");
                workDone = true;
                lock.notifyAll();
            }
        };

        Runnable r2 = () -> {
            synchronized (lock) {
                while (!workDone) {
                    try {
                        System.out.println("t2:  Going to wait for Thread t1....");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2:  Done waiting....");
            }
        };

        new Thread(r2).start(); // Start t2 first to ensure it starts waiting
        new Thread(r1).start(); // Then start t1
    }
}
