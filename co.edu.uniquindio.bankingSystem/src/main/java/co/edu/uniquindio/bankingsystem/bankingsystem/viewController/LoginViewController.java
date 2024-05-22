package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import co.edu.uniquindio.bankingsystem.bankingsystem.controller.CashierManagementController;
import co.edu.uniquindio.bankingsystem.bankingsystem.controller.LoginController;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Employee;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.enums.TypeEmployee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController {

    LoginController loginController;

    @FXML
    private Button btnReturn;

    @FXML
    private Button btnStart;

    @FXML
    private TextField txtIdentification;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private void onStart(ActionEvent actionEvent) {
        start();
    }

    @FXML
    void onReturn(ActionEvent event) {
        returnToStartup();
    }

    @FXML
    void initialize() {
        loginController = new LoginController();
    }

    private void start() {
        try {
            if (!validateForm()) {
                showMessage("Por favor, rellene todos los campos", "Error", Alert.AlertType.ERROR);
                return;
            }

            String employee = txtIdentification.getText();
            String password = txtPassword.getText();

            Employee employeeValidated = loginController.validateEmployee(employee, password);

            if (employeeValidated != null) {
                closeWindow();
                goEmployeeDashboard(employeeValidated);
            } else {
                showMessage("Empleado o contraseña incorrectos", "Error", Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            showMessage("Error al iniciar sesión: " + e.getMessage(), "Error", Alert.AlertType.ERROR);
        }
    }

    private boolean validateForm() {
        return txtIdentification.getText() != null && !txtIdentification.getText().isEmpty()
                && txtPassword.getText() != null && !txtPassword.getText().isEmpty();
    }

    private void closeWindow() {
        Stage stage = (Stage) txtIdentification.getScene().getWindow();
        stage.close();
    }

    private void goEmployeeDashboard(Employee employeeValidated) {
        if (employeeValidated.getTypeEmployee() == TypeEmployee.MANAGER) {
            browseWindow("/managerInterface.fxml", "Banco - Panel de Gerente");
        } else if (employeeValidated.getTypeEmployee() == TypeEmployee.CASHIER) {
            browseWindow("/cashierInterface.fxml", "Banco - Panel de Cajero");
        } else {
            showMessage("Tipo de empleado no reconocido", "Error", Alert.AlertType.ERROR);
        }
    }

    private void browseWindow(String fileNameFxml, String windowTitle) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fileNameFxml));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(windowTitle);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showMessage(String content, String title, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void returnToStartup() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/startup.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Banco - Inicio");
            stage.show();

            closeWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}