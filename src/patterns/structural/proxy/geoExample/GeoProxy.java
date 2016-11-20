package patterns.structural.proxy.geoExample;

import java.util.HashMap;
import java.util.Map;

/*
 * The proxy object is called GeoProxy. 
 * It is known that many repeated requests (for the same location) are coming in. 
 * To speed things up GeoProxy caches frequently requested locations. 
 * If a location is not already cached it goes out to the real GeoCoder service and stores the results in cache.
 */
public class GeoProxy {

	GeoCoder geoCoder = new GeoCoder();
	Map<String,String> geoCache = new HashMap<String,String>();
	
	public String getLatLong(String address){
		String geoCode;
		geoCode=geoCache.get(address);
		 if(geoCode==null){
			 geoCode=geoCoder.getLatLong(address);
			 geoCache.put(address, geoCode);
		 }
		 return geoCode;
	}
}
