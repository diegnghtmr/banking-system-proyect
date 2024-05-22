package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ManagerDataViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEmailManager;

    @FXML
    private TextField txtIdManager;

    @FXML
    private TextField txtManagerName;

    @FXML
    private TextField txtPasswordManager;

    @FXML
    private void onSignOff() {
        browseWindow("/startup.fxml", "Banco - Inicio");
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

}
