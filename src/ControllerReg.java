
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import.javafx.scene.control.Label;
public class RegistrationController {


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
    public void initialize() {
        role.getItems().addAll("Customer", "Restaurant");
    }

    @FXML
    public void handleRegisterAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
        }
    } catch(UsernameAlreadyExistsException e)

    {
        registrationMessage.setText("Account not created");
    }
}

