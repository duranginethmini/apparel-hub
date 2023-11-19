package lk.ijse.apparelHub.Controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.apparelHub.dto.CustomerDto;
import lk.ijse.apparelHub.dto.OrderDto;
import lk.ijse.apparelHub.dto.PaymentDto;
import lk.ijse.apparelHub.dto.tm.OrderTm;
import lk.ijse.apparelHub.model.CustomerModel;
import lk.ijse.apparelHub.model.OrderModel;
import lk.ijse.apparelHub.model.PaymentModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OrderFormController {
    @FXML
    private AnchorPane root;
    @FXML
    private TableView<OrderTm> tblOrder;
    @FXML
    private JFXComboBox<String> cmbCustId;

    @FXML
    private JFXComboBox<String> cmbPayId;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtOrderDesc;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtOrderPrice;

    @FXML
    private TextField txtQty;

    public void initialize(){
        loadCustomerIds();
        loadPaymentIds();

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtOrderId.setText("");
        txtQty.setText("");
        txtDate.setText("");
        txtOrderDesc.setText("");
        txtOrderPrice.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String OrderId = txtOrderId.getText();

        var OrderModel = new OrderModel();
        try {
            boolean isDeleted = OrderModel.deleteOrder(OrderId);

            if(isDeleted) {
               // tblCustomer.refresh();
                new Alert(Alert.AlertType.CONFIRMATION, "Order deleted!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String OrderId = txtOrderId.getText();
        String B_id = String.valueOf(cmbCustId.getValue());
        String Pay_id = String.valueOf(cmbPayId.getValue());
        double price = Double.parseDouble(txtOrderPrice.getText());
        String description = txtOrderDesc.getText();
        int Qty = Integer.parseInt(txtQty.getText());
        String date = txtDate.getText();

        var dto = new OrderDto(OrderId,B_id,Pay_id,price,description,Qty,date);

        var model = new OrderModel();
        try {
            boolean isSaved = model.saveOrder(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION,"Order Saved").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String OrderId = txtOrderId.getText();
        String B_id = String.valueOf(cmbCustId.getValue());
        String Pay_id = String.valueOf(cmbPayId.getValue());
        double price = Double.parseDouble(txtOrderPrice.getText());
        String description = txtOrderDesc.getText();
        int Qty = Integer.parseInt(txtQty.getText());
        String date = txtDate.getText();

        var dto = new OrderDto(OrderId,B_id,Pay_id,price,description,Qty,date);

        var model = new OrderModel();
        try {
            boolean isUpdated = model.updateOrder(dto);
            System.out.println(isUpdated);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "Order updated!").show();
                clearFields();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }
    private void loadCustomerIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<CustomerDto> cusList = CustomerModel.loadAllCustomers();

            for (CustomerDto dto : cusList) {
                obList.add(dto.getId());
            }
            cmbCustId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void loadPaymentIds(){
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<PaymentDto> payList = PaymentModel.loadAllPayments();

            for (PaymentDto dto : payList) {
                obList.add(dto.getPay_id());
            }
            cmbPayId.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    void cmbCustomerOnAction(ActionEvent event) {
      //  String code = cmbCustId.getValue();



    }

    @FXML
    void cmbPaymentOnAction(ActionEvent event) {

    }


    @FXML
    void btnPaymentOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/Payment_Form_Controller.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Payment Manage");
        stage.centerOnScreen();
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
