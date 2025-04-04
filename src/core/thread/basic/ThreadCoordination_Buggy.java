package core.thread.basic;

/**
 * This program demonstrates a classic concurrency bug.
 * If t1 completes even before t2 can start, then t2 will wait forever.
 *  This is because t2 will miss the notifyAll notification of t1
 */
public class ThreadCoordination_Buggy {

	static final Object lock = new Object();		//this is important. The two threads must synchronize on a common object
	
	public static void main(String[] args) {
	
		Runnable r1 = new Runnable() {
			public void run() {
				synchronized (lock) {			//must synchronize on a common object
					try {
						System.out.println("t1: going to do some work");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t1: I am done");
					lock.notifyAll();
				}
			}
		};
		
		Runnable r2 = new Runnable() {
			public void run() {
				synchronized (lock) {				//must synchronize on a common object
					try {
						System.out.println("t2:  Going to wait for Thread t1....");
						lock.wait();
						System.out.println("t2:  Done waiting....");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}
