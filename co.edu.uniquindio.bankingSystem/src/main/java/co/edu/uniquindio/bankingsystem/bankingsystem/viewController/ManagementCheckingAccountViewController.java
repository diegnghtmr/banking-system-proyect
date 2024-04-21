package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.controller.ManagementCheckingAccountController;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.CheckingAccount;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ManagementCheckingAccountViewController {

    ObservableList<CheckingAccount>accountList = FXCollections.observableArrayList();
    FilteredList<CheckingAccount>filteredAccountList;
    CheckingAccount selectedCheckingAccount;

    ManagementCheckingAccountController managementCheckingAccountController;

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
    private DatePicker dtOpeningDate;

    @FXML
    private TableView<CheckingAccount> tableManagementAccounts;

    @FXML
    private TableColumn<CheckingAccount, String> tcAccountNumber;

    @FXML
    private TableColumn<CheckingAccount, String> tcBalance;

    @FXML
    private TableColumn<CheckingAccount, String> tcOpeningDate;

    @FXML
    private TableColumn<CheckingAccount, String> tcSecurityNumber;

    @FXML
    private TextField txtAccountNumber;

    @FXML
    private TextField txtBalance;
    @FXML
    private TextField txtSecurityNumber;

    @FXML
    private TextField txtFilter;

    @FXML
    void onAdd(ActionEvent event) {
        addAccount();

    }



    @FXML
    void onNew(ActionEvent event) {
       clearData();
        deselectedAccount();

    }



    @FXML
    void onRemove(ActionEvent event) {
        //removeAccount(selectedAccount);

    }

    @FXML
    void onUpdate(ActionEvent event) {

    }

    @FXML
    void initialize() {
        managementCheckingAccountController =  new ManagementCheckingAccountController();
        initView();
        setupFilter();


    }


    private void initView() {
        initDataBinding();
        getAccountList();
        tableManagementAccounts.getItems().clear();
        tableManagementAccounts.setItems(filteredAccountList);
        listenerSelecction();
    }




    private void initDataBinding() {
        tcAccountNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAccountNumber()));
        tcBalance.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getBalance())));
        tcSecurityNumber.setCellValueFactory(cellData-> new SimpleStringProperty(String.valueOf(cellData.getValue().getSecurityNumber())));
        tcOpeningDate.setCellValueFactory(cellData-> new SimpleStringProperty(cellData.getValue().getOpeningDate().toString()));
    }

    private void getAccountList() {
        accountList.addAll(managementCheckingAccountController.getCheckingAccountList());
        filteredAccountList = new FilteredList<>(accountList, p -> true);
    }

    private void setupFilter() {
        txtFilter.textProperty().addListener((observable, oldValue, newValue)->{
            List<CheckingAccount> originalList = managementCheckingAccountController.getCheckingAccountList();
           ObservableList<CheckingAccount> filteredList = filterList(originalList, newValue);
            tableManagementAccounts.setItems(filteredList);
        });
    }

    private ObservableList<CheckingAccount> filterList(List<CheckingAccount> originalList, String searchText) {
        List<CheckingAccount> filteredList = new ArrayList<>();
        for (CheckingAccount account : originalList){
            if(searchFindsAccount(account, searchText)) filteredList.add(account);
        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchFindsAccount(Account account, String searchText) {
        return (account.getAccountNumber().toLowerCase().contains(searchText.toLowerCase())) ||
                (account.getOpeningDate().toString().toLowerCase().contains(searchText.toLowerCase()));
    }

    private void listenerSelecction() {
        tableManagementAccounts.getSelectionModel().selectedItemProperty().addListener((obs, oldSelecction, newSelecction)->{
            selectedCheckingAccount = newSelecction;
            showInformationAccount(selectedCheckingAccount);
        });
    }

    private void showInformationAccount(Account selectedAccount) {
        if(selectedAccount!=null){
            txtAccountNumber.setText(selectedAccount.getAccountNumber());
            txtBalance.setText(String.valueOf(selectedAccount.getBalance()));

            txtSecurityNumber.setText(String.valueOf(selectedAccount.getSecurityNumber()));
            dtOpeningDate.setValue(selectedAccount.getOpeningDate());
        }
    }

    private void deselectedAccount() {
        tableManagementAccounts.getSelectionModel().clearSelection();
        selectedCheckingAccount = null;
    }


    private void addAccount(){
        if(validateForm()){
            CheckingAccount checkingAccount = buildDataAccount();
            if(managementCheckingAccountController.createCheckingAccount(checkingAccount)){
                accountList.add(checkingAccount);
                showMessage("Notificación Cuenta Corriente", "Cuenta corriente creadoa", "La cuenta corriente ha sido creada con éxito", Alert.AlertType.INFORMATION);
                clearData();
            }else {
                showMessage("Error", "Creación fallida", "No se pudo crear el cliente.", Alert.AlertType.ERROR);
            }
        }else {
            showMessage("Error", "Datos invalidos", "Por favor, ingrese datos validos", Alert.AlertType.ERROR);
        }
    }

    private void clearData() {
        txtAccountNumber.setText("");
        txtBalance.setText("");
        txtSecurityNumber.setText("");
        dtOpeningDate.setValue(null);
    }

    private void showMessage(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    private CheckingAccount buildDataAccount() {
       CheckingAccount account = new CheckingAccount();
       account.setAccountNumber(txtAccountNumber.getText());
       account.setOpeningDate(dtOpeningDate.getValue());
       account.setSecurityNumber(Integer.parseInt(String.valueOf(txtSecurityNumber.getText())));
       account.setBalance(Double.parseDouble(String.valueOf(txtBalance.getText())));
       return account;
    }

    private boolean validateForm() {
        return !txtAccountNumber.getText().isEmpty()
                && !txtSecurityNumber.getText().isEmpty()
                && !txtBalance.getText().isEmpty()
                && dtOpeningDate.getValue()!=null;
    }




}


