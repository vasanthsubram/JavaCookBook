package components.pools.concurrentQPool.client;

import java.util.concurrent.atomic.AtomicLong;

import components.pools.concurrentQPool.PoolElementFactory;

public class DummyProcessFactory implements PoolElementFactory<DummyProcess>{

	private AtomicLong processNo = new AtomicLong(0);
	
	@Override
	public DummyProcess createObject() {
		return new DummyProcess(processNo.incrementAndGet());
	}

}
