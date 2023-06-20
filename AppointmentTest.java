package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.Appointment;

class AppointmentTest { 

	@Test
	void testGetAppointmentID() {
		Appointment appointmentTest = new  Appointment ("Party1", "05/05/9999", "Birthday Party");
		String results = appointmentTest.getAppointmentID();
		assertEquals("Party1", results);
	} 
	
	@Test
	void testAppointmentIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment (null, "05/05/9999", "Birthday Party");
		});
	}
	
	@Test
	void testAppointmentIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment ("Party111111", "05/05/9999", "Birthday Party");
		});
	}
	
	@Test
	void testAppointmentDateNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment ("Party1", null, "Birthday Party");
		});
	}
	
	@Test
	void testAppointmentDateBefore() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment ("Party1", "05/05/1168", "Birthday Party");
		});
	}
	
	@Test
	void testGetAppointmentDescription() {
		Appointment appointmentTest = new Appointment ("Party1", "05/05/9999", "Birthday Party");
		String results = appointmentTest.getAppointmentDescription();
		assertEquals("Birthday Party", results);
	} 
	
	@Test
	void testAppointmentDescriptionNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment ("Party1", "05/05/9999", null);
		});
	}
	
	@Test
	void testAppointmentDescriptionTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment ("Party1", "05/05/9999", "Greatest Birthday Party of the year. Make sure to come early because it is a surprise party.");
		});
	}	 

}
