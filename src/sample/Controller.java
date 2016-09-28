package sample;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.awt.SystemColor.text;


public class Controller implements Initializable, ChangeListener{
    @FXML
    TextField name;

    @FXML
    TextField phone;

    @FXML
    TextField email;

    @FXML
    ListView list;

    @FXML
    Button buttonAdd;

    ObservableList<Contact> contacts = FXCollections.observableArrayList();


    public void addContact() throws IOException {
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
//        if (name.getText().isEmpty()){
//            buttonAdd.setDisable(true);
//        }

    }
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue){


    }







}
