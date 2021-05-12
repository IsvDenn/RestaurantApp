
import.javafx.fxml.FXML;
import.javafx.scene.control.Label;
public class Controller {

    @FXML
    private label login;

    @FXML
    private label status;

    @FXML
    private label username;

    @FXML
    private label password;

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

