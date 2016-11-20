package networking.rmi.example.client;

import java.rmi.RemoteException;
import java.util.Enumeration;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;

import networking.rmi.example.services.IWarehouse;


public class WarehouseClient {
	public static void main(String[] args) throws NamingException, RemoteException{
		Context namingContext = new InitialContext();
	
		System.out.print("RMI registry bindings: ");
		Enumeration<NameClassPair> e = namingContext.list("rmi://localhost/");
		while (e.hasMoreElements())
			System.out.println(e.nextElement().getName());

		String url = "rmi://localhost/central_warehouse";
		IWarehouse centralWarehouse = (IWarehouse) namingContext.lookup(url);
		
		
		double price = centralWarehouse.getPrice("Blackwell Toaster");
		System.out.println("price = " + price);
	}

}
