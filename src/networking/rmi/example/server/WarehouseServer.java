package networking.rmi.example.server;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Start the server
 * 
 * Run the rmi registry before running this program.
 * 
 * Open a command window.
 * 
 * Go to the directory which has the all class files(This step is IMPORTANT)
 * 
 * run: rmiregistry
 * 
 * rmiregistry comes with the JRE/JDK. If there is problem running the registry,
 * check the JAVA_HOME
 * 
 * 
 * @author chq-vasanthakumars
 * 
 */
public class WarehouseServer {
	public static void main(String[] args) throws RemoteException,
			NamingException {
		System.out.println("Constructing server implementation");

		WarehouseImpl centralWarehouse = new WarehouseImpl();

		System.out.println("Binding server implementation to registry");
		Context namingContext = new InitialContext();

		namingContext.rebind("rmi:central_warehouse", centralWarehouse);

		System.out.println("Waiting for invocations from client");
	}

}
