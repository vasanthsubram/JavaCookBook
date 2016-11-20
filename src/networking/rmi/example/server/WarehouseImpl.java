package networking.rmi.example.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import networking.rmi.example.services.IWarehouse;


public class WarehouseImpl extends UnicastRemoteObject implements IWarehouse{

	private Map<String,Double> prices;
	
	public WarehouseImpl() throws RemoteException{	
		prices = new HashMap<String, Double>();
		prices.put("Blackwell Toaster", 24.95);
		prices.put("ZapXpress Microwave oven", 49.95);
	}
	
	public double getPrice(String description) throws RemoteException{
		Double price=prices.get(description);
		return price==null?0:price;
	}

}
