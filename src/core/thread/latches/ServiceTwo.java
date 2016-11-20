package core.thread.latches;

import java.util.concurrent.CountDownLatch;

public class ServiceTwo implements Runnable{
	
	private final CountDownLatch latch;

	public ServiceTwo(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("started service Two");
		latch.countDown();	
	}
}
