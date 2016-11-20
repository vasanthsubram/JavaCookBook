package core.thread.locks;

public class ThreadCoordination {

	static final Object key = new Object();		//this is important. The two threads must synchronize on a common object
	
	public static void main(String[] args) {
	
		Runnable r1 = new Runnable() {
			public void run() {
				synchronized (key) {			//must synchronize on a common object
					try {
						System.out.println("t1: going to do some work");
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("t1: I am done");
					key.notifyAll();
				}
			}
		};
		
		Runnable r2 = new Runnable() {
			public void run() {
				synchronized (key) {				//must synchronize on a common object
					try {
						System.out.println("t2:  Going to wait for Thread t1....");
						key.wait();
						System.out.println("t2:  Done waiting....");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		new Thread(r2).start();
		new Thread(r1).start();
	}
}
