package com.example.projects;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Name_field;

    @FXML
    private Button authButten;

    @FXML
    private TextField login_field;

    @FXML
    private CheckBox manCheckBox;

    @FXML
    private TextField password_field;

    @FXML
    private TextField surName_field;

    @FXML
    private CheckBox womanCheckBox;

    @FXML
    void initialize() {
        authButten.setOnAction(actionEvent ->{
            SignUpNewUser();
        });

    }


    private void SignUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler(); // Новый обьект на основе базы
        String firstName = Name_field.getText();
        String surName = surName_field.getText();
        String login = login_field.getText();
        String password = password_field.getText();
        String gender ="";
        if (!womanCheckBox.isSelected()) { //если выбран
            gender = "Мужской";
        }else{
            gender = "Женский";
        }

        User user = new User(firstName,surName,login,password,gender);

        dbHandler.signUpUser(user);
    }

}
