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

public class ConsumerThread extends Thread implements MessageListener{

	private Destination destination;
    private String user = ActiveMQConnection.DEFAULT_USER;
    private String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private String subject = "TOOL.DEFAULT";
    private boolean transacted;
    private int numMsg=2;
    private Session session=null;
    Connection connection = null;
    
    public ConsumerThread(Connection newConnection, int num){
    	connection=newConnection;
    	numMsg=num;
    }
    
     
	public void run() {
		try {
			connection.start();

			session = connection.createSession(transacted,
					Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue(subject);

			MessageConsumer consumer = null;
			consumer = session.createConsumer(destination);
			session = connection.createSession(transacted,
					Session.AUTO_ACKNOWLEDGE);

			for (int i = 0; i < numMsg;) {
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
