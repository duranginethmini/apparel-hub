package lk.ijse.apparelHub.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.apparelHub.dto.CustomerDto;
import lk.ijse.apparelHub.dto.MachineDto;
import lk.ijse.apparelHub.model.CustomerModel;
import lk.ijse.apparelHub.model.MachineModel;

import java.io.IOException;
import java.sql.SQLException;

public class MachineManageController {
    @FXML
    private AnchorPane root;

    @FXML
    private TableColumn<?, ?> colCost;

    @FXML
    private TableColumn<?, ?> colMachineId;

    @FXML
    private TableColumn<?, ?> colMachineType;

    @FXML
    private TableView<?> tblMachine;

    @FXML
    private TextField txtCost;

    @FXML
    private TextField txtMachineId;

    @FXML
    private TextField txtMachineType;

    @FXML
    void btnClearOnAction(ActionEvent event) {


    }

    @FXML
    void btnMachineDeleteOnAction(ActionEvent event) {
        String M_id = txtMachineId.getText();

        var MachineModel = new MachineModel();
        try {
            boolean isDeleted = MachineModel.deleteMachine(M_id);

            if(isDeleted) {
               // tblCustomer.refresh();
                new Alert(Alert.AlertType.CONFIRMATION, "Machine detail deleted!").show();
                //clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnMachineSaveOnAction(ActionEvent event) {
        String M_id = txtMachineId.getText();
        String type = txtMachineType.getText();
        double cost = Double.parseDouble(txtCost.getText());

        var dto = new MachineDto(M_id,type,cost);

        var model = new MachineModel();
        try {
            boolean isSaved = model.saveMachine(dto);
            System.out.println(isSaved);
            if(isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Info Saved!").show();
                //clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }


    }

    @FXML
    void btnMachineUpdateOnAction(ActionEvent event) {
        String M_id = txtMachineId.getText();
        String type= txtMachineType.getText();
        double cost  = Double.parseDouble(txtCost.getText());

        var dto = new MachineDto(M_id,type,cost);

        var model = new MachineModel();
        try {
            boolean isUpdated = model.updateMachineDetail(dto);
            System.out.println(isUpdated);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
                //clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }


    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Customer_form_Controller.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Customer Manage");
        stage.centerOnScreen();
    }

    @FXML
    void btnDashBoardOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/DashBoard_Form_Controller.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Dash Board");
        stage.centerOnScreen();
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Employee_Form_Controller.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Employee Manage");
        stage.centerOnScreen();
    }

    @FXML
    void btnOrderOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Order_Form_Controller.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Order Manage");
        stage.centerOnScreen();
    }

    @FXML
    void btnProductOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Product_Form_Controller.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Product Manage");
        stage.centerOnScreen();
    }

    @FXML
    void btnReportOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Report_Form_Controller.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Reports");
        stage.centerOnScreen();
    }

    @FXML
    void btnStockOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Stock_Manage_Controller.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Stock Manage");
        stage.centerOnScreen();
    }

}
