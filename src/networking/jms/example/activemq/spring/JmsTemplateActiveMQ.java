package networking.jms.example.activemq.spring;

/*
 * Small class to get started with ActiveMQ and Spring. 
 * This class creates an activemq broker, creates the queue, sends and receives message and stops broker
 * It uses JmsTemplate to send and receive messages
 * It is based on jms.example.activemq.SimpleActiveMQTest.java
 * 
 * Inspired by the examples contained in the ActiveMQ download. Gisbert Amm, 2008-10-28
 */

import javax.jms.JMSException;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnection;
import org.springframework.jms.core.JmsTemplate;

/**
*
* @author gisbert.amm
*/
public class JmsTemplateActiveMQ {

   private static ActiveMQConnectionFactory connectionFactory;
   private static Connection connection;
   private static Session session;
   private static Destination destination;
   private static boolean transacted = false;
   private static String queueName="TestQ";
   public static void main(String[] args) throws Exception {
       BrokerService broker = new BrokerService();
       broker.setUseJmx(true);
       broker.addConnector("tcp://localhost:61616");
       broker.start();

       setUp();
       createProducerAndSendAMessage();
       System.out.println("Simulating a huge network delay :)");
       Thread.sleep(2000);
       //System.in.read();
       createConsumerAndReceiveAMessage();

       //TODO: Find out how to get rid of the exceptions thrown when stopping the broker
       broker.stop();
   }

   private static void setUp() throws JMSException {
       connectionFactory = new ActiveMQConnectionFactory(
               ActiveMQConnection.DEFAULT_USER,
               ActiveMQConnection.DEFAULT_PASSWORD,
               ActiveMQConnection.DEFAULT_BROKER_URL);
       connection = connectionFactory.createConnection();
       connection.start();
       session = connection.createSession(transacted, Session.AUTO_ACKNOWLEDGE);
       destination = session.createQueue(queueName);
   }

   private static void createProducerAndSendAMessage() throws JMSException {     
       JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
       System.out.println("Sending message: ");
       jmsTemplate.convertAndSend(queueName, "Hello World");
   }

   private static void createConsumerAndReceiveAMessage() throws JMSException, InterruptedException {      
       JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
       System.out.println("Receiving message: ");
       System.out.println(jmsTemplate.receiveAndConvert(queueName));
   }
}