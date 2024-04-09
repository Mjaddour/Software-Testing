package appointment_service;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

class AppointmentTest {

    @Test
    void validEntry() {
        Appointment appointment = new Appointment("1", "05-23-2025", "I will arrive late");
        assertEquals("1", appointment.getappointmentID());
        assertEquals("05-23-2025", appointment.getappointmentDatefield());
        assertEquals("I will arrive late", appointment.getdescription());
    }

    @Test
    void invalidAppointmentID() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("111111111111111", "05-23-2025", "I will be late"));
    }

    @Test
    void invalidAppointmentIDNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment(null, "05-23-2025", "I will be late"));
    }

    @Test
    void appointmentIDNotUpdatable() {
        Appointment appointment = new Appointment("1", "10-10-2025", "I will arrive late");
        assertMethodNotPresent(Appointment.class, "setAppointmentID");

        assertEquals("1", appointment.getappointmentID());
        assertEquals("10-10-2025", appointment.getappointmentDatefield());
        assertEquals("I will arrive late", appointment.getdescription());
    }

    @Test
    void invalidAppointmentDatefieldNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("1", null, "I will not be able to make it"));
    }

    @Test
    void invalidAppointmentDatefieldPast() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("1", "05-23-2023", "I will not be able to make it"));
    }

    @Test
    void invalidDescription() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("1", "05-23-2030", "Hi there i will not be able to arrive on time can you "
                        + "can you please make sure i'm still on the list to make sure i keep my spot "
                        + "i hope you can read my message, is important for me to attend this appointment. "));
    }

    @Test
    void invalidDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment("1", "03-12-2030", null));
    }
    @Test 
    void invalidDateFormat () {
    	assertThrows(IllegalArgumentException.class, () -> 
    	new Appointment("1","12-2025","I will be able to make it."));
    }
    
    private void assertMethodNotPresent(Class<?> clazz, String methodName) {
        try {
            Method method = clazz.getMethod(methodName);
            fail("Method " + methodName + " should not be present");
        } catch (NoSuchMethodException e) {
        }
    }
}
