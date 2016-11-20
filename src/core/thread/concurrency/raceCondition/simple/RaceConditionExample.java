package core.thread.concurrency.raceCondition.simple;

/**
 * This class creates a guaranteed race condition to occur
 * 
 * One thread retrieves a 'shared' value and pauses.
 * Second thread retrieves the same 'shared' value and pauses.
 *  First thread wakes up and increments the value.
 *  Second thread wakes up and increments the value and overwrites the first threads write.
 * @author chq-vasanthakumars
 *
 */
public class RaceConditionExample {
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

	public static int getNext() throws Exception {
		int temp = value;
		// sleep, so that the other thread gets a chance to run
		Thread.currentThread().sleep(10);
		temp++;
		value = temp;
		return value;
	}
}