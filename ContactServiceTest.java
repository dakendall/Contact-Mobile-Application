package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactServices.ContactService;

class ContactServiceTest {

	@Test
	void testAddingContact() {
		
		//adding multiple contacts
		ContactService contactTest = new ContactService ();
		contactTest.addingContact("Witcher1", "Geralt", "Rivia", "6666666666", "666 KaerMorhen Kaedwen Kingdom" );
		contactTest.addingContact("Witcher2", "Vesemire", "Witcher", "9999999999", "666 KaerMorhen Kaedwen Kingdom" );
		assertEquals(contactTest.contactService.size(), 2);
	}
	
	@Test
	void testExistingContact() {
		ContactService contactTest = new ContactService ();
		
		//adding contact w/ same id # 
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactTest.addingContact("Witcher1", "Geralt", "Rivia", "6666666666", "666 KaerMorhen Kaedwen Kingdom" );
		contactTest.addingContact("Witcher1", "Geralt", "Rivia", "6666666666", "666 KaerMorhen Kaedwen Kingdom"); 
		});
	}
	
	@Test
	void testDeleteContact() {
		ContactService contactTest = new ContactService();
		contactTest.addingContact("Witcher1", "Geralt", "Rivia", "6666666666", "666 KaerMorhen Kaedwen Kingdom" );
		
		//delete contact
		contactTest.deleteContact("Witcher1");
		assertEquals(contactTest.contactService.size(), 0);
		
		//testing contact that doesn't exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactTest.deleteContact("Witcher1");
		});
	}
	

	@Test
	void testUpdatingContact() {
		ContactService contactTest = new ContactService ();
		contactTest.addingContact("Witcher1", "Geralt", "Rivia", "6666666666", "666 KaerMorhen Kaedwen Kingdom" );
		
		//update contact
		contactTest.updateContact("Witcher1", "Vesemir", "Witcher", "9999999999", "666 KaerMorhen Kaedwen Kingdom"); 
		assertEquals(contactTest.contactService.size(), 1);
		
		//testing contact that doesn't exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactTest.deleteContact("Witcher2");
		});
	} 
	
	@Test
	void testDeletingNonExistingContact() {
		ContactService contactTest = new ContactService ();
		
		//testing contact that doesn't exist
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		contactTest.deleteContact("Witcher1");
		});

}
}
