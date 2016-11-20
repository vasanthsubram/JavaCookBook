package spring.basics;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class HelloApp {
	public static void main(String[] args) throws Exception {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
				"resources/spring/hello.xml"));

		GreetingService greetingService1 = (GreetingService) factory
				.getBean("constructorInjectionGreetingService");

		greetingService1.sayGreeting();
		

		GreetingService greetingService2 = (GreetingService) factory
		.getBean("setterInjectionGreetingService");

		greetingService2.sayGreeting();
		
		GreetingService greetingService3 = (GreetingService) factory
		.getBean("referenceInjectionGreetingService");

		greetingService3.sayGreeting();

	}
}