package contact;
import java.io.Serializable;

public class Photo implements Serializable{
	
	int PhotoId;
	private String fileName;
	private String dop;
	private String phodescription;
	
	public Photo(String fileName, String dop, String phodescription, int PhotoId) {
		super();
		this.fileName = fileName;
		this.dop = dop;
		this.PhotoId = PhotoId;
		this.phodescription = phodescription;
	}
	
	@Override
	public String toString() {
		return "\n" + " - File Name: " + fileName + "\n" + " - Date of Photo: " + dop + "\n" + " - Description: " + phodescription + "\n" + " - Photo Id: " + PhotoId;
	}
	
	public int getPhotoId() {
		return PhotoId;
	}

	public void setPhotoId(int photoId) {
		PhotoId = photoId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDop() {
		return dop;
	}

	public void setDop(String dop) {
		this.dop = dop;
	}

	public String getPhoDescription() {
		return phodescription;
	}

	public void setPhoDescription(String description) {
		this.phodescription = description;
	}

	
		
	

	


}
