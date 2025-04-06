package collection_lambda.collection.zz_SmarterIterator;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class SmartIterator {

	public static Object detect(Object target, Collection source,
			String methodName) {
		if(source==null) return null;
		
		Iterator it = source.iterator();
		Method m = null;
		while (it.hasNext()) {
			try {
				Object obj = it.next();
				if (m == null) {
					m = obj.getClass().getDeclaredMethod(methodName, null);
				}
				if (m.invoke(obj, null).equals(target))
					return obj;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}
	

	public static Collection select(Object target, Collection source,
			String methodName) {
		if(source==null) return (new ArrayList());
		Collection result=null;
		Method m = null;
		try{
			result=source.getClass().newInstance();
		} catch(Exception e){
			throw new RuntimeException(e);
		}
		Iterator it = source.iterator();
		while (it.hasNext()) {
			try {
				Object obj = it.next();
				if (m == null) {
					m = obj.getClass().getDeclaredMethod(methodName, null);
				}
				if (m.invoke(obj, null).equals(target)){
					result.add(obj);
				}
					
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return result;
	}
	
	public static Collection collect(Collection source, String methodName) {
		Collection result = null;
		Method m = null;
		try {
			result = source.getClass().newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		Iterator it = source.iterator();
		while (it.hasNext()) {
			try {
				Object obj = it.next();
				if (m == null) {
					m = obj.getClass().getDeclaredMethod(methodName, null);
				}
				result.add(m.invoke(obj, null));
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return result;
	}
}
