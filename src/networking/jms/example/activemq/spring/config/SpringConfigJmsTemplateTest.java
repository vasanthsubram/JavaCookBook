package networking.jms.example.activemq.spring.config;

/**
 * Small class to get started with ActiveMQ and Spring. 
 * Through spring config file create an activemq broker, 
 * creates the queue, sends and receives messages
 * It uses JmsTemplate to send and receive messages
 * It is based on jms.example.activemq.SimpleActiveMQTest.java
 */
import java.util.Date;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class SpringConfigJmsTemplateTest {
	public static void main(String[] args) throws Exception {
		// broker, jmsTemplate are configured in this config.xml
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:config.xml");
		
		// send messages using jmsTemplate
		String queueName = "TestQ";
		System.out.println("Sending message");
		((JmsTemplate) context.getBean("testJmsTemplate")).convertAndSend(
				queueName, new Date().toString() + ":  Hello World");

		System.out.println("Simulating a huge network delay :)");
		Thread.sleep(2000);

		// receive messages using jmsTemplate
		System.out.println("Receiving message");
		System.out.println(((JmsTemplate) context.getBean("testJmsTemplate"))
				.receiveAndConvert(queueName));

		System.exit(1);
	}
}