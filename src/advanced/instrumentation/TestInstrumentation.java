package advanced.instrumentation;

/*
 * create a special agent class with a special premain method, 
 * generally compiling it against the rest of our code so that it 
 * can see the definitions of the classes whose memory 
 * usage we're interested in measuring 
 * - Refer MyAgent.java in this package
 * 
 * the JVM passes a special Instrumentation object to our premain method, 
 * which we can use to query the size of an object
 * 
 * package the compiled agent class into a jar with a special manifest file
 * - Refer ant-script.xml int this package
 * 
 * run our program, passing in the agent jar to the VM command line arguments.
 * - Refer the VM argument for this program
 * - make sure the path of the jar is correct 
 * - for ex:   -javaagent:C:/eclipse-jee-3.3.2-mvn-svn-win32/workspace/codejam/bin/instrumentation/myagent.jar
 * - (Don't give any space in the argument)
 */
public class TestInstrumentation {

	public static void main(String[] args) {
		System.out.print("Plain Object:  ");
		System.out.println(MyAgent.getObjectSize(new Object()));
		System.out.print("Empty int array:  ");
		System.out.println(MyAgent.getObjectSize(new int[0]));
		System.out.print("Empty string:  ");
		System.out.println(MyAgent.getObjectSize(new String()));
		System.out.println("String from 1000 byte array");
		byte[] b=new byte[1000];
		System.out.println(MyAgent.getObjectSize(new String(b)));
		
		System.out.print("\n A int primitive  ");
		System.out.println(MyAgent.getObjectSize(Integer.MAX_VALUE));
		System.out.print("A long primitive  ");
		System.out.println(MyAgent.getObjectSize(Long.MAX_VALUE));
		
		System.out.print("Array of 100 byte primitives:  ");
		System.out.println(MyAgent.getObjectSize(new byte[100]));
		System.out.println();
		
		System.out.print("Array of 0    int primitives:  ");
		System.out.println(MyAgent.getObjectSize(new int[0]));
		System.out.print("Array of 100 int primitives:  ");
		System.out.println(MyAgent.getObjectSize(new int[100]));
		System.out.print("Array of 100 Integer wrapper:  ");
		System.out.println(MyAgent.getObjectSize(new Integer[100]));
		System.out.println();
		
		System.out.print("Array of 100 long primitives:  ");
		System.out.println(MyAgent.getObjectSize(new long[100]));
		System.out.println();
		
		System.out.print("Array of 100 boolean primitives:  ");
		System.out.println(MyAgent.getObjectSize(new boolean[100]));
		System.out.print("Array of 100 Boolean wrapper  ");
		System.out.println(MyAgent.getObjectSize(new Boolean[100]));
	}

}
