package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.Deposit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DepositManagementViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnNew;

    @FXML
    private ComboBox<Account> cbAccount;

    @FXML
    private DatePicker dpDepositDate;

    @FXML
    private TableView<Deposit> tblData;

    @FXML
    private TableColumn<Deposit, String> tcAccount;

    @FXML
    private TableColumn<Deposit, String> tcAmount;

    @FXML
    private TableColumn<Deposit, String> tcDepositDate;

    @FXML
    private TableColumn<Deposit, String> tcReferenceNumber;

    @FXML
    private TableColumn<Deposit, String> tcState;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtFilter;

    @FXML
    private TextField txtReferenceNumber;

    @FXML
    void onAccount(ActionEvent event) {

    }

    @FXML
    void onAdd(ActionEvent event) {

    }

    @FXML
    void onDepositDate(ActionEvent event) {

    }

    @FXML
    void onNew(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}
