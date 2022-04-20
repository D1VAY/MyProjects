package com.example.projects;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Animals.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authButten;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private Button registerButton;

    @FXML
    void initialize() {
        authButten.setOnAction(actionEvent -> {
                loginUser();
        });
        registerButton.setOnAction(actionEvent -> {
            registerButton.getScene().getWindow().hide(); //Закрыть первоначальное окно
            //Отображение Окна
            FXMLLoader loader = new FXMLLoader(); //Отображение файла
            loader.setLocation(getClass().getResource("signUp.fxml"));

            //Загрузка файла
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();//Показать и подождать
        });

    }

    private void loginUser() {
        String loginText = login_field.getText(); // trim() - удаляет лишние пробелы
        String passText = password_field.getText();
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setLogin(loginText);
        user.setPassword(passText);
        ResultSet resultSet = dbHandler.getUser(user);

        int counter = 0;
        try {
            while (resultSet.next()) {
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (counter>=1)
            System.out.println("Success!");
        else {
            Shake loginAnim = new Shake(login_field);
            Shake passAnim = new Shake(password_field);
            loginAnim.playAnim();
            passAnim.playAnim();
        }
    }
}
