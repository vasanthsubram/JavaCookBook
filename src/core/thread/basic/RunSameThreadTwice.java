package core.thread.basic;

public class RunSameThreadTwice {

	public static void main(String[] args) {
		Runnable t = new Runnable() {
			public void run() {
				try {
					System.out.println(Thread.currentThread().getId());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		Thread th =new Thread(t);
		th.start();
		
		
		/**
		* It is never legal to start a thread more than once.
	     * In particular, a thread may not be restarted once it has completed
	     * execution.
	     */
		th.start();

	}

}
