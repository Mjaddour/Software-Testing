package appointment_service;

import java.util.ArrayList;

public class AppointmentService {
    private ArrayList<Appointment> appointments;
    
    
    public AppointmentService() {
    	appointments = new ArrayList<>();
    }
    
    public boolean add(String appointmentID, String appointmentDatefield, String description) {
        for (Appointment existingAppointment : appointments) {
            if (existingAppointment.getappointmentID().equals(appointmentID)) {
                System.out.println("Error, Appointment ID already exists.");
                return false;
            }
        }
        Appointment newAppointment = new Appointment(appointmentID, appointmentDatefield, description);
        appointments.add(newAppointment);
        
        System.out.println("Appointment added using ID.");
        return true;
    }


    
    public boolean delete(String appointmentID) {
        for (Appointment a : appointments ) {
        	if (a.getappointmentID().equals(appointmentID)) {
        		appointments.remove(a);
        		System.out.println("Appointment ID Deleted.");
        		return true;
        	}
        }
        
        		System.out.println("Error, appointment ID not found.");
        		return false;
        	}
        
    }
 
