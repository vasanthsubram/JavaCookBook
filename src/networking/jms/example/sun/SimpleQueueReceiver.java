package networking.jms.example.sun;

/*
 *
 * Copyright 2002 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * Redistribution and use in source and binary forms, with or
 * without modification, are permitted provided that the following
 * conditions are met:
 * 
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * 
 * - Redistribution in binary form must reproduce the above
 *   copyright notice, this list of conditions and the following
 *   disclaimer in the documentation and/or other materials
 *   provided with the distribution.
 * 
 * Neither the name of Sun Microsystems, Inc. or the names of
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 * 
 * This software is provided "AS IS," without a warranty of any
 * kind. ALL EXPRESS OR IMPLIED CONDITIONS, REPRESENTATIONS AND
 * WARRANTIES, INCLUDING ANY IMPLIED WARRANTY OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE OR NON-INFRINGEMENT, ARE HEREBY
 * EXCLUDED. SUN AND ITS LICENSORS SHALL NOT BE LIABLE FOR ANY
 * DAMAGES OR LIABILITIES SUFFERED BY LICENSEE AS A RESULT OF OR
 * RELATING TO USE, MODIFICATION OR DISTRIBUTION OF THIS SOFTWARE OR
 * ITS DERIVATIVES. IN NO EVENT WILL SUN OR ITS LICENSORS BE LIABLE
 * FOR ANY LOST REVENUE, PROFIT OR DATA, OR FOR DIRECT, INDIRECT,
 * SPECIAL, CONSEQUENTIAL, INCIDENTAL OR PUNITIVE DAMAGES, HOWEVER
 * CAUSED AND REGARDLESS OF THE THEORY OF LIABILITY, ARISING OUT OF
 * THE USE OF OR INABILITY TO USE THIS SOFTWARE, EVEN IF SUN HAS
 * BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.
 * 
 * You acknowledge that this software is not designed, licensed or
 * intended for use in the design, construction, operation or
 * maintenance of any nuclear facility.
 * 
 */
/**
 * The SimpleQueueReceiver class consists only of a main method, 
 * which fetches one or more messages from a queue using 
 * synchronous message delivery.  Run this program in conjunction
 * with SimpleQueueSender.  Specify a queue name on the command
 * line when you run the program.
 */
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SimpleQueueReceiver {

	public static void main(String[] args) {
		Context jndiContext = null;
		QueueConnectionFactory queueConnectionFactory = null;
		QueueConnection queueConnection = null;
		QueueSession queueSession = null;
		Queue queue = null;
		QueueReceiver queueReceiver = null;
		TextMessage message = null;

		try {
			jndiContext = new InitialContext();
		} catch (NamingException e) {
			System.out.println("Could not create JNDI API " + "context: "
					+ e.toString());
			System.exit(1);
		}

		try {
			queueConnectionFactory = (QueueConnectionFactory) jndiContext
					.lookup("ConnectionFactory");
			System.out.println("connection factory setup");
			queue = (Queue) jndiContext.lookup("MyQueue");
		} catch (NamingException e) {
			System.out.println("JNDI API lookup failed: " + e.toString());
			System.exit(1);
		}

		/*
		 * Create connection. Create session from connection; false means
		 * session is not transacted. Create receiver, then start message
		 * delivery. Receive all text messages from queue until a non-text
		 * message is received indicating end of message stream. Close
		 * connection.
		 */
		try {
			queueConnection = queueConnectionFactory.createQueueConnection();
			queueSession = queueConnection.createQueueSession(false,
					Session.AUTO_ACKNOWLEDGE);
			queueReceiver = queueSession.createReceiver(queue);
			
			queueConnection.start();
			while (true) {
				Message m = queueReceiver.receive(1);
				if (m != null) {
					if (m instanceof TextMessage) {
						message = (TextMessage) m;
						System.out.println("Reading message: "
								+ message.getText());
					} else {
						break;
					}
				}
			}
		} catch (JMSException e) {
			System.out.println("Exception occurred: " + e.toString());
		} finally {
			if (queueConnection != null) {
				try {
					queueConnection.close();
				} catch (JMSException e) {
				}
			}
		}
	}
}
