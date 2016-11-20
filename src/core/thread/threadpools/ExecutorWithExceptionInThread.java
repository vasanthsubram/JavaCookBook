package core.thread.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Example that shows, that if the threads in the Executor that run the tasks
 * die, new threads are created and keep the thread count constant
 * 
 * 
 * Every task prints the thread id. The thread id is different, when the
 * previous task threw an exception. Otherwise it is the same id.
 * 
 * @author chq-vasanthakumars
 * 
 */
public class ExecutorWithExceptionInThread {

	public static void main(String args[]) throws Exception {

		class TestRunnable implements Runnable {
			public void run() {
				String str = "\nThread id = " + Thread.currentThread().getId();
				throw new RuntimeException(str
						+ "    Runtime exception in child thread ");
			}
		}

		class TestRunnable2 implements Runnable {
			public void run() {
				String str = "\nThread id = " + Thread.currentThread().getId();
				System.out.println(str + "   HelloWorld...... No exception");
			}
		}
		ExecutorService exService = Executors.newFixedThreadPool(1);

		// will print the same thread id
		for (int i = 0; i < 3; i++) {
			exService.execute(new TestRunnable2());
		}
		Thread.currentThread().sleep(500);

		// will print different thread id, because every task in this loop
		// throws an exception
		for (int i = 0; i < 3; i++) {
			exService.execute(new TestRunnable());
		}
		Thread.currentThread().sleep(500);
		exService.shutdown();

		while (!exService.isTerminated()) {
		}

		System.out.println("\n End of program");
	}
}
