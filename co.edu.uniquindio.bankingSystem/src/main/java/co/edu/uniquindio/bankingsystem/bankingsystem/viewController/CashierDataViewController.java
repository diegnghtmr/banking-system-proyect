package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import co.edu.uniquindio.bankingsystem.bankingsystem.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CashierDataViewController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnSignOff;

    @FXML
    private TextField txtCashierName;

    @FXML
    private TextField txtEmaiCashier;

    @FXML
    private TextField txtIdCashier;

    @FXML
    private TextField txtPasswordCashier;

    @FXML
    private void initialize() {
        txtCashierName.setEditable(false);
        txtEmaiCashier.setEditable(false);
        txtIdCashier.setEditable(false);
        txtPasswordCashier.setEditable(false);
    }

    @FXML
    private void onSignOff() {
        browseWindow("/startup.fxml", "App Byte Bank");
    }

    @FXML
    void onDashboard(ActionEvent event) {
        browseWindow("/cashierInterface.fxml", "Banco - Dashboard Cajero");
    }

    private void browseWindow(String nameFileFxml, String titleWindow) {
        try {
            Stage currentStage = (Stage) txtCashierName.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource(nameFileFxml));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(titleWindow);
            stage.show();

            currentStage.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setEmployee(Employee employee) {
        txtCashierName.setText(employee.getName());
        txtEmaiCashier.setText(employee.getEmail());
        txtIdCashier.setText(employee.getDNI());
        txtPasswordCashier.setText(employee.getPassword());
    }

}

