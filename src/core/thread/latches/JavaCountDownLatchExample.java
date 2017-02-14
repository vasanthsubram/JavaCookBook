package core.thread.latches;

import java.util.concurrent.CountDownLatch;

public class JavaCountDownLatchExample {

	public static void main(String[] args) {
		// intialising count down latch by 2, as it will wait for 2 threads to
		// finish execution
		final CountDownLatch latch = new CountDownLatch(2);

		// making two threads for 2 services
		Thread serviceOneThread = new Thread(new Service(latch));
		Thread serviceTwoThread = new Thread(new Service(latch));

		serviceOneThread.start();
		serviceTwoThread.start();

		// latch waits till the count becomes 0
		// this way we can make sure that the execution of main thread only
		// finishes ones 2 services have executed
		try {
			latch.await();
			System.out.println("Starting main Thread!!!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	 static class Service implements Runnable{

		private final CountDownLatch latch;

		public Service(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			System.out.println("Started service");
			//reduce count of Count Down Latch by 1.
			latch.countDown();
		}
	}

}
