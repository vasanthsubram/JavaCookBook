package collection_lambda.collection.modifyingWhileIterating;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DeletingWhileIteratingMultiThreadWrongWay {

	static List<String> list = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		list.add("SSS");
		list.add("TTT");
		list.add("UUU");

		Thread t1 = new Thread() {
			public void run() {
				Iterator it = list.iterator();
				
				while (it.hasNext()) {
					System.out.println("Delete while iterating " + list);
					it.next();
					it.remove();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				for (int i = 0; i < 2; i++) {
					Iterator it = list.iterator();
					while (it.hasNext()) {
						System.out.println("Access the collection " + i + " " + it.next());
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							System.out.println("error while accessing...");
							e.printStackTrace();
						}
					}
				}
			}
		};
		t1.start();
		t2.start();
	}
}
