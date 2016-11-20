package components.pools.concurrentQPool.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import components.pools.concurrentQPool.ObjectPool;

public class TestObjectPool {
    private ObjectPool<DummyProcess> pool;

    @Before
    public void setUp() {
    	System.out.println("Pool setup started");
        pool = new ObjectPool<DummyProcess>(new DummyProcessFactory());
        System.out.println("Pool setup complete");
        System.out.println();
    }

    @Test
    public void testObjectPool() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        executor.execute(new DummyTask(pool, 1));
        executor.execute(new DummyTask(pool, 2));
        executor.execute(new DummyTask(pool, 3));
        executor.execute(new DummyTask(pool, 4));

        try {
        	executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        	e.printStackTrace();
        }
    }
}