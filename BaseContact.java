package contact;
import java.io.Serializable;

public class BaseContact implements Serializable{
	
	int contactId;
	private String name;
	private String phone;
	private Photo photo;
	private Location location;
	
	
	public BaseContact(int contactId, String name, String phone, Photo photo, Location location) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.phone = phone;
		this.photo = photo;
		this.location = location;
	}
	@Override
	public String toString() {
		return name + "\n" + " - Phone: " + phone + "\n" + " - Photo: " + photo
				+ "\n" + " - Location=" + location +  "\n" + " - Contact ID: " + contactId;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
