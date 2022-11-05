package com.example.loginform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {
    @FXML
    private Button cancleButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordFiled;

    public void loginButtonOnAction(ActionEvent e) {
        if(usernameTextField.getText().isBlank() == false && passwordPasswordFiled.getText().isBlank() == false) {
//
            validdataLogin();
        } else {
            loginMessageLabel.setText("error");
        }

    }

    public void cancleButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancleButton.getScene().getWindow();
        stage.close();
    }

    public void validdataLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getDatabase();


//      SELECT count(1) FROM useraccounts WHERE username = 'JunBumHan' AND password = '1234';
        String verifyLogin = "SELECT count(1) FROM useraccounts WHERE username = '"+ usernameTextField.getText() + "' AND password = '" + passwordPasswordFiled.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()) {
                if(queryResult.getInt(1) == 1) {
                    loginMessageLabel.setText("Welcome!");
                } else {
                    loginMessageLabel.setText("Invalid Login.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}