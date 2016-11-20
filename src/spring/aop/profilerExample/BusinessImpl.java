package spring.aop.profilerExample;

public class BusinessImpl implements IBusiness {

	public void doSomeOperation() {
		System.out.println("Do some business operation");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
		System.out.println("Done with business operation.");
	}
}
