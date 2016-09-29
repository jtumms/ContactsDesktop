package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by john.tumminelli on 9/28/16.
 */
public class ContactWrapper {
    ArrayList<Contact> contactsWrapped;

    public ContactWrapper(ArrayList<Contact> contactsWrapped) {
        this.contactsWrapped = contactsWrapped;
    }

    public ArrayList<Contact> getContactsWrapped() {
        return contactsWrapped;
    }
}
