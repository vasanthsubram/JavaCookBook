package xml.jaxb.demo;

public class LocationImpl implements Location {

	private String street;
	private String zip;
	
	@Override
	public String getStreet() {
		return street;
	}

	@Override
	public String getZip() {
		return zip;
	}


	public void setStreet(String street) {
		this.street = street;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
	
	

}
