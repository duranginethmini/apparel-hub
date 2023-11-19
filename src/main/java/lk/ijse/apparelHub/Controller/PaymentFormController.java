package lk.ijse.apparelHub.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.apparelHub.db.DbConnection;
import lk.ijse.apparelHub.dto.CustomerDto;
import lk.ijse.apparelHub.dto.PaymentDto;
import lk.ijse.apparelHub.model.CustomerModel;
import lk.ijse.apparelHub.model.PaymentModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentFormController {
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtPaymentId;


    @FXML
    private TextField txtStatus;
    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Order_Form_Controller.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Order Manage");
        stage.centerOnScreen();
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtPaymentId.setText("");
        txtAmount.setText("");
        txtStatus.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtPaymentId.getText();

        var PaymentModel = new PaymentModel();
        try {
            boolean isDeleted = PaymentModel.deletePayment(id);

            if(isDeleted) {
                //tblCustomer.refresh();
                new Alert(Alert.AlertType.CONFIRMATION, "Payment deleted!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String OrderId = txtPaymentId.getText();
        double amount = Double.parseDouble(txtAmount.getText());
        String status = txtStatus.getText();


        var dto = new PaymentDto(OrderId,amount,status);

        var model = new PaymentModel();
        try {
            boolean isSaved = model.savePayment(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION,"Payment Saved").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String OrderId = txtPaymentId.getText();
        double amount = Double.parseDouble(txtAmount.getText());
        String status = txtStatus.getText();


        var dto = new PaymentDto(OrderId,amount,status);

        var model = new PaymentModel();
        try {
            boolean isUpdated = model.updatePayment(dto);
            System.out.println(isUpdated);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Payment updated!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


}
