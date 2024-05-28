package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AccountAssociationManagementViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAssociate;

    @FXML
    private Button btnDelete;

    @FXML
    private ComboBox<Account> cbAccounts;

    @FXML
    private ComboBox<Customer> cbCustomers;

    @FXML
    private TableView<?> tblData;

    @FXML
    private TableColumn<?, String> tcAccountNumber;

    @FXML
    private TableColumn<?, String> tcAccountType;

    @FXML
    private TableColumn<?, String> tcCustomerName;

    @FXML
    private TableColumn<?, String> tcCustomersID;

    @FXML
    private TextField txtFilter;

    @FXML
    void onAccounts(ActionEvent event) {

    }

    @FXML
    void onAssociate(ActionEvent event) {

    }

    @FXML
    void onCustomers(ActionEvent event) {

    }

    @FXML
    void onDelete(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}

