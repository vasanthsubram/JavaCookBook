package networking.jms.example;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Coordinator {

	private Destination destination;
    private String user = ActiveMQConnection.DEFAULT_USER;
    private String password = ActiveMQConnection.DEFAULT_PASSWORD;
    private String url = "failover:(tcp://localhost:61616?wireFormat.maxInactivityDuration=9000)?maxReconnectAttempts=3";
    private String subject = "TOOL.DEFAULT";
    private boolean transacted;
    private int numMsg=2;
    private Session session=null;
    
    public static void main(String args[]){
    	new Coordinator().run();
    }
    
     
	public void run() {
		Connection connection1 = null, connection2 = null, connection3 = null;
		try {
			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
					user, password, url);
			connection1 = connectionFactory.createConnection();
			connection2 = connectionFactory.createConnection();
			connection3 = connectionFactory.createConnection();
			
			
			new ProducerThread(connection1, numMsg).start();
			new ProducerThread(connection2, numMsg).start();
			new ProducerThread(connection3, numMsg).start();
//		
			
			Thread t= new Thread(){
				public void run(){
					for(;;){}
				}
			};
			t.start();
			
			
		
//			Connection connection4 = connectionFactory.createConnection();
//			new ProducerThread(connection4, numMsg).start();

		} catch (Exception e) {
			System.out.println("Caught: " + e);
			e.printStackTrace();
		} finally {
			try {
				//connection.close();
			} catch (Throwable ignore) {
			}
		}

	}
	
	
}
