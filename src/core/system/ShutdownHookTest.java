package core.system;

public class ShutdownHookTest {

	public static void main(String[] args) {
		Thread t = new Thread(){
			public void run(){
				System.out.println("This is the runtime hook running");
			}
		};
		Runtime.getRuntime().addShutdownHook(t);
		System.exit(0);
	}

}
