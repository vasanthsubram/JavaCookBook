package core.thread.basic;

public class InterruptingThread {

	public static void main(String[] args) throws Exception {

		Runnable r = new Runnable() {
			public void run() {
				try {
					System.out.println("Child Thread id "
							+ Thread.currentThread().getId()
							+ ":  Going to sleep");
					Thread.sleep(3600000);  //going to sleep for 1hr
				} catch (InterruptedException e) {
					System.out
							.println("Child Thread id "
									+ Thread.currentThread().getId()
									+ ": i have been interrupted from my sleep");
				}
				System.out.println("Child thread is still running...");
			}

		};

		Thread t = new Thread(r);
		System.out.println("Parent Thread id "
				+ Thread.currentThread().getId()
				+ ":  Started thread " + t.getId());
		t.start();
		Thread.sleep(2000);
		System.out.println("Parent Thread id "
				+ Thread.currentThread().getId()
				+ ":  Going to interrupt the thread " + t.getId());
		
		//interrupt, even a sleeping thread
		t.interrupt();
	}
}
