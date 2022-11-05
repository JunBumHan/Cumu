package com.example.loginform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
            loginMessageLabel.setText(usernameTextField.getText() + "님 안녕하세요!");
        } else {
            loginMessageLabel.setText("error");
        }

    }

    public void cancleButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancleButton.getScene().getWindow();
        stage.close();
    }


}