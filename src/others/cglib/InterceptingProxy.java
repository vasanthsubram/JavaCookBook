package others.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.*;

/**
 * The proxy will be a subclass of a real class. So it can be cast to or
 * assigned to a variable of the real class. Any method that is defined in the
 * real class can be invoked on the proxy but the call will be intercepted by
 * the proxy and a different behaviour can be executed.
 * 
 * This implements the Decorator pattern
 * 
 * @author chq-vasanthakumars
 * 
 */
public class InterceptingProxy implements MethodInterceptor {

	public static void main(String args[]) {
		TargetClass obj = (TargetClass) InterceptingProxy
				.createProxy(TargetClass.class);
		obj.printSelf();

	}

	/**
	 * Create and return a proxy that will intercept. The real class must have a
	 * default zero-argument constructor.
	 * 
	 * @param targetClass
	 *            - the real class - the super class of the proxy
	 * @return a new proxy for a target class instance
	 */
	public static Object createProxy(Class targetClass) {
		try {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(targetClass);
			enhancer.setCallback(new InterceptingProxy());
			return enhancer.create();

		} catch (Throwable t) {
			t.printStackTrace();
		}

		return null;
	}

	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {

		System.out.println("proxy object class name = " + obj.getClass().getName());
		System.out.println("super class name = " + obj.getClass().getSuperclass().getName());
		System.out.println("Method name = " + method.getName());
		for (Object o : args) {
			System.out.println(o.getClass().getName());
		}
		System.out.println(proxy.getClass().getName());

		if (method.getName().equals("printSelf")) {
			System.out.println("printSelf has been intercepted");
			System.out.println("Real object is going to be called");
			//method.invoke(this.);
			
			System.out.println("Returning from the real object");

		}

		return null;
	}

}
