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

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
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
        if (!inputName.isEmpty() && !inputPhone.isEmpty() && !inputEmail.isEmpty()){
            contacts.add(contact);
        }
        name.clear();
        phone.clear();
        email.clear();
        write(contacts);


    }
    public void write(ObservableList<Contact> contacts) {
        try {
            // write object to file
            FileOutputStream fos = new FileOutputStream("Objectsavefile.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new ArrayList<Contact>(contacts));
            oos.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static ObservableList<Contact> read() {
        try {
            File f = new File("Objectsavefile.ser");
            ObjectInputStream ois = new ObjectInputStream(in);
            List<EmployeeEntity> list = (List<EmployeeEntity>) ois.readObject() ;

            return FXCollections.observableList(list);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FXCollections.emptyObservableList();
    }

    public void removeItem(){
        Contact contact = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File f = new File("Objectsavefile.ser");

        list.setItems(contacts);


    }
    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue){


    }

}
