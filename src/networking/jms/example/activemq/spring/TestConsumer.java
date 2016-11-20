package networking.jms.example.activemq.spring;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TestConsumer implements MessageListener, ExceptionListener {

    synchronized public void onException(JMSException ex) {
        System.out.println("JMS Exception occured.  Shutting down client.");
        System.exit(1);
    }

    public void onMessage(Message message) {
    	System.out.println("Receveing message" + message);
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println("Received message: " + textMessage.getText());
            } catch (JMSException ex) {
                System.out.println("Error reading message: " + ex);
            }
        } else  {
            System.out.println("Received: " + message);
        }
    }
}