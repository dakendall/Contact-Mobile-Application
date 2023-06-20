package contact;

public class Contact {	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact (String contactID, String firstName, String lastName, String phone, String address) {
		setContactID(contactID);
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);		
	}
	
	private void setContactID (String contactID) {
		//contact ID can't be null or longer than 10 chara
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID");
		} else {
			this.contactID = contactID;
		}
	}
	
	public String getContactID () {
		return contactID;
	}
	
	public void setFirstName (String firstName) {
		//First name can't be null or longer than 10 chara
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException ("Invalid First Name");
		} else {
			this.firstName = firstName;
		}
	}
	
	public String getFirstName () {
		return firstName;
	}
	
	public void setLastName (String lastName) {
		//Last name can't be null or longer than 10 chara
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException ("Invalid Last Name");
		} else {
			this.lastName = lastName;
		}
	}
	
	public String getLastName () {
		return lastName;
	}
	
	public void setPhone (String phone) {
		//Phone # must be 10 digits
		if (phone == null || phone.length() != 10 || phone.matches("^\\d{10}$") == false) {
			throw new IllegalArgumentException ("Invalid Phone Numer");
		} else {
			this.phone = phone;
		}
	}
	
	public String getPhone () {
		return phone;
	}
	
	public void setAddress (String address) {
		//Address can't be null or greater than 30 chara
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException ("Invalid Address");
		} else {
			this.address = address;
		}
	}
	
	public String getAddress () {
		return address;
	}
	
	@Override
	public boolean equals(Object o) {
		//exact same object so they're equal
		if (o == this) {
			return true;
		}
		
		//if o isn't a contact, not equal
		if (!(o instanceof Contact)) {
			return false;
		}
		
		//Cast o as a contact
		Contact c = (Contact) o;
		
		//check if contact is equal
		return this.getContactID().equals(c.getContactID());
	}
}
