package networking;

import java.io.IOException;
import java.net.ServerSocket;

public class AnyServerListeningOnPort {

	public static void main(String args[]) throws IOException {
	
		for(int i=1;i<=1000;i++){
			try{
				ServerSocket s = new ServerSocket(i);
				}
			catch(java.net.BindException e){
				//e.printStackTrace();
				System.out.println("There is a  server on port: " + i + "  of local host");
			}
		}
			System.out.println("Scan complete");
	}
}
