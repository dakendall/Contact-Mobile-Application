package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	@Test
	void testContact() {
		Contact contactTest = new Contact ("Witcher1", "Geralt", "Rivia", "6666666666", "666 KaerMorhen Kaedwen Kingdom");
		assertTrue(contactTest.getContactID().equals("Witcher1"));
		assertTrue(contactTest.getFirstName().equals("Geralt"));
		assertTrue(contactTest.getLastName().equals("Rivia"));
		assertTrue(contactTest.getPhone().equals("6666666666"));
		assertTrue(contactTest.getAddress().equals("666 KaerMorhen Kaedwen Kingdom"));
	}
	
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Witcher1111", "Geralt", "Rivia", "6666666666", "666 KaerMorhen Kaedwen Kingdom" );
		});
	}
	
	@Test
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Geralt", "Rivia", "6666666666", "666 KaerMorhen Kaedwen Kingdom" );
		});
	}

	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Witcher1", "Geraltttttt", "Rivia", "6666666666", "666 KaerMorhen Kaedwen Kingdom" );
		});
	}
	
	@Test
	void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Witcher1", null, "Rivia", "6666666666", "666 KaerMorhen Kaedwen Kingdom" );
		});
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Witcher1", "Geralt", "Riviaaaaaaa", "6666666666", "666 KaerMorhen Kaedwen Kingdom" );
		});
	}
	
	@Test
	void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Witcher1", "Geralt", null, "6666666666", "666 KaerMorhen Kaedwen Kingdom" );
		});
	}
	
	@Test
	void testPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Witcher1", "Geralt", "Rivia", "66666666666", "666 KaerMorhen Kaedwen Kingdom" );
		});
	}
	
	@Test
	void testPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Witcher1", "Geralt", "Rivia", null, "666 KaerMorhen Kaedwen Kingdom" );
		});
	}
	
	@Test
	void testPhoneNotDigits() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Witcher1", "Geralt", "Rivia", "6666d66666", "666 KaerMorhen Kaedwen Kingdom" );
		});
	}
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Witcher1", "Geralt", "Rivia", "6666666666", "666 KaerMorhen Kaedwen Kingdom 66666" );
		});
	}
	
	@Test
	void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Witcher1", "Geralt", "Rivia", "6666666666", null );
		});
	}
}
