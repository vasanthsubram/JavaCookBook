package core.collection;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTestForSize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String,Object>(2000000);
		
		for(int i=0;i<Integer.MAX_VALUE;i++){
			System.out.println(i);
			map.put(UUID.randomUUID().toString(), new Object());
		}
	}

}
