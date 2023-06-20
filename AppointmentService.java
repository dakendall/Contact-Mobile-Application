package appointmentService;

import java.util.ArrayList;
import java.util.Iterator;

import appointment.Appointment;

public class AppointmentService {
	public ArrayList<Appointment> appointmentService = new ArrayList<Appointment>(); 
	
	public void addingAppointment (String appointmentID, String appointmentDate, String appointmentDescription) {
		Appointment newAppointment = new Appointment (appointmentID, appointmentDate, appointmentDescription);
		
		if (appointmentService.contains(newAppointment)) {
			throw new IllegalArgumentException ("The Appointment ID is already in the system");
		} else {
			appointmentService.add(newAppointment);
		}
	}
	
	public void deleteAppointment(String appointmentID) {
		Iterator<Appointment> itr = appointmentService.iterator();
		while(itr.hasNext() ) {
			Appointment appointment = itr.next();
			if (appointment.getAppointmentID().equals(appointmentID)) {
				itr.remove();
				return;
			}
		}
		
		throw new IllegalArgumentException ("The Appointment ID is not in the system");
	}
}
