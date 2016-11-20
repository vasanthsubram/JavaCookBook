package networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.URI;
import java.net.URISyntaxException;

import javax.net.ServerSocketFactory;

import org.apache.activemq.util.IOExceptionSupport;

public class ServerSocketTest {

	 protected ServerSocket serverSocket;
	 protected ServerSocketFactory serverSocketFactory= ServerSocketFactory.getDefault();

	 int backlog = 5000;
	 
	public static void main(String[] args) throws Exception{
		new ServerSocketTest().bind();

	}
	
	 public void bind() throws IOException, URISyntaxException {
	        URI bind = new URI("tcp://localhost:3000");
	       
	        String host = bind.getHost();
	        host = (host == null || host.length() == 0) ? "localhost" : host;
	        InetAddress addr = InetAddress.getByName(host);

	        try {

	            this.serverSocket = serverSocketFactory.createServerSocket(bind.getPort(), backlog, addr);
	            System.out.println("successfully created socket");
	            //configureServerSocket(this.serverSocket);
	            
	        } catch (IOException e) {
	            throw IOExceptionSupport.create("Failed to bind to server socket: " + bind + " due to: " + e, e);
	        }
	        finally{
	        	if(serverSocket!=null){
	        		serverSocket.close();
	        	}
	        }
	 }

}
