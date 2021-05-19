import.javafx.fxml.FXML;
import.javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
public class ControllerMain extends Application {

    @FXML
    private Label login;

    @FXML
    private Label status;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private ChoicBox UserType;

    @FXML
    private Button Button;
    public void Start() {
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene = new scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    }