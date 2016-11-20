package components.pools.concurrentQPool;

public interface PoolElementFactory<T> {

	T createObject();
}
