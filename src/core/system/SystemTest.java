package core.system;

import java.util.*;

public class SystemTest {

	public static void main(String args[]) {
		 System.out.println(Runtime.getRuntime().availableProcessors());
		 System.out.println(Runtime.getRuntime().freeMemory());
		 System.out.println(Runtime.getRuntime().maxMemory());
		 System.out.println(Runtime.getRuntime().totalMemory());

		System.out.println(System.getenv("PATH"));
		long time = System.currentTimeMillis();
		System.out.println("current time is : " + time + "ms");
		System.out.println();
		Map aMap = System.getenv();
		Set<Map.Entry> anEntrySet = aMap.entrySet();

		for (Map.Entry entry : anEntrySet) {
			System.out.println(entry.getKey() + "\t\t\t" + entry.getValue());
		}

		System.gc();

		// System.setProperty("async.handler.context", "true");
		Properties props = System.getProperties();
		for (Object key : props.keySet()) {
			// System.out.println(key + "\t\t\t" +
			// props.getProperty((String)key));
		}
		String val = System.getProperty("async.handler.context");
		System.out.println((val == null) ? false : (val == "true"));
		
		
		//copy array
		int[] intArr= new int[3];
		System.arraycopy(new int[]{1,2,3}, 0, intArr, 0, 3);

		for(int i: intArr){
			System.out.println(i);
		}
		
	}

}
