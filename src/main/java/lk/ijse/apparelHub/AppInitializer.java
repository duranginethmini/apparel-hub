package lk.ijse.apparelHub;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/View/Login_form_Controller.fxml"))));
        stage.setTitle("Login Form");
        stage.centerOnScreen();

        stage.show();
    }
}

