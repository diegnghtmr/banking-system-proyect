package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MovementManagementViewController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGetPreviousRecords;

    @FXML
    private Button btnLook;

    @FXML
    private ComboBox<Account> cbAccount;

    @FXML
    private DatePicker dpMovementDate;

    @FXML
    private TableView<?> tblData;

    @FXML
    private TableColumn<?, String> tcAccount;

    @FXML
    private TableColumn<?, String> tcAmount;

    @FXML
    private TableColumn<?, String> tcMovementDate;

    @FXML
    private TableColumn<?, String> tcReferenceNumber;

    @FXML
    private TableColumn<?, String> tcStatus;

    @FXML
    private TableColumn<?, String> tcTransactionType;

    @FXML
    private TextField txtFilter;

    @FXML
    void onAccount(ActionEvent event) {

    }

    @FXML
    void onGetPreviousRecords(ActionEvent event) {

    }

    @FXML
    void onLook(ActionEvent event) {

    }

    @FXML
    void onMovementDate(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}
