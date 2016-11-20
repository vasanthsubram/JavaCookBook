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

public class ProducerThread extends Thread{

	private Destination destination;
    private String subject = "TOOL.DEFAULT";
    private boolean transacted;
    private int numMsg;
    private Session session=null;
    Connection connection = null;
    
    public ProducerThread(Connection newConnection, int num){
    	connection=newConnection;
    	numMsg=num;
    }
    
	public void run() {

		try {
			connection.start();
			session = connection.createSession(transacted,
					Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue(subject);
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			for (int i = 0; i < numMsg;) {
				TextMessage msg = session.createTextMessage("Message " + i);
				//msg.acknowledge();
				i++;
				System.out.println("Sending message: " + msg);
				producer.send(msg);
			}
			
			if (transacted) {
				session.commit();
				session.close();
			}

			producer.close();
			System.out.println("Sending Done .");

		} catch (Exception e) {
			System.out.println("Caught: " + e);
			//e.printStackTrace();
		} finally {
			try {
				System.out.println("Going to close the connection");
				connection.close();
			} catch (Throwable ignore) {
			}
		}

	}
}
