package core.system;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class JavaMXManagement {

	public static void main(String[] args) throws Exception {
		ThreadMXBean threadMX = ManagementFactory.getThreadMXBean();
		System.out.println("Peak thread count  "
				+ threadMX.getPeakThreadCount());
		System.out.println("CPU time " + threadMX.getCurrentThreadCpuTime());
		Thread.sleep(1000);
		System.out.println("USer time " + threadMX.getCurrentThreadUserTime());
		System.out
				.println("current thread count =" + threadMX.getThreadCount());
		System.out.println("Total threads started = "
				+ threadMX.getTotalStartedThreadCount());

		try {
			// connect to a separate VM's MBeanServer, using the JMX RMI
			// functionality
			JMXServiceURL address = new JMXServiceURL(
					"service:jmx:rmi://dp1dev-branch/jndi/rmi://dp1dev-branch:31798/jmxconnector");

			Map<String, Object> env = new HashMap<String, Object>();
			String[] credentials = new String[] { "userid", "password" };
			env.put("jmx.remote.credentials", credentials);

			JMXConnector connector = JMXConnectorFactory.connect(address, env);

			MBeanServerConnection mbs = connector.getMBeanServerConnection();
			ThreadMXBean threadBean = ManagementFactory.newPlatformMXBeanProxy(
					mbs, ManagementFactory.THREAD_MXBEAN_NAME,
					ThreadMXBean.class);
			System.out.println("Peak thread count  "
					+ threadBean.getPeakThreadCount());

			MemoryMXBean memoryBean =ManagementFactory.newPlatformMXBeanProxy(
					mbs, ManagementFactory.MEMORY_MXBEAN_NAME,
					MemoryMXBean.class);
			System.out.println("Memory = " + memoryBean.getHeapMemoryUsage());

			OperatingSystemMXBean osBean = ManagementFactory.newPlatformMXBeanProxy(
					mbs, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME,
					OperatingSystemMXBean.class);
			System.out.println("Arch " + osBean.getArch());
			System.out.println("Processors " + osBean.getAvailableProcessors());
			System.out.println("OS " + osBean.getName());
			System.out.println("Version " + osBean.getVersion());
			
			
			GarbageCollectorMXBean gcBean = ManagementFactory.newPlatformMXBeanProxy(
					mbs, ManagementFactory.MEMORY_MANAGER_MXBEAN_DOMAIN_TYPE,
					GarbageCollectorMXBean.class);
			System.out.println("GC count " + gcBean.getCollectionCount());
			System.out.println("GC time " + gcBean.getCollectionTime());
			
			RuntimeMXBean rtBean = ManagementFactory.newPlatformMXBeanProxy(
					mbs, ManagementFactory.RUNTIME_MXBEAN_NAME,
					RuntimeMXBean.class);
			System.out.println("class path   =  " + rtBean.getClassPath());
			System.out.println("lib path   = " + rtBean.getLibraryPath());
			System.out.println("VM name = " + rtBean.getVmName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
