package core.thread.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// using virtual thread, the sleep does not block the thread
//when the sleep is called
public class ThreadReuseInVirtualThreadPool {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 4; i++) {
                executor.execute(new WorkerTask(i));
            }
        }
    }
}

class WorkerTask implements Runnable {
    private int workerNumber;

    WorkerTask(int number) {
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
