package components.pools.concurrentQPool.client;

import components.pools.concurrentQPool.ObjectPool;

public class DummyTask implements Runnable {

    private ObjectPool<DummyProcess> pool;

    private int threadNo;

    public DummyTask(ObjectPool<DummyProcess> pool, int threadNo) {
        this.pool = pool;
        this.threadNo = threadNo;
    }

    public void run() {
        // get an object from the pool
        DummyProcess exportingProcess = pool.borrowObject();

        System.out.println("Thread " + threadNo + 
                ": Object with process no. " + exportingProcess.getProcessNo() + " was borrowed");

        // do something....
        for (int i = 0; i < 100000; i++) {
        }

        // return back to the pool
        pool.returnObject(exportingProcess);

        System.out.println("Thread " + threadNo + 
                ": Object with process no. " + exportingProcess.getProcessNo() + " was returned");
    }
}