package spring.aop.profilerExample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 

public class AOPDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/aop/profilerExample/aop.xml");
		IBusiness bc = (IBusiness) context.getBean("myBusinessClass");
		bc.doSomeOperation();
	}
}
