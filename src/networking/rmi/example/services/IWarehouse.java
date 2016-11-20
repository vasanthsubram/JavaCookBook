package networking.rmi.example.services;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IWarehouse extends Remote{
	double getPrice(String description) throws RemoteException;
}
