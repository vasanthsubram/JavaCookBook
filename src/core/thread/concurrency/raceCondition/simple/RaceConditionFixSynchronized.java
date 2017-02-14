package core.thread.concurrency.raceCondition.simple;

public class RaceConditionFixSynchronized {
	private static int value;

	public static void main(String[] args) throws Exception {
		
		Runnable t = new Runnable() {
			public void run() {
				try {
					System.out.println("value =   " + getNext());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		(new Thread(t)).start();
		(new Thread(t)).start();
	}

	public static synchronized int getNext() throws Exception {
		int temp = value;
		// sleep, so that the other thread gets a chance to run
		Thread.currentThread().sleep(10);
		temp++;
		value = temp;
		return value;
	}
}
