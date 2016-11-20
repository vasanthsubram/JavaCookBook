package core.thread.basic;

public class UncaughtExceptionHandlerTest {

	public static void main(String[] args) {
		Thread.UncaughtExceptionHandler handler  = new Thread.UncaughtExceptionHandler() {
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Name of the thread:	 " + t.getName());
				System.out.println("Id of the thread:	 " + t.getId());
				System.out.println("Message is:		  " + e.getMessage());
			}
		};
		
		Thread.setDefaultUncaughtExceptionHandler(handler);
		throw new RuntimeException("Bye Bye from main");
	}

}
