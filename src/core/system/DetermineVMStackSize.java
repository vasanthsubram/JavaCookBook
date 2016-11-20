package core.system;

/**
 * This program determines the stack size of the VM
 * 
 * Why is it different, for different executions of the program
 * 
 * @author chq-vasanthakumars
 *
 */
public class DetermineVMStackSize {

	private static int i;

	public static void main(String[] args) {
		i = 0;
		try {
			boo();
		} catch(Throwable e) {
			System.out.println("stack size is = " + i);
		}
	}

	private static void boo() {
		i++;
		boo();
	}
}
