package networking.jms.example;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.util.IndentPrinter;

public class ThreadLockIssue  implements MessageListener{

	private Destination destination;
    private String user = ActiveMQConnection.DEFAULT_USER;
    private String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private String subject = "TOOL.DEFAULT";
    private boolean transacted;
    private int numMsg=2;
    private Session session=null;
    public static void main(String args[]){
    	new ThreadLockIssue().run();
    }
    
     
	public void run() {
		Connection connection = null;
		try {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					user, password, url);
			connection = connectionFactory.createConnection();

			connection.start();

			session = connection.createSession(transacted,
					Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue(subject);
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			for (int i = 0; i < numMsg;) {
				TextMessage msg = session.createTextMessage("Message " + i);
				i++;
				System.out.println("Sending message: " + msg);
				producer.send(msg);
			}

			if (transacted) {
				//session.commit();
				connection.close();
				session.close();
			}

			producer.close();
			System.out.println("Sending Done .");

			// ********* Consumer *********
			MessageConsumer consumer = null;
			consumer = session.createConsumer(destination);
			session = connection.createSession(transacted,
					Session.AUTO_ACKNOWLEDGE);

			for (int i = 0; i <numMsg;) {
				Message message = consumer.receive(1000);
				if (message != null) {
					i++;
					onMessage(message);
				}
			}
			System.out.println("Closing connection");
			consumer.close();
			session.close();
			connection.close();

		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Throwable ignore) {
			}
		}

	}
	
	 public void onMessage(Message message) {
		try {

			if (message instanceof TextMessage) {
				TextMessage msg = (TextMessage) message;
				System.out.println("Received: " + msg);
			}

			if (transacted) {
				session.commit();
			}

		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		} finally {

		}
	}
}
