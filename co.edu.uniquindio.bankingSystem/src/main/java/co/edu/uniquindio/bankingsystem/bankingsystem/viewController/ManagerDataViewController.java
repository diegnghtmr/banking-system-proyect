package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ManagerDataViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnSignOff;

    @FXML
    private TextField txtEmailManager;

    @FXML
    private TextField txtIdManager;

    @FXML
    private TextField txtManagerName;

    @FXML
    private TextField txtPasswordManager;

    @FXML
    private void initialize() {
        txtEmailManager.setEditable(false);
        txtIdManager.setEditable(false);
        txtManagerName.setEditable(false);
        txtPasswordManager.setEditable(false);
    }

    @FXML
    private void onSignOff() {
        browseWindow("/startup.fxml", "App Byte Bank");
    }

    @FXML
    void onDashboard(ActionEvent event) {
            browseWindow("/managerInterface.fxml", "Banco - Dashboard Gerente");
    }

    private void browseWindow(String nameFileFxml, String titleWindow) {
        try {
            Stage currentStage = (Stage) txtManagerName.getScene().getWindow();

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
        txtManagerName.setText(employee.getName());
        txtEmailManager.setText(employee.getEmail());
        txtIdManager.setText(employee.getDNI());
        txtPasswordManager.setText(employee.getPassword());
    }
}
