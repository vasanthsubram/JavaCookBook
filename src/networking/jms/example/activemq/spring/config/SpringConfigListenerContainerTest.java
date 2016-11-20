package networking.jms.example.activemq.spring.config;

/*
 * Small class to get started with ActiveMQ and Spring. 
 * This class creates an activemq broker, creates the queue, sends and receives message and stops broker
 * It uses JmsTemplate to send messages
 * A container is used to receive messages
 * It is based on jms.example.activemq.SimpleActiveMQTest.java
 */
import java.util.Date;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

public class SpringConfigListenerContainerTest {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:config.xml");

		//create the container and start to listen for messages
		DefaultMessageListenerContainer container=(DefaultMessageListenerContainer) context.getBean("testContainer");
		container.start();

		//send messages using JmsTemplate
		String queueName = "TestQueue";
		System.out.println("Sending message");
		((JmsTemplate) context.getBean("testJmsTemplate")).convertAndSend(
				queueName, new Date().toString() + ":  Hello World");
		
		Thread.sleep(100);
		container.stop();
		container.destroy();
	}
	
	
}