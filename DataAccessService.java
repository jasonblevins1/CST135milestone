package contact;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class DataAccessService {
	public static List<BaseContact> read(){
		
		ArrayList<BaseContact> contacts = new ArrayList<>();
		contacts.add(new PersonContact("Kevin", "12/12/1212", "123456789", "cool", 1, null, null));
		contacts.add(new PersonContact("Bob", "12/12/1212", "123456789", "cool", 2, null, null));
		contacts.add(new PersonContact("Andrew", "12/12/1212", "123456789", "cool", 3, null, null));
		
		
		try {
			FileInputStream fis = new FileInputStream("contact.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			contacts =(ArrayList<BaseContact>) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return contacts;
		
	}

	public static void write(List<BaseContact> items) {
		
		try {
			FileOutputStream fos = new FileOutputStream("contact.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(items);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
