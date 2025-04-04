package core.thread.threadpools;
import java.util.concurrent.*;

//The thread blocks — enters TIMED_WAITING state.
//That thread cannot be reused for other tasks during sleep.
//So, while a task is sleeping, the pool can’t assign it new work.

public class ThreadReuseInThreadPools {
    public static void main(String[] args) {
        int numWorkers = 4;
        int threadPoolSize = 2;
        
        ExecutorService tpes = Executors.newFixedThreadPool(threadPoolSize);
        for (int i = 0; i < numWorkers; i++) {
            tpes.execute(new WorkerThread(i));
        }
        tpes.shutdown();
    }
}

class WorkerThread implements Runnable {
    private int workerNumber;

    WorkerThread(int number) {
        workerNumber = number;
    }

    public void run() {
        for (int i=0;i<=100;i+=50) {
            //Perform some work ...
            System.out.format("Worker number: %d, Thread id: %d, percent complete: %d %n",
                workerNumber, Thread.currentThread().getId(), i);
                try {
                    Thread.sleep((int)(Math.random() * 1000));
                } catch (InterruptedException e) {
            }
        }
    }
}


