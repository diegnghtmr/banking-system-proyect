package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.controller.AccountAssociationManagementController;
import co.edu.uniquindio.bankingsystem.bankingsystem.dto.AccountAssociationDto;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class AccountAssociationManagementViewController {
    AccountAssociationManagementController accountAssociationManagementController;
    ObservableList<AccountAssociationDto> AccountAssociationList = FXCollections.observableArrayList();
    FilteredList<AccountAssociationDto> filteredAccountAssociationList;


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
    private TableView<AccountAssociationDto> tblData;

    @FXML
    private TableColumn<AccountAssociationDto, String> tcAccountNumber;

    @FXML
    private TableColumn<AccountAssociationDto, String> tcAccountType;

    @FXML
    private TableColumn<AccountAssociationDto, String> tcCustomerName;

    @FXML
    private TableColumn<AccountAssociationDto, String> tcCustomersID;

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
        accountAssociationManagementController = new AccountAssociationManagementController();
        initView();

    }

    private void initView() {
        initDataBinding();
        getAccountAssociationList();
        tblData.getItems().clear();
        tblData.setItems(AccountAssociationList);
      //  listenerSelection();
    }


    private void initDataBinding() {
        tcCustomerName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name()));
        tcCustomersID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().dni()));
        tcAccountNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().accountNumber()));
        tcAccountType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().accountType()));
    }

    private void getAccountAssociationList() {
        AccountAssociationList.addAll(accountAssociationManagementController.getAccountAssociationList());
    }

}

