package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import co.edu.uniquindio.bankingsystem.bankingsystem.controller.LoginController;
import co.edu.uniquindio.bankingsystem.bankingsystem.controller.RegisterController;
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

public class RegisterViewController {

    RegisterController registerController;

    @FXML
    private Button btnRegistration;

    @FXML
    private Button btnReturn;

    @FXML
    private TextField txtIdentification;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtAddress;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtPhone;

    @FXML
    private PasswordField txtAuthorizationCode;

    public void onRegistration(ActionEvent actionEvent) {
        register();
    }

    @FXML
    void onReturn(ActionEvent event) {
        returnToStartup();
    }

    @FXML
    void initialize() {
        registerController = new RegisterController();
    }

    public void register(){
        try {
            String identification = txtIdentification.getText();
            String name = txtName.getText();
            String email = txtEmail.getText();
            String address = txtAddress.getText();
            String password = txtPassword.getText();
            String phone = txtPhone.getText();
            String authorizationCode = txtAuthorizationCode.getText();

            if (!validateForm()) {
                showMessage("Por favor, rellene todos los campos", "Error", Alert.AlertType.ERROR);
                return;
            }

            String expectedAuthorizationCode = "77712345";

            if (!authorizationCode.equals(expectedAuthorizationCode)) {
                showMessage("Código de autorización incorrecto", "Error", Alert.AlertType.ERROR);
                return;
            }

            Employee newEmployee = registerController.addEmployee(identification, name, email, address, password, phone);

            if (newEmployee != null) {
                showMessage("Gerente registrado correctamente", "Información", Alert.AlertType.INFORMATION);
                closeWindow();
                goEmployeeDashboard(newEmployee);
            } else {
                showMessage("Error al registrar el gerente", "Error", Alert.AlertType.ERROR);
            }

        } catch (Exception e) {
            showMessage(e.getMessage(), "Error", Alert.AlertType.ERROR);
        }
    }

    private boolean validateForm() {
        return txtIdentification.getText() != null && !txtIdentification.getText().isEmpty()
                && txtName.getText() != null && !txtName.getText().isEmpty()
                && txtEmail.getText() != null && !txtEmail.getText().isEmpty()
                && txtAddress.getText() != null && !txtAddress.getText().isEmpty()
                && txtPassword.getText() != null && !txtPassword.getText().isEmpty()
                && txtPhone.getText() != null && !txtPhone.getText().isEmpty()
                && txtAuthorizationCode.getText() != null && !txtAuthorizationCode.getText().isEmpty();
    }

    private void closeWindow() {
        Stage stage = (Stage) txtIdentification.getScene().getWindow();
        stage.close();
    }

    private void goEmployeeDashboard(Employee employeeValidated) {
        if (employeeValidated.getTypeEmployee() == TypeEmployee.MANAGER) {
            browseWindow("/managerInterface.fxml", "Banco - Panel de Gerente");
        } else {
            showMessage("Solo los gerentes pueden acceder a este panel", "Error", Alert.AlertType.ERROR);
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