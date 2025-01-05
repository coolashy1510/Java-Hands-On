package com.io.Java11.dev.code.ArrayList.MobilePhone;

public class Main {
    /**
     * Main method to demonstrate the functionality of the MobilePhone class.
     * It adds, removes, and prints contacts from the mobile phone's contact list.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Create a new MobilePhone instance with a specific phone number
        MobilePhone mobilePhone = new MobilePhone("1234567890");

        // Add new contacts to the mobile phone
        mobilePhone.addNewContact(new Contact("John Doe", "123-456-7890"));
        mobilePhone.addNewContact(new Contact("Jack Doe", "123-456-7890"));

        // Remove a contact from the mobile phone
        mobilePhone.removeContact(new Contact("John Doe", "123-456-7890"));

        // Print all contacts currently stored in the mobile phone
        mobilePhone.printContacts();
    }
}
