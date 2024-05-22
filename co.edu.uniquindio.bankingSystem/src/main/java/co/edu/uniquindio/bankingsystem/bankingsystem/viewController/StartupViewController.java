package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartupViewController {

    public void onLogin(ActionEvent actionEvent) {
        browseWindow("/login.fxml", "Banco - Iniciar Sesión", actionEvent);
    }

    public void onRegistration(ActionEvent actionEvent) {
        browseWindow("/register.fxml", "Banco - Registro", actionEvent);
    }

    public void browseWindow(String nameFileFxml, String titleWindow, ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(nameFileFxml));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle(titleWindow);
            stage.show();

            closeWindow(actionEvent);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
