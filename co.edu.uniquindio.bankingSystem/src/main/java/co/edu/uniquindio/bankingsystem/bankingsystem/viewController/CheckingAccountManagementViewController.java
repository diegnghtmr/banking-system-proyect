package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import co.edu.uniquindio.bankingsystem.bankingsystem.controller.CheckingAccountManagementController;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.CheckingAccount;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CheckingAccountManagementViewController {

    CheckingAccountManagementController checkingAccountManagementController;

    ObservableList<CheckingAccount> checkingAccountList = FXCollections.observableArrayList();

    FilteredList<CheckingAccount> filteredCheckingAccountList;
    CheckingAccount selectedChekingAccount;

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
        addCheckingAccount();

    }


    @FXML
    void onNew(ActionEvent event) {
        clearData();
        deslectedCheckingAccount();

    }


    @FXML
    void onRemove(ActionEvent event) {
        removeCheckingAccount(selectedChekingAccount);

    }


    @FXML
    void onUpdate(ActionEvent event) {
        updateCheckingAccount();

    }

    @FXML
    void initialize() {
        checkingAccountManagementController = new CheckingAccountManagementController();
        initView();
        setupFilter();
    }


    private void initView() {
        initDataBinding();
        getCheckingAccountList();
        tableManagementAccounts.getItems().clear();
        tableManagementAccounts.setItems(filteredCheckingAccountList);
        listenerSelection();
    }


    private void initDataBinding() {
        tcAccountNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAccountNumber()));
        tcBalance.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getBalance())));
        tcSecurityNumber.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSecurityNumber())));
        tcOpeningDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOpeningDate().toString()));
        tcOverdraftLimit.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getOverdraftLimit())));
    }

    private void getCheckingAccountList() {
        checkingAccountList.addAll(checkingAccountManagementController.getCheckingAccountList());
        filteredCheckingAccountList = new FilteredList<>(checkingAccountList, p -> true);
    }

    private void listenerSelection() {
        tableManagementAccounts.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedChekingAccount = newSelection;
            showInformation(selectedChekingAccount);
        });
    }

    private void showInformation(CheckingAccount selectedChekingAccount) {
        if (selectedChekingAccount != null) {
            txtAccountNumber.setText(selectedChekingAccount.getAccountNumber());
            txtBalance.setText(String.valueOf(selectedChekingAccount.getBalance()));
            txtSecurityNumber.setText(String.valueOf(selectedChekingAccount.getSecurityNumber()));
            txtoverdraftLimit.setText(String.valueOf(selectedChekingAccount.getOverdraftLimit()));

        }
    }

    private void setupFilter() {
        txtFilter.textProperty().addListener((observable, oldValue, newvalue) -> {
            List<CheckingAccount> originalList = checkingAccountManagementController.getCheckingAccountList();
            ObservableList<CheckingAccount> filteredList = filterList(originalList, newvalue);
            tableManagementAccounts.setItems(filteredList);
        });
    }

    private boolean searchFindsCheckingAccount(CheckingAccount checkingAccount, String searchText) {
        return (checkingAccount.getAccountNumber().toLowerCase().contains(searchText.toLowerCase()));
    }


    private ObservableList<CheckingAccount> filterList(List<CheckingAccount> originalList, String searchText) {
        List<CheckingAccount> filteredList = new ArrayList<>();
        for (CheckingAccount checkingAccount : originalList) {
            if (searchFindsCheckingAccount(checkingAccount, searchText)) filteredList.add(checkingAccount);
        }
        return FXCollections.observableList(filteredList);
    }

    private void deslectedCheckingAccount() {
        tableManagementAccounts.getSelectionModel().clearSelection();
        selectedChekingAccount = null;

    }

    private void clearData() {
        txtAccountNumber.setText("");
        txtBalance.setText("");
        txtSecurityNumber.setText("");
        txtoverdraftLimit.setText("");

    }

    private void addCheckingAccount() {
        if (validateForm()) {
            CheckingAccount checkingAccount = buildDataCheckingAccount();
            if (checkingAccountManagementController.createCheckingAccount(checkingAccount)) {
                checkingAccountList.add(checkingAccount);
                tableManagementAccounts.refresh();
                showMessage("Notificación cuenta corriente", "Cuenta corriente creada", "La cuenta corriente ha sido creada con éxito", Alert.AlertType.INFORMATION);
                clearData();
                deslectedCheckingAccount();
            } else {
                showMessage("Error", "Creación fallida", "No se pudo crear la cuenta corriente.", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Error", "Datos inválidos", "Por favor, ingrese datos válidos", Alert.AlertType.ERROR);
        }
    }

    private void removeCheckingAccount(CheckingAccount selectedChekingAccount) {
        if (selectedChekingAccount != null) {
            if (showConfirmationMessage("¿Está seguro de eliminar esta cuenta corriente?")) {
                if (checkingAccountManagementController.removeCheckingAccount(selectedChekingAccount)) {
                    checkingAccountList.remove(selectedChekingAccount);
                    tableManagementAccounts.refresh();
                    showMessage("Notificación", "Cuenta corriente eliminada", "La cuenta corriente ha sido eliminada con éxito", Alert.AlertType.INFORMATION);
                    clearData();
                    deslectedCheckingAccount();
                } else {
                    showMessage("Error", "Eliminación fallida", "No se pudo eliminar la cuenta corriente.", Alert.AlertType.ERROR);
                }
            } else {
                showMessage("Advertencia", "Selección requerida", "Debe seleccionar una cuenta corriente para eliminar", Alert.AlertType.WARNING);
            }
        }

    }


    private void updateCheckingAccount() {
        if (selectedChekingAccount != null) {
            CheckingAccount checkingAccountUpdate = buildDataCheckingAccount();
            boolean result = checkingAccountManagementController.updateCheckingAccount(selectedChekingAccount, checkingAccountUpdate);
            if (result) {
                updateCheckingAccountList(selectedChekingAccount, checkingAccountUpdate);
                tableManagementAccounts.refresh();
                showMessage("Notificación cuenta corriente", "Cuenta corriente actualizada", "La cuenta corriente ha sido actualizada con éxito", Alert.AlertType.INFORMATION);
                clearData();
            } else {
                showMessage("Error", "Actualización fallida", "No se pudo actualizar la cuenta corriente.", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Error", "Selección requerida", "Debe seleccionar una cuenta corriente.", Alert.AlertType.WARNING);
        }
    }

    private void updateCheckingAccountList(CheckingAccount selectedChekingAccount, CheckingAccount checkingAccountUpdate) {
        int index = checkingAccountList.indexOf(selectedChekingAccount);
        if (index != -1) {
            checkingAccountList.set(index, checkingAccountUpdate);
        }
    }


    private boolean showConfirmationMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(message);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }


    private void showMessage(String title, String header, String content, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(title);
        aler.setHeaderText(header);
        aler.setContentText(content);
        aler.showAndWait();
    }

    private CheckingAccount buildDataCheckingAccount() {
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.setAccountNumber(txtAccountNumber.getText());
        checkingAccount.setBalance(Double.parseDouble(txtBalance.getText()));
        checkingAccount.setSecurityNumber(Integer.parseInt(txtSecurityNumber.getText()));
        checkingAccount.setOpeningDate(LocalDate.now());
        checkingAccount.setOverdraftLimit(Double.parseDouble(txtoverdraftLimit.getText()));
        return checkingAccount;
    }

    private boolean validateForm() {
        return !txtBalance.getText().isEmpty()
                && !txtSecurityNumber.getText().isEmpty()
                && !txtAccountNumber.getText().isEmpty()
                && !txtoverdraftLimit.getText().isEmpty();
    }


}
