package patterns.structural.proxy.geoExample;

public class GeoCoder {

	public String getLatLong(String address){
		 if (address.equals("Amsterdam")) {
	            return "52.3700° N, 4.8900° E";
	        } else if (address.equals("London")) {
	            return "51.5171° N, 0.1062° W";
	        } else if (address.equals( "Paris")) {
	            return "48.8742° N, 2.3470° E";
	        } else if (address.equals( "Berlin")) {
	            return "52.5233° N, 13.4127° E";
	        } else {
	            return "";
	        }
	}
}
