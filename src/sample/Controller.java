package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static java.awt.SystemColor.text;


public class Controller implements Initializable {
    @FXML
    TextField name;

    @FXML
    TextField phone;

    @FXML
    TextField email;

    @FXML
    ListView list;

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    public void addContact(){
        String inputName = name.getText();
        String inputPhone = phone.getText();
        String inputEmail = email.getText();
        Contact contact = new Contact(inputName, inputPhone, inputEmail);
        contacts.add(contact);
        name.clear();
        phone.clear();
        email.clear();

    }

    public void removeItem(){
        Contact contact = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);

    }
}
