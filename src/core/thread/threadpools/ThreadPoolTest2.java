package core.thread.threadpools;
import java.util.concurrent.*;

public class ThreadPoolTest2 {
    public static void main(String[] args) {
        int numWorkers = 3;

        ExecutorService tpes = Executors.newCachedThreadPool();
        CallableWorkerThread workers[]  = new CallableWorkerThread[numWorkers];
        Future futures[] = new Future[numWorkers];
                
        for (int i = 0; i < numWorkers; i++) {
            workers[i] = new CallableWorkerThread(i);
            futures[i]=tpes.submit(workers[i]);
        }
        for (int i = 0; i < numWorkers; i++) {
            try {
                System.out.format("Ending worker: %d%n", futures[i].get());
            } catch (Exception e) {}
        }
        tpes.shutdown();
    }
}

 class CallableWorkerThread implements Callable<Integer> {
    private int workerNumber;

    CallableWorkerThread(int number) {
        workerNumber = number;
    }

    public Integer call() {
        for (int i = 0; i <= 100; i += 50) {
            //Perform some work...
            System.out.format("Worker number: %d, Thread id: %d, percent complete: %d%n",
                workerNumber, Thread.currentThread().getId(),i);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {}
        }
        return(workerNumber);
    }
}
