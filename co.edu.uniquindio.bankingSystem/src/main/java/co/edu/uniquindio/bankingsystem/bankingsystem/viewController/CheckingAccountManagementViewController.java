package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.CheckingAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class CheckingAccountManagementViewController {
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
    private TableView<CheckingAccount> tableManagementAccounts;

    @FXML
    private TableColumn<CheckingAccount, String> tcAccountNumber;

    @FXML
    private TableColumn<CheckingAccount, String> tcBalance;

    @FXML
    private TableColumn<CheckingAccount, String> tcOpeningDate;

    @FXML
    private TableColumn<CheckingAccount, String> tcOverdraftLimit;

    @FXML
    private TableColumn<CheckingAccount, String> tcSecurityNumber;

    @FXML
    private TextField txtAccountNumber;

    @FXML
    private TextField txtBalance;

    @FXML
    private TextField txtFilter;

    @FXML
    private TextField txtSecurityNumber;

    @FXML
    private TextField txtoverdraftLimit;

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

}
