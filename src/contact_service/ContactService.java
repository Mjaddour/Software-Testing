package contact_service;

import java.util.ArrayList;

public class ContactService {
    private ArrayList<Contact> contacts;
    

    public ContactService() {
        contacts = new ArrayList<>();
    }

    public boolean add(Contact contact) {
        boolean alreadyPresent = false;
        for (Contact c : contacts) {
            if (c.equals(contact)) {
                alreadyPresent = true;
            }
        }
        if (!alreadyPresent) {
            contacts.add(contact);
            System.out.println("Contact Added Successfully!");
            return true;
        } else {
            System.out.println("Contact already present");
            return false;
        }
    }

    public boolean remove(String contactID) {
        for (Contact c : contacts) {
            if (c.getContactID().equals(contactID)) {
                contacts.remove(c);
                System.out.println("Contact removed Successfully!");
                return true;
            }
        }
        System.out.println("Contact not present");
        return false;
    }

    public boolean update(String contactID, String firstName, String lastName, String phoneNumber, String numberAddress) {
        for (Contact c : contacts) {
            if (c.getContactID().equals(contactID)) {
                if (!firstName.equals(""))
                    c.setFirstName(firstName);
                if (!lastName.equals(""))
                    c.setLastName(lastName);
                if (!phoneNumber.equals("") && isValidPhoneNumber(phoneNumber))
                    c.setPhoneNumber(phoneNumber);
                if (!numberAddress.equals(""))
                    c.setNumberAddress(numberAddress);
                System.out.println("Contact updated Successfully!");
                return true;
            }
        }
        
       
        System.out.println("Contact not present");
        return false;
    }
    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.length() == 10;
    }
}
