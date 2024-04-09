package appointment_service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;




class AppointmentServiceTest {

	@Test
	void addAppointmetID() {
		AppointmentService appointmentService = new AppointmentService();
		Appointment appointment = new Appointment("001","05-23-2025","I would like to have it in this day.");
		assertTrue(appointmentService.add("001","05-23-2025","I would like to have it in this day."));
	}
    @Test
    void addExistingAppointmentIDInvalid() {
    	AppointmentService appointmentService = new AppointmentService();
    	Appointment appointment = new Appointment("002","05-23-2025","I will be on time.");
    	assertTrue(appointmentService.add("002","05-23-2025","I will be on time."));
    	assertFalse(appointmentService.add("002","05-23-2025","I will be on time."));
    }
    @Test
    void deletingAppointmentID() {
    	AppointmentService appointmentService = new AppointmentService();
    	Appointment appointment = new Appointment("003","05-23-2025","I will be on time, and i go my Mo.");
    	assertTrue(appointmentService.add("003","05-23-2025","I will be on time."));
    	assertTrue(appointmentService.delete("003"));
    }
    @Test
    void deletingNonExistingAppointmentIDInvalid() {
    	AppointmentService appointmentService = new AppointmentService();
    	Appointment appointment = new Appointment("004","05-23-2025","I will be on time.");
    	assertFalse(appointmentService.delete("001"));
    }
}









