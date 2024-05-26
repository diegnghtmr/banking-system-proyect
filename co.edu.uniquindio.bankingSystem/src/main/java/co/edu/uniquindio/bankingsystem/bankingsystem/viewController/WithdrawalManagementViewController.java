package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.Withdrawal;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class WithdrawalManagementViewController {
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
    private TableView<Withdrawal> tblData;

    @FXML
    private TableColumn<Withdrawal, String> tcAccount;

    @FXML
    private TableColumn<Withdrawal, String> tcAmount;

    @FXML
    private TableColumn<Withdrawal, String> tcReferenceNumber;

    @FXML
    private TableColumn<Withdrawal, String> tcWithdrawalDate;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtFilter;

    @FXML
    private TextField txtReferenceNumber;

    @FXML
    private DatePicker txtWithdrawalDate;

    @FXML
    void onAccount(ActionEvent event) {

    }

    @FXML
    void onAdd(ActionEvent event) {

    }

    @FXML
    void onNew(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}
