package components.pools.concurrentQPool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ObjectPool<T> {
	
    private ConcurrentLinkedQueue<T> pool;
    private PoolElementFactory<T> factory;
    
    public ObjectPool(PoolElementFactory<T> factory) {
    	pool = new ConcurrentLinkedQueue<T>();
    	this.factory=factory;
    	pool.add(createObject());
    	pool.add(createObject());
    }

    public T borrowObject() {
        T object;
        if ((object = pool.poll()) == null) {
            object = createObject();
        }
        return object;
    }

    public void returnObject(T object) {
        if (object == null) {
            return;
        }
        this.pool.offer(object);
    }


    protected T createObject(){
    	return factory.createObject();
    }
}