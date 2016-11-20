package core.thread.basic;

/**
 * <ol>
 * <li>
 * Any number of threads can invoke a method of an instance concurrently as long
 * the method does not access a variable that is shared by another thread(i.e.,
 * all the variables it access are immutable or local)
 * </li>
 * <li>
 * Each thread simply has a copy of the java byte codes of the method and
 * manipulates that copy in its own space
 * </li>
 * </ol>
 * @author chq-vasanthakumars
 * 
 */
public class ObviousTruthOfMethodInvocation {

	static int MAX = 5;
	static ObviousTruthOfMethodInvocation instance = new ObviousTruthOfMethodInvocation();

	public static void main(String[] args) {

		Thread[] arr = new Thread[MAX];
		for (int i = 0; i < MAX; i++) {
			arr[i] = new Thread() {
				public void run() {
					//all the threads will print the same values
					instance.print();
				}
			};
		}

		for (int i = 0; i < MAX; i++) {
			arr[i].start();
		}
	}

	public void print() {
		int x = 5;
		long id = Thread.currentThread().getId();
		int val = x + 3 + MAX;
		System.out.println("thread id= " + id + "\t x = " + x + "\t val =" + val);
	}
}
