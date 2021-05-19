package org.fis.project.register;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
public class ControllerReg {


    @FXML
    private Label status;
    @FXML
    private PasswordField passreg;
    @FXML
    private TextField userreg;
    @FXML
    private TextField displayname;
    @FXML
    private ChoiceBox role;
    @FXML
    private Button Button;
    @FXML
    private Label stsmsg;

    @FXML
    public void initialize() {
        role.getItems().addAll("Customer", "Restaurant");
    }

    @FXML
    public void ControllerReg() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            status.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            sts.msg.setText("Account not created");
        }
    }
}

