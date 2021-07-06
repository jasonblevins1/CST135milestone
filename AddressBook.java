package contact;
import java.util.ArrayList;
import java.lang.ClassCastException;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	
	List<BaseContact> baseContact = new ArrayList<>();
	
	Scanner scan = new Scanner(System.in);
	
	public void open() {
		
		baseContact = DataAccessService.read();
		menu();
		
	}
	
	public void menu() {
		do {
			System.out.println("====================================");
			System.out.println("-------------MAIN MENU--------------");
			System.out.println("====================================");
			System.out.println(" 1. Add a Personal Contact (C)");	
			System.out.println(" 2. Add a Business Contact (C)");		
			System.out.println(" 3. Show all Contacts (R)");
			System.out.println(" 4. Show Details of One Contact (R)");
			System.out.println(" 5. Update a Contact (U)");	
			System.out.println(" 6. Delete a Contact (D)");	
			System.out.println(" 7. Search for a Contact by Name (R)");
			System.out.println(" 8. Sort all Contacts by Name (R)");
			System.out.println(" 9. Exit");		
			System.out.println("====================================");
			System.out.println("---Select an operation to preform---");
			System.out.println("====================================");
			int option = scan.nextInt();
			scan.nextLine();

			switch (option) {
			case 1:
				addPersonContact();
				break;
				
			case 2:
				addBusinessContact();
				break;
				
			case 3:
				viewAllContacts(); 
				break;
				
			case 4:
				showOneContact(); 
				break;
				
			case 5:
				updateAContact();
				break;
				
			case 6:
				deleteAContact();
				break;
				
			case 7:
				searchContacts(); 
				break;
				
			case 8:
				sortContacts(); 
				break;
				
			case 9:
				System.out.println("Goodbye!");
				DataAccessService.write(baseContact);
				System.exit(0);
				break;
				
			default:
				System.out.println("Please enter different option");
			}
		}while (true);
		
	}

	private void showOneContact() {
		System.out.println("====================================");
		System.out.println("------------LIST DETAILS------------");
		System.out.println("====================================");
		viewAllContacts(); 
		System.out.println("Select a contact to view");
		int item = scan.nextInt();
		scan.nextLine();
		System.out.println("Name: \t" + baseContact.get(item - 1).getName());
		System.out.println("Phone: \t" + baseContact.get(item - 1).getPhone());
		System.out.println("Contact ID: \t" + baseContact.get(item - 1).getContactId());
		System.out.println("Photo: \t" + baseContact.get(item - 1).getPhoto());
		System.out.println("Location: \t" + baseContact.get(item - 1).getLocation());
		if (baseContact.get(item - 1) instanceof PersonContact) {
			System.out.println("Date of Birth: \t" + ((PersonContact)baseContact.get(item - 1)).getDob());
			System.out.println("Description: \t" + ((PersonContact)baseContact.get(item - 1)).getDescription());
		}
		else if (baseContact.get(item - 1) instanceof BusinessContact) {
			System.out.println("Hours of Operation: " + ((BusinessContact)baseContact.get(item - 1)).getHours());
			System.out.println("URL: " + ((BusinessContact)baseContact.get(item - 1)).getUrl());
		}
		
		
		
	}

	private void sortContacts() {
		System.out.println("====================================");
		System.out.println("--------------SORT LIST-------------");
		System.out.println("====================================");
		ComparatorName cn = new ComparatorName();
		baseContact.sort(cn);
		viewAllContacts();
		System.out.println("\n");
		
	}

	private void searchContacts() {
		System.out.println("====================================");
		System.out.println("-------------SEARCH LIST------------");
		System.out.println("====================================");
		System.out.println("Who do you wish to search for? ");
		String search = scan.nextLine();
		
		int counter = 1;
		
		for (BaseContact bc : baseContact) {
			if (bc.getName().toUpperCase().contains(search.toUpperCase()))
				System.out.println(counter++ + ". " + bc.toString());
		}
		System.out.println("\n");
	}

	private void deleteAContact() {
		System.out.println("====================================");
		System.out.println("-------------DELETE MENU------------");
		System.out.println("====================================");
		viewAllContacts();
		System.out.println("====================================");
		System.out.println("What item to delete? ");
		int contactId = scan.nextInt();
		scan.nextLine();
		baseContact.remove(contactId - 1);
		System.out.println("Deleted" + "\n");
		viewAllContacts();
		System.out.println("\n");
		
	}

	private void updateAContact() {
		System.out.println("====================================");
		System.out.println(" -------------UPDATE MENU-----------");
		System.out.println("====================================");
		viewAllContacts();
		System.out.println("====================================");
		System.out.println("What contact to update? ");
		int contact = scan.nextInt();
		scan.nextLine();
		
		if (baseContact.get(contact) instanceof PersonContact) {
			updatePersonContact(contact);
		}
		else if (baseContact.get(contact) instanceof BusinessContact) {
			updateBusinessContact(contact);
		}
		
		else {
			System.out.println("I do not recognize that contact id");
		}
	
		updateBusinessContact(contact);
		updatePersonContact(contact);

	}

	private void updateBusinessContact(int contact) {
		// TODO Auto-generated method stub
		System.out.println("====================================");
		System.out.println(" -------------UPDATE MENU-----------");
		System.out.println("====================================");
		
		
		System.out.println("Provide contact name: " + baseContact.get(contact - 1).getName());
		String name = scan.nextLine();
		baseContact.get(contact - 1).setName(name);
		
		System.out.println("Provide contact's Phone: " + baseContact.get(contact - 1).getPhone());
		String phone = scan.nextLine();
		baseContact.get(contact - 1).setPhone(phone);
		
		System.out.println("Provide a contact id: " + baseContact.get(contact - 1).getContactId());
		int contactId = scan.nextInt();
		baseContact.get(contact - 1).setContactId(contactId);
		scan.nextLine();
		
		System.out.println("Hours of Operation: " + ((BusinessContact)baseContact.get(contact - 1)).getHours());
		String hours = scan.nextLine();
		((BusinessContact)baseContact.get(contact - 1)).setHours(hours);
		
		System.out.println("Url: " + ((BusinessContact)baseContact.get(contact - 1)).getUrl());
		String url = scan.nextLine();
		((BusinessContact)baseContact.get(contact - 1)).setUrl(url);
		
		menu();
	}

	private void updatePersonContact(int contact) {
		// TODO Auto-generated method stub
		System.out.println("====================================");
		System.out.println(" -------------UPDATE MENU-----------");
		System.out.println("====================================");
		
		
		System.out.println("Provide contact name: " + baseContact.get(contact - 1).getName());
		String name = scan.nextLine();
		baseContact.get(contact - 1).setName(name);
		
		System.out.println("Provide contact's Phone: " + baseContact.get(contact - 1).getPhone());
		String phone = scan.nextLine();
		baseContact.get(contact - 1).setPhone(phone);
		
		System.out.println("Provide a contact id: " + baseContact.get(contact - 1).getContactId() + "]");
		int contactId = scan.nextInt();
		baseContact.get(contact - 1).setContactId(contactId);
		scan.nextLine();

		System.out.println("Provide the contact's Date of Birth: " + ((PersonContact)baseContact.get(contact - 1)).getDob());
		String dob = scan.nextLine();
		((PersonContact)baseContact.get(contact - 1)).setDob(dob);
		
		System.out.println("Provide a contact Description: " + ((PersonContact)baseContact.get(contact - 1)).getDescription());
		String description = scan.nextLine();
		((PersonContact)baseContact.get(contact - 1)).setDescription(description);
		
		menu();
	}

	private void viewAllContacts() {
		
		System.out.println("====================================");
		System.out.println("-------------READ MENU--------------");
		System.out.println("====================================");

		int counter = 1;
		
		for (BaseContact bc : baseContact) {
			System.out.println(counter++ + ". " + bc.toString());
		}
		System.out.println("\n");
			
	}

	private void addBusinessContact() {
		
		System.out.println("====================================");
		System.out.println("------------CREATE MENU-------------");
		System.out.println("====================================");

		System.out.println("Add Contact Name: ");
		String name = scan.nextLine();
		
		System.out.println("Add Contact Phone Number: ");
		String phone = scan.nextLine();
		
		System.out.println("Add Hours of Operation: ");
		String hours = scan.nextLine();
		
		System.out.println("Add Website URL: ");
		String url = scan.nextLine();
		
		System.out.println("Add a Description: ");
		String description = scan.nextLine();
		
		System.out.println("Add Contact Id: ");
		int contactId = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Do you want to add a Photo and Location? [Yes, No]");	 //yes
		String needPhoto = scan.nextLine().toUpperCase();
		if (needPhoto.equals("YES") || needPhoto.equals("Y") ) {
			
			System.out.println("Provide a file name: ");
			String fileName = scan.nextLine();
			
			System.out.println("Provide the date of the photo: ");
			String dop = scan.nextLine();
			
			System.out.println("Provide a description: ");
			String phodescription = scan.nextLine();
			
			System.out.println("Provide a photo id: ");
			int photoId = scan.nextInt();
			scan.nextLine();
			Photo photo = new Photo(fileName, dop, phodescription, photoId);
			
				System.out.println("Let's add the location of this Contact.");
				System.out.println("Provide the Street Number: ");
				int streetNumber = scan.nextInt();
				scan.nextLine();
				
				System.out.println("Provide the Street Name: ");
				String streetName = scan.nextLine();
				
				System.out.println("Provide the City: ");
				String city = scan.nextLine();
				
				System.out.println("Provide the State: ");
				String state = scan.nextLine();
				
				System.out.println("Provide a Location id: ");
				int locationId = scan.nextInt();
				scan.nextLine();	
				
				
			Location location = new Location (streetNumber, streetName, city, state, locationId);
			
			baseContact.add(new BusinessContact(name, phone, hours , url, description, contactId, photo, location));
			System.out.println("\n");
		}
		else {
			baseContact.add(new BusinessContact(name, phone, hours , url, description, contactId, null, null));
			System.out.println("\n");
		}	
		
		
		
	}
	

	private void addPersonContact() {
		System.out.println("====================================");
		System.out.println("-------------CREATE MENU------------");
		System.out.println("====================================");

		System.out.println("Add Contact Name: ");
		String name = scan.nextLine();
		
		System.out.println("Add Contact Phone Number: ");
		String phone = scan.nextLine();
		
		System.out.println("Add Contact Date of Birth (MM/DD/YYYY): ");
		String dob = scan.nextLine();
		
		System.out.println("Add a Description: ");
		String description = scan.nextLine();
		
		System.out.println("Add Contact Id: ");
		int contactId = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Do you want to add a Photo and Location?? [Yes, No]");	 //yes
		String needPhoto = scan.nextLine().toUpperCase();
		if (needPhoto.equals("YES") || needPhoto.equals("Y") ) {
			
			System.out.println("Provide a file name: ");
			String fileName = scan.nextLine();
			
			System.out.println("Provide the date of the photo: ");
			String dop = scan.nextLine();
			
			System.out.println("Provide a description: ");
			String phodescription = scan.nextLine();
			
			System.out.println("Provide a photo id: ");
			int photoId = scan.nextInt();
			
			Photo photo = new Photo(fileName, dop, phodescription, photoId);
			System.out.println("\n");
			System.out.println("Let's add the location for this Contact.");
			System.out.println("\n");
			System.out.println("Provide the Street Number: ");
			int streetNumber = scan.nextInt();
			scan.nextLine();
			
			System.out.println("Provide the Street Name: ");
			String streetName = scan.nextLine();
			
			System.out.println("Provide the City: ");
			String city = scan.nextLine();
			
			System.out.println("Provide the State: ");
			String state = scan.nextLine();
			
			System.out.println("Provide a Location id: ");
			int locationId = scan.nextInt();
			scan.nextLine();
			
			Location location = new Location (streetNumber, streetName, city, state, locationId);
			
			baseContact.add(new PersonContact(name, dob, phone, description , contactId, photo, location));
			System.out.println("\n");
		}
		else {
			baseContact.add(new PersonContact(name, dob, phone, description , contactId, null, null));
			System.out.println("\n");
		}	
	}

		
		
		
	}
