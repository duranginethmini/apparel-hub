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
import lk.ijse.apparelHub.dto.StockDto;
import lk.ijse.apparelHub.model.CustomerModel;
import lk.ijse.apparelHub.model.StockModel;

import java.io.IOException;
import java.sql.SQLException;

public class StockManageController {
    @FXML
    private AnchorPane root;
    @FXML
    private TableColumn<?, ?> cioStockId;

    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableView<?> tblStockManage;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtDesc;

    @FXML
    private TextField txtStockId;

    @FXML
    private TextField txtType;


    @FXML
    void btnStockClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtStockId.setText("");
        txtType.setText("");
        txtType.setText("");
        txtDesc.setText("");
    }

    @FXML
    void btnStockDeleteOnAction(ActionEvent event) {
        String stockId = txtStockId.getText();

        var StockModel = new StockModel();
        try {
            boolean isDeleted = StockModel.deleteCustomer(stockId);

            if(isDeleted) {

                new Alert(Alert.AlertType.CONFIRMATION, "Stock item  deleted!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnStockSaveOnAction(ActionEvent event) {
        String stockId = txtStockId.getText();
        String type = txtType.getText();
        int amount  = Integer.parseInt(txtAmount.getText());
        String desc = txtDesc.getText();

        var dto = new StockDto(stockId,type,amount,desc);

        var model = new StockModel();
        try {
            boolean isSaved = model.saveStock(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION,"Stock Saved").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnStockUpdateOnAction(ActionEvent event) {
        String stockId = txtStockId.getText();
        String type = txtType.getText();
        int amount = Integer.parseInt(txtAmount.getText());
        String desc = txtDesc.getText();

        var dto = new StockDto(stockId,type,amount,desc);

        var model = new StockModel();
        try {
            boolean isUpdated = model.updateStock(dto);
            System.out.println(isUpdated);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Stock updated!").show();
                clearFields();
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
    void btnMachineOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Machine_Manage_Controller.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Machine Manage");
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
    void btnSuplierOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Supplier_Manage_Controller.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Supplier Manage");
        stage.centerOnScreen();
    }
}
