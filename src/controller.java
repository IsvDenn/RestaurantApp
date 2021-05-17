
import.javafx.fxml.FXML;
import.javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
public class Controller extends Application {

    @FXML
    private Label login;

    @FXML
    private Label status;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;



    public void Verify(ActionEvent event){
        if(username.getText().equals("user") && password.getText().equals("password")){
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

