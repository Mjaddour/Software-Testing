package appointment_service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Appointment {
	private String appointmentID;
    private String appointmentDatefield;
    private String description;
    
public Appointment(String appointmentID, String appointmentDatefield, String description) {
	if (appointmentID == null || appointmentID.length() > 10 ) {
		throw new IllegalArgumentException("Invalid Appointment ID.");
    }
	if (appointmentDatefield == null || !isDateValid(appointmentDatefield)) {
		throw new IllegalArgumentException("Invalid Date.");
	}
	if (description == null || description.length() > 50 ) {
		throw new IllegalArgumentException("Invalid Description.");
	}

    this.appointmentID = appointmentID;
    this.appointmentDatefield = appointmentDatefield;
    this.description = description;

}
public String getappointmentID() {
    return appointmentID;
}

public String getappointmentDatefield() {
    return appointmentDatefield;
}

public String getdescription() {
    return description;
}

private boolean isDateValid (String date) {
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	dateFormat.setLenient(false);
	
	try {
		Date parseDate = dateFormat.parse(date);
		return !parseDate.before(new Date());
	}
	catch (ParseException e) {
		return false;
	}
 }
private Date parseDate(String date) {
	try {
		return new SimpleDateFormat("MM-dd-yyyy").parse(date);
	} catch (ParseException e) {
		throw new IllegalArgumentException("Invalid date format");
	}
}
}
