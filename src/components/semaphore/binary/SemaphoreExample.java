package components.semaphore.binary;

public class SemaphoreExample {
	
	public static void main(String[] args) {
		int MAX=3;
		PrinterQueue printerQueue = new PrinterQueue();
		Thread thread[] = new Thread[MAX];
		for (int i = 0; i < MAX; i++) {
			thread[i] = new Thread(new PrintingJob(printerQueue), "Thread " + i);
		}
		for (int i = 0; i < MAX; i++) {
			thread[i].start();
		}
	}
}