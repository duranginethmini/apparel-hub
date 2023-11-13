package lk.ijse.apparelHub.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class LoginFormController {
    @FXML
    private Button btnLogin;

    @FXML
    private Label lblUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtusername;

    @FXML
    private AnchorPane loginPane;
    private String username="1234";
    private String password="1234";

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        if (username.equals(txtusername.getText()) && password.equals(txtPassword.getText())){
            Parent root = FXMLLoader.load(this.getClass().getResource("/View/DashBoard_Form_Controller.fxml"));
            Scene scene=new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

            Stage stage1 = (Stage) loginPane.getScene().getWindow();
            stage1.close();

        } else {
           new Alert(Alert.AlertType.ERROR,"Incorrect password or Username").show();


        }
    }
}
