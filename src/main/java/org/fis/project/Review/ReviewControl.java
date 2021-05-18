        import javafx.scene.control.Button;
        import javafx.scene.control.ChoiceBox;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.image.ImageView;
        import javafx.scene.layout.AnchorPane;

        @FXML
        private Label name;
        @FXML
        private ImageView img;
        @FXML
        private TextField revbox;
        @FXML
        private ChoiceBox rating;
        @FXML
        private Button rev;
        @FXML
        private Button ret;

        @FXML
        public void initialize() {
                role.getItems().addAll("1 star", "2 star" "3 star" "4 star" , "5 star");
                }