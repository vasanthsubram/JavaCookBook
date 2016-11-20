package core.reflection;

import java.lang.reflect.Constructor;
import java.util.Stack;

/**
 * @category Constructor, Instance
 * @author chq-vasanthakumars
 *
 */
public class DifferentWaysToInstantiate {

	public static void main(String[] args) throws Exception {

		String className = "java.util.ArrayList";
		Object obj1 = Class.forName(className).newInstance();
		System.out.println(obj1.getClass().toString());
		
		String className2 = "java.util.Stack";
		Constructor cons = Class.forName(className2).getConstructor();
		Object obj2 = cons.newInstance();
		System.out.println(obj2.getClass().toString());
		System.out.println(((Stack)obj2).size());

		String className3 = "java.util.UUID";
		Constructor cons3 = Class.forName(className3).getConstructor(long.class,long.class);
		Object obj3 = cons3.newInstance(0L,0L);
		System.out.println(obj3.getClass().toString());
		System.out.println(obj3);
	}

}
