package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointmentService.AppointmentService;

class AppointmentServiceTest {


	@Test
	void testAddingAppointment() {
		AppointmentService appointmentTest = new AppointmentService ();
		appointmentTest.addingAppointment("Party1", "05/05/9999", "Geralt's Birthday Party");
		assertEquals(appointmentTest.appointmentService.size(), 1);
	}
	
	@Test
	void testAddingMultipleAppointments() {
		AppointmentService appointmentTest = new AppointmentService ();
		appointmentTest.addingAppointment("Party1", "05/05/9999", "Geralt's Birthday Party");
		appointmentTest.addingAppointment("Party2", "01/01/9999", "Vesemir's Birthday Party" );
		assertEquals(appointmentTest.appointmentService.size(), 2);
	}
	
	@Test
	void testExistingAppointment() {
		AppointmentService appointmentTest = new AppointmentService ();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		appointmentTest.addingAppointment("Party1", "05/05/9999", "Geralt's Birthday Party");
		appointmentTest.addingAppointment("Party1", "05/05/9999", "Geralt's Birthday Party");
		});
	}
	 
	@Test
	void testDeletingAppointment() {
		AppointmentService appointmentTest = new AppointmentService ();
		appointmentTest.addingAppointment("Party1", "05/05/9999", "Geralt's Birthday Party");
		appointmentTest.deleteAppointment("Party1");
		assertEquals(appointmentTest.appointmentService.size(), 0);
	}
	
	@Test
	void testDeletingNonExistingAppointment() {
		AppointmentService appointmentTest = new AppointmentService ();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		appointmentTest.deleteAppointment("Party1");
		});
	}
}
