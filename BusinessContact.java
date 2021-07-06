package contact;
import java.io.Serializable;


public class BusinessContact extends BaseContact implements Serializable{
	
	private String hours;
	private String url;
	
	
	public BusinessContact(String name, String phone, String hours, String url, String description, int contactId, Photo photo, Location location) {
		super(contactId, name, phone, photo, location);
		this.hours = hours;
		this.url = url;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "BusinessContact: " + super.toString() + "\n" + " - Hours of Operation: " + hours + "\n" + " - URL: " + url + "\n";
	}

	

}
