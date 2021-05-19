import javafx.fxml.FXMLLoader;
//import org.fis.project.HomePage.HomePage.fxml;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
public class controllerMain extends Application {

    @FXML
    private Label score;

    @FXML
    private Label reviews;

    @FXML
    private Button myrev;

    @FXML
    private Button myrest;

    @FXML
    private Button recrev;
    @FXML
    private Button editpage;

    @FXML
    private Button Button;
    public void Start() {
        Parent root = FXMLLoader.load(getClass().getResource("HomePagerRestaurant.fxml"));
        Scene scene = new scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    }