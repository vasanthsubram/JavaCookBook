package core.thread.basic;

/**
 * This example shows how the main thread continues, even if a spawned thread
 * dies
 * 
 * 
 * @author chq-vasanthakumars
 * 
 */
public class ExceptionInThread {

	public static void main(String args[]) throws Exception {

		Runnable r1 = new Runnable() {
			public void run() {
				System.out.println("\t Inside the child thread: id = "
						+ Thread.currentThread().getId());
				throw new RuntimeException("Runtime exception in child thread");

			}
		};
		Thread t = new Thread(r1);

		try {
			// this thread will till 't' finishes

			System.out.println("Main thread : id = "
					+ Thread.currentThread().getId()
					+ " :Waiting for the child thread to finish");
			t.start();

			t.join();
			Thread.currentThread().sleep(100);
			System.out
					.println("Main thread: id = "
							+ Thread.currentThread().getId()
							+ "  :child thread is Done");
			System.out.println("Program  done");
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
