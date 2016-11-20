package jmx.helloBean;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;


public class Main {

	public static void main(String[] args) throws Exception {

		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("jmx.helloBean:type=Hello");
		Hello mbean = new Hello();
		mbs.registerMBean(mbean, name);

		System.out.println("Waiting forever...");
		Thread.sleep(Long.MAX_VALUE);
		
		/*
		 * Start JConsole in a different terminal window on the same machine.
				jconsole

			The New Connection dialog box is displayed, presenting a list of running JMX agents that you can connect to.
			In the New Connection dialog box, select jmx.helloBean.Main from the list and click Connect.

			A summary of your platform's current activity is displayed.
			Click the MBeans tab. 
		 */
	}
}
