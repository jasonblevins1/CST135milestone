package contact;
import java.io.Serializable;

public class PersonContact extends BaseContact implements Serializable{
	
	private String dob;
	private String description;
	
	
	public PersonContact(String name, String dob, String phone, String description, int contactId, Photo photo, Location location) {
		super(contactId, name, phone, photo, location);
		this.dob = dob;
		this.description = description;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "PersonContact: " + super.toString() + "\n" + " - Date of Birth: " + dob + "\n" + " - Description: " + description + "\n";
	}


	


	
	}
