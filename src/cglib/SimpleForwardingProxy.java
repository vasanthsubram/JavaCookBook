package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;


public class SimpleForwardingProxy {


	public static void main(String args[]) {
		TargetClass obj = (TargetClass) SimpleForwardingProxy
				.createProxy(TargetClass.class);
		obj.printSelf();

	}

	/**
	 * Create a proxy using NoOp callback. The target class must have a default
	 * zero-argument constructor.
	 * 
	 * @param targetClass
	 *            the super class of the proxy
	 * @return a new proxy for a target class instance
	 */
	public static  Object createProxy(Class targetClass) {
		try {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(targetClass);
			enhancer.setCallback(NoOp.INSTANCE);
			return enhancer.create();
			
		} catch (Throwable t) {
			t.printStackTrace();
		}

		return null;
	}

}
