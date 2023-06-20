package appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
	private String appointmentID;
	private Date appointmentDate;
	private String appointmentDescription;
	private String inputDate;
	
	public Appointment (String appointmentID, String inputDate, String appointmentDescription) {
		setAppointmentID(appointmentID); 
		setAppointmentDate(inputDate); 
		setAppointmentDescription(appointmentDescription);
	}
	
	private void setAppointmentID (String appointmentID) {
		if (appointmentID == null || appointmentID.length() > 10 ) {
			throw new IllegalArgumentException("Invalid Appointment ID");
		} else {
			this.appointmentID = appointmentID;
		}
	}
	
	public String getAppointmentID () {
		return appointmentID;
	}
	
	public void setAppointmentDate (String inputDate) {
		
		try {
			
			if (inputDate == null) {
				throw new IllegalArgumentException("Invalid Appointment Date");
			}
			
			Date today = new Date();
			Date userDate = new SimpleDateFormat("dd/MM/yyy").parse(inputDate);
						
			 if (today.before(userDate)) {
				appointmentDate = userDate;
			} else {
				throw new IllegalArgumentException("Invalid Appointment Date");
			}
			
		} catch (ParseException e) {
			throw new IllegalArgumentException("Invalid Appointment Date");
		}
		
			
	}
	
	public Date getAppointmentDate() {
		return appointmentDate; 
	}
	
	public void setAppointmentDescription(String appointmentDescription) {
		if (appointmentDescription == null || appointmentDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Appointment Description");
		} else {
			this.appointmentDescription = appointmentDescription; 
		}
	}
	
	public String getAppointmentDescription() {
		return appointmentDescription;
	}
	
	@Override
	public boolean equals(Object o) {
		//exact same object so they're equal
		if (o == this) {
			return true;
		}
		
		//if o isn't an appointment, not equal
		if (!(o instanceof Appointment)) {
			return false;
		}
		
		//Cast o as an appointment
		Appointment c = (Appointment) o;
		
		//check if the appointment is equal
		return this.getAppointmentID().equals(c.getAppointmentID());
	}
	
}
