package com.io.Java11.dev.code.ArrayList.MobilePhone;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    /**
     * Adds a new contact to the contact list.
     *
     * @param contact the contact to be added
     * @return true if the contact was added successfully, false if it already exists
     */
    public boolean addNewContact(Contact contact) {
        // Check if the contact already exists using the contact's name
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file");
            return false;
        }
        // Add the contact to the list if it doesn't exist
        myContacts.add(contact);
        return true;
    }

    /**
     * Updates an existing contact in the contact list.
     *
     * @param oldContact the contact to be updated
     * @param newContact the new contact to replace the old contact
     * @return true if the contact was updated successfully, false if the old contact was not found or if the new contact already exists
     */
    public boolean updateContact(Contact oldContact, Contact newContact) {

        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + ", was not found.");
            return false;
        } else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() +
                    " already exists.  Update was not successful.");
            return false;
        }

        // Replace the old contact with the new contact
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }

    /**
     * Removes an existing contact from the contact list.
     *
     * @param contact the contact to be removed
     * @return true if the contact was removed successfully, false if the contact was not found
     */
    public boolean removeContact(Contact contact) {
        // Find the position of the contact in the list using the contact's name
        int foundPosition = findContact(contact.getName());

        // Check if the contact was found
        if (foundPosition < 0) {
            System.out.println(contact.getName() + ", was not found.");
            return false;
        }

        // Remove the contact from the list
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + ", was deleted.");
        return true;
    }

    /**
     * Find the position of the contact in the contact list.
     *
     * @param contact the contact to search for
     * @return the position of the contact in the list, or -1 if the contact was not found
     */
    private int findContact(Contact contact) {
        // Use the indexOf() method to find the position of the contact in the list
        return myContacts.indexOf(contact);
    }

    /**
     * Find the position of the contact in the contact list using the contact's name.
     *
     * @param contactName the name of the contact to search for
     * @return the position of the contact in the list, or -1 if the contact was not found
     */
    private int findContact(String contactName) {

        // Iterate over the elements in the list
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            // Check if the contact's name matches the contactName
            if (contact.getName().equals(contactName)) {
                // Return the position of the contact
                return i;
            }
        }
        // Return -1 if the contact was not found
        return -1;
    }

    /**
     * Search for a contact by name.
     *
     * @param name the name of the contact to search for
     * @return the contact if found, or null if not found
     */
    public Contact queryContact(String name) {
        // Find the position of the contact in the list
        int position = findContact(name);

        // Check if the contact was found
        if (position >= 0) {
            // Return the contact
            return this.myContacts.get(position);
        }
        // Return null if the contact was not found
        return null;
    }

    /**
     * Prints all contacts in the contact list.
     * The format for each contact is:
     * [Index]. [Contact Name] -> [Phone Number]
     */
    public void printContacts() {
        System.out.println("Contact List:");
        // Loop through each contact in the list
        for (int i = 0; i < this.myContacts.size(); i++) {
            // Print the contact's index (1-based), name, and phone number
            System.out.println((i + 1) + ". " +
                    this.myContacts.get(i).getName() + " -> " +
                    this.myContacts.get(i).getPhoneNumber());
        }
    }
}
