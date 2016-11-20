package tomcat;
import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class EmbeddedTomcat {

	private Tomcat tomcat;

	private void startTomcat() throws ServletException, LifecycleException {
		this.tomcat = new Tomcat();
		this.tomcat.setPort(8080);
		this.tomcat.setBaseDir(".");
		String contextPath = "/myapp";
		String appBase = "C:/apache-tomcat-7.0.56/webapps/examples";
		this.tomcat.addWebapp(contextPath, appBase);
		this.tomcat.start();
	}

	private void stopTomcat() throws LifecycleException {
		this.tomcat.stop();
	}

	public static void main(String args[]) {
		try {
			EmbeddedTomcat tomcat = new EmbeddedTomcat();
			tomcat.startTomcat();
			Thread.sleep(1000000000);
			tomcat.stopTomcat();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
