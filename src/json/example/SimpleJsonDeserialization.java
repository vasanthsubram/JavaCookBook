package json.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SimpleJsonDeserialization {

							//"{"name":"AUDI","price":"30000","carModel":2014}"
	 static String carStr = "{\"name\":\"AUDI\",\"price\":\"30000\",\"carModel\":2014}";

	 static String dealerStr = "{\"cars\": [{\"name\":\"AUDI\",\"price\":\"30000\",\"carModel\":2014}]}";
	 
		public static void main(String[] args) throws Exception, JsonMappingException, IOException {
			 ObjectMapper mapper = new ObjectMapper();
		        Car car = mapper.readValue(carStr, Car.class);
		        Dealership garage = mapper.readValue(dealerStr, Dealership.class);
		}
}
	
		class Dealership{
			 @JsonProperty
			List<Car> cars;
		}
		
		 class Car {
		 
		    @JsonProperty
		    private String name;
		 
		    @JsonProperty("carModel")
		    private int model;
		 
		    @JsonProperty
		    private String price;
		}
