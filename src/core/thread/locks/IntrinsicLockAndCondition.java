package core.thread.locks;

public class IntrinsicLockAndCondition {

	public static int binary=0;
	public static Object lock = new Object();
	
	public static void main(String[] args) {

		Runnable incrementer = new Runnable() {
			public void run() {
				synchronized (lock) {
					try {
						while (binary == 1) {
							lock.wait();
						}
						binary++;
						System.out.println("Inc " + binary);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						lock.notifyAll();
					}
				}
			}
		};
		
		Runnable decrementer = new Runnable(){
			public void run() {
				synchronized (lock) {
					try {
						while (binary == 0) {
							lock.wait();
						}
						binary--;
						System.out.println("Dec " + binary);
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						lock.notifyAll();
					}
				}
			}
		};
		System.out.println("Started......");
		while(true){
			new Thread(incrementer).start();
			new Thread(decrementer).start();
		}
	}
}
