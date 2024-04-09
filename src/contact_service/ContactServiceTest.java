package contact_service;


import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class ContactServiceTest {

    @Test
    public void testMethodAddPass() {
        ContactService contactService = new ContactService();
        Contact contact1 = new Contact("001", "Mohamed", "Jaddour", "3162730234", "Wichita st, KS");
        assertEquals(true, contactService.add(contact1));
     
        
    }

    @Test
    public void testMethodAddFail() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("001", "Mohamed", "Jaddour", "3162730234", "Wichita st, KS");
        assertEquals(true, contactService.add(contact));
        assertEquals(false, contactService.add(contact));
    }

    @Test
    public void testMethodDeletePass() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("001", "Mohamed", "Jaddour", "3162730234", "Wichita st, KS");
        assertEquals(true, contactService.add(contact));
        assertEquals(true, contactService.remove("001")); 
    }

    @Test
    public void testMethodDeleteFail() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("001", "Mohamed", "Jaddour", "3162730234", "Wichita st, KS");
        assertEquals(true, contactService.add(contact));
        assertEquals(false, contactService.remove("002")); 
    }

    @Test
    public void testUpdatePass() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("001", "Mohamed", "Jaddour", "3162730234", "Wichita st, KS");
        assertEquals(true, contactService.add(contact));
        assertEquals(true, contactService.update("001", "James", "Stone", "3167891023", "123 West Ave")); 
    }

    @Test
    public void testUpdateFail() {
        ContactService contactService = new ContactService();
        Contact contact = new Contact("001", "Mohamed", "Jaddour", "3162730234", "Wichita st, KS");
        assertEquals(true, contactService.add(contact));
        assertEquals(false, contactService.update("002", "Jake", "Mark", "3162341900", "123 West Ave"));
    }
}
