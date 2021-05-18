package org.fis.project.HomePage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;

public class driver extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        try {

        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene = new scene(root,503,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        catch(Exception e) {
            e.printstacktrace();
        }
        public static void driver(String [] args){
            Launch(args)
        }
}