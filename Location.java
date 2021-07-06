ackage contact;
import java.io.Serializable;

public class Location implements Serializable{
	
	int LocationId;
	private String streetName;
	int streetNumber;
	private String city;
	private String state;
	
	
	public int getLocationId() {
		return LocationId;
	}

	public void setLocationId(int locationId) {
		LocationId = locationId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Location(int streetNumber, String streetName, String city, String state, int LocationId) {
		super();
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
		this.LocationId = LocationId;
		
	}

	@Override
	public String toString() {
		return "Location: " + "\n" + " - " +streetNumber + " " + streetName + " " + city + " " + state + "\n" + " - Location Id: " + LocationId;
	}

}
