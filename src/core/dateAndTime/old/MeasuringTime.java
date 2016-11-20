package core.dateAndTime.old;

public class MeasuringTime {
	public static void main(String[] args) throws Exception {
		// nono
		long beginTime = System.nanoTime();
		Thread.sleep(1000);
		long elapsedTime = System.nanoTime() - beginTime;

		System.out.println("Elapsed time in ns = " + elapsedTime
				+ ("( =" + elapsedTime / 1000000) + "ms)");

		// milli
		long beginTime2 = System.currentTimeMillis();
		Thread.sleep(1000);
		long elapsedTime2 = System.currentTimeMillis() - beginTime2;

		System.out.println("Elapsed time in ms = " + elapsedTime2);
	}
}
