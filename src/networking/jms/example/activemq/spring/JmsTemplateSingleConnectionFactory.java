package networking.jms.example.activemq.spring;

import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
/**
 * Simple program on how to use JmsTemplate. 
 * Assumes broker is running locally at 61616
 * @author chq-vasanthakumars
 *
 */
public class JmsTemplateSingleConnectionFactory {

	public static void main(String[] args) throws Exception{
		String centralURI = "tcp://localhost:61616";
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(centralURI);
		SingleConnectionFactory singleConnectionFactory = new SingleConnectionFactory();
		singleConnectionFactory.setTargetConnectionFactory(connectionFactory);
		
		String destinationName = "TestQueue";
		
		JmsTemplate jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(singleConnectionFactory);
		jmsTemplate.afterPropertiesSet();
	
		long beginTime = System.nanoTime();
		for(int i = 0; i < 10; i++){
			jmsTemplate.convertAndSend(destinationName, "Hello " + i);
		}
		long elapsedTime=System.nanoTime()-beginTime;
		System.out.println(elapsedTime);
		
		
		
	}

}
