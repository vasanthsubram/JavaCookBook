package collection_lambda.collection.zz_smartIterator;
import java.util.Collection;

public class SmartIterator<T,V> {
	interface BooleanBlock<T,V> {
		public  boolean value(T o, V target);
	}

	interface DoBlock<T, V> {
		public  V value(T o);
	}
	
	public Object detect(V target,Collection<T> source, BooleanBlock<T,V> block) {
		for (T each : source) {
			if ((block.value(each, target)))
				return each;
			}
		return null;
	}
	
	public Collection<T> select(V target,Collection<T> source, BooleanBlock<T,V> block) {
		Collection<T> resultColl=null;
		try {
			resultColl = source.getClass().newInstance();
		}catch(Exception e){}
		
		for (T each : source) {
			if ((block.value(each, target)))
				resultColl.add(each);
			}
		return resultColl;
	}	
	
	public Collection<V> collect(Collection<T> source, DoBlock<T,V> block) {
		Collection<V> resultColl=null;
		try {
			resultColl = source.getClass().newInstance();
		}catch(Exception e){}
		
		for (T each : source) {
			resultColl.add(block.value(each));
		}
		return resultColl;
	}	
}
