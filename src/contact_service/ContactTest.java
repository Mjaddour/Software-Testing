package contact_service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contact_service.Contact;

class ContactTest {

    @Test
    void validInput() {
        Contact contact = new Contact("1", "Mohamed", "Jaddour", "3033033333", "234 wichita st");
        assertEquals("1", contact.getContactID());
        assertEquals("Mohamed", contact.getFirstName());
        assertEquals("Jaddour", contact.getLastName());
        assertEquals("3033033333", contact.getPhoneNumber());
        assertEquals("234 wichita st", contact.getNumberAddress());
    }

    @Test
    void invalidId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "Mohamed", "Jaddour", "3033033333", "234 wichita st"));
    }
    @Test
    void invalidIdNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "Mohamed", "Jaddour", "3033033333", "234 wichita st"));
    }

    @Test
    void invalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Mohamed Mohamed Mohamed", "Jaddour", "3033033333", "234 wichita st"));
    }
    @Test
    void invalidFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", null, "Jaddour", "3033033333", "234 wichita st"));
    }

    @Test
    void invalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Mohamed", "Jaddour Jaddour Jaddour", "3033033333", "234 wichita st"));
    }
   
    @Test
    void invalidLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Mohamed", null, "3033033333", "234 wichita st"));
    }

    @Test
    void invalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Mohamed", "Jaddour", "123", "234 wichita st"));
    }
   
    @Test
    void invalidPhoneNumberNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Mohamed", "Jaddour", null, "234 wichita st"));
    }

    @Test
    void invalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Mohamed", "Jaddour", "3033033333", "234 wichita st 1234 1234 1234 1234 1234"));
    }
    
    @Test
    void invalidAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1", "Mohamed", "Jaddour", "3033033333", null));
    }
}