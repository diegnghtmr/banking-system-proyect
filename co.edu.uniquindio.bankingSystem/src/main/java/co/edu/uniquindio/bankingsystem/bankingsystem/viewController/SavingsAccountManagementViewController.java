package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.SavingsAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SavingsAccountManagementViewController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnUpdate;

    @FXML
    private DatePicker dpOpeningDate;

    @FXML
    private TableView<SavingsAccount> tableManagementAccounts;

    @FXML
    private TableColumn<SavingsAccount, String> tcAccountNumber;

    @FXML
    private TableColumn<SavingsAccount, String> tcBalance;

    @FXML
    private TableColumn<SavingsAccount, String> tcOpeningDate;

    @FXML
    private TableColumn<SavingsAccount, String> tcOverdraftLimit;

    @FXML
    private TableColumn<SavingsAccount, String> tcSecurityNumber;

    @FXML
    private TextField txtAccountNumber;

    @FXML
    private TextField txtBalance;

    @FXML
    private TextField txtFilter;

    @FXML
    private TextField txtInterestRate;

    @FXML
    private TextField txtSecurityNumber;

    @FXML
    void onAdd(ActionEvent event) {

    }

    @FXML
    void onNew(ActionEvent event) {

    }

    @FXML
    void onRemove(ActionEvent event) {

    }

    @FXML
    void onUpdate(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}