
import.javafx.fxml.FXML;
import.javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
public class Controller extends Application {

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
    private Button signin;
    @FXML
    private Button register;

    @FXML
    public void initialize() {
        UserType.getItems().addAll("Customer", "Restaurant");
    }



    @FXML
    public void VerifyCustomer(ActionEvent event) {
        if (username.getText().equals("user") && password.getText().equals("password") && UserType.getItems().equals("Customer")) {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new scene(root, 503, 400);
            primaryStage.setScene(scene);
            primaryStage.show();


            status.setText("sign in succesfull");
        } else {
            status.setText("sign in unsuccesfull");
        }
    }



    @FXML
    public void VerifyRestaurant(ActionEvent event){
        if(username.getText().equals("user") && password.getText().equals("password") && UserType.getItems().equals("Restaurant")){
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new scene(root,503,400);
            primaryStage.setScene(scene);
            primaryStage.show();


            status.setText("sign in succesfull");
        }
        else{
            status.setText("sign in unsuccesfull");
        }

    }
}

