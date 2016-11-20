package patterns.structural.proxy.geoExample;

public class GeoCodeClient {
	
	public static void main(String[] args) {
		
		GeoProxy proxy = new GeoProxy();
		System.out.println(proxy.getLatLong("Amsterdam"));
		System.out.println(proxy.getLatLong("London"));
		System.out.println(proxy.getLatLong("Amsterdam"));
		
	}
}
