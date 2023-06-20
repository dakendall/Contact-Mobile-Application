package contactServices;
import java.util.ArrayList;
import java.util.Iterator;

import contact.Contact;

public class ContactService {
	public ArrayList<Contact> contactService = new ArrayList<Contact>();
	
	public void addingContact(String contactID, String firstName, String lastName, String phone, String address) {
		Contact newContact = new Contact(contactID, firstName, lastName, phone, address);
		
		if(contactService.contains(newContact)) {
			//contact id is already in the arraylist
			throw new IllegalArgumentException ("The Contact ID is already in the system");
		} else {
			//add new contact
			contactService.add(newContact);
		}
	}
	
	public void deleteContact(String contactID) {
		
		Iterator<Contact> itr = contactService.iterator();
		while(itr.hasNext() ) {
			Contact contact = itr.next();
			if (contact.getContactID().equals(contactID)) {
				itr.remove();
				return;
			}
		}
		
		throw new IllegalArgumentException ("The Contact ID is not in the system");
	}
	
	public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
		
		Iterator<Contact> itr = contactService.iterator();
		
		while(itr.hasNext() ) {
			Contact contact = itr.next();
			if (contact.getContactID().equals(contactID)) {
				contact.setFirstName(firstName);
				contact.setLastName(lastName);
				contact.setPhone(phone);
				contact.setAddress(address);
				return;
			}
		}
		
		throw new IllegalArgumentException ("The Contact ID is not in the system");
	}
}
