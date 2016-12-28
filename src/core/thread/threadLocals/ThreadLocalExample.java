package core.thread.threadLocals;

public class ThreadLocalExample {

/*
 * This example creates a single MyRunnable instance which is passed to two different threads.
 *
 * For non-thread local variable y, the second thread overrides the value set by the first thread.
 * However, since x it is a ThreadLocal object, the two threads cannot see each other's value, they set and get different values.
 *
 */
    public static class MyRunnable implements Runnable {
        private ThreadLocal<Double> x = new ThreadLocal<>();
        private double y;

        @Override
        public void run() {
            synchronized (this) {
                double d=Math.random();
                x.set(d);
                y=d;
             }
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread id = " + Thread.currentThread().getId() +
                                        "   x = "  +  x.get() +
                                        "   y = " + y);
        }
    }

    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        new Thread(sharedRunnableInstance).start();
        new Thread(sharedRunnableInstance).start();
    }
}