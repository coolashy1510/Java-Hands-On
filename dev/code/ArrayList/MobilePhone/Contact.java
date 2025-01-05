package com.io.Java11.dev.code.ArrayList.MobilePhone;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * A factory method that creates a new Contact object.
     *
     * @param name     the name of the contact
     * @param phoneNumber the phone number of the contact
     * @return a new Contact object
     */
    public static Contact createContact(String name, String phoneNumber) {
        // returns an instance of Contact
        return new Contact(name, phoneNumber);
    }
}
