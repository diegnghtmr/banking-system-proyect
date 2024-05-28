package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import co.edu.uniquindio.bankingsystem.bankingsystem.controller.SavingsAccountManagementController;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.SavingsAccount;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SavingsAccountManagementViewController {

    SavingsAccountManagementController savingsAccountManagementController;

    ObservableList<SavingsAccount> savingsAccountsList = FXCollections.observableArrayList();
    FilteredList<SavingsAccount> filteredSavingsAccountList;
    SavingsAccount selectedSavingsAccount;

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
    private TableColumn<SavingsAccount, String> tcSecurityNumber;

    @FXML
    private TextField txtAccountNumber;

    @FXML
    private TextField txtBalance;

    @FXML
    private TextField txtFilter;

    @FXML
    private TextField txtSecurityNumber;

    @FXML
    void onAdd(ActionEvent event) {
        addSavingsAccount();
    }

    @FXML
    void onNew(ActionEvent event) {
        clearData();
        deselectSavingAccount();
    }


    @FXML
    void onRemove(ActionEvent event) {
        removeSavingsAccount(selectedSavingsAccount);
    }

    @FXML
    void onUpdate(ActionEvent event) {
        updateSavingAccount();
    }


    @FXML
    void initialize() {
        savingsAccountManagementController = new SavingsAccountManagementController();
        initView();
        setupFilter();
    }

    private void initView() {
        initDataBinding();
        getSevingsAccountList();
        tableManagementAccounts.getItems().clear();
        tableManagementAccounts.setItems(filteredSavingsAccountList);
        listenerSelection();
    }


    private void initDataBinding() {
        tcAccountNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAccountNumber()));
        tcBalance.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getBalance())));
        tcSecurityNumber.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getSecurityNumber())));
        tcOpeningDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOpeningDate().toString()));
    }

    private void getSevingsAccountList() {
        savingsAccountsList.addAll(savingsAccountManagementController.getSavingAccountList());
        filteredSavingsAccountList = new FilteredList<>(savingsAccountsList, p -> true);
    }

    private void listenerSelection() {
        tableManagementAccounts.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedSavingsAccount = newSelection;
            showInformation(selectedSavingsAccount);

        });
    }

    private void showInformation(SavingsAccount selectedSavingsAccount) {
        if (selectedSavingsAccount != null) {
            txtAccountNumber.setText(selectedSavingsAccount.getAccountNumber());
            txtBalance.setText(String.valueOf(selectedSavingsAccount.getBalance()));
            txtSecurityNumber.setText(String.valueOf(selectedSavingsAccount.getSecurityNumber()));
        }
    }

    private void setupFilter() {
        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            List<SavingsAccount> originalList = savingsAccountManagementController.getSavingAccountList();
            ObservableList<SavingsAccount> filteredList = filterList(originalList, newValue);
            tableManagementAccounts.setItems(filteredList);
        });
    }

    private ObservableList<SavingsAccount> filterList(List<SavingsAccount> originalList, String searchText) {
        List<SavingsAccount> filteredList = new ArrayList<>();
        for (SavingsAccount savingsAccount : originalList) {
            if (searchFindsSavingsAccount(savingsAccount, searchText)) filteredList.add(savingsAccount);

        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchFindsSavingsAccount(SavingsAccount savingsAccount, String searchText) {
        return (savingsAccount.getAccountNumber().toLowerCase().contains(searchText.toLowerCase()));
    }

    private void deselectSavingAccount() {
        tableManagementAccounts.getSelectionModel().clearSelection();
        selectedSavingsAccount = null;
    }

    private void clearData() {
        txtAccountNumber.setText("");
        txtBalance.setText("");
        txtSecurityNumber.setText("");
    }

    private void addSavingsAccount() {
        if (validateForm()) {
            SavingsAccount savingsAccount = buildDataSavingsAccount();
            if (savingsAccountManagementController.createSavingsAccount(savingsAccount)) {
                savingsAccountsList.add(savingsAccount);
                tableManagementAccounts.refresh(); // Refrescar la tabla
                showMessage("Notificación cuenta de ahorro", "Cuenta de ahorro creada", "La cuenta de ahorro ha sido creada con éxito", Alert.AlertType.INFORMATION);
                clearData();
                deselectSavingAccount();
            } else {
                showMessage("Error", "Creación fallida", "No se pudo crear la cuenta de ahorro.", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Error", "Datos inválidos", "Por favor, ingrese datos válidos", Alert.AlertType.ERROR);
        }
    }

    private void removeSavingsAccount(SavingsAccount selectedSavingsAccount) {
        if (selectedSavingsAccount != null) {
            if (showConfirmationMessage("¿Está seguro de eliminar esta cuenta de ahorro?")) {
                if (savingsAccountManagementController.removeSavingAccount(selectedSavingsAccount)) {
                    savingsAccountsList.remove(selectedSavingsAccount);
                    tableManagementAccounts.refresh(); // Refrescar la tabla
                    showMessage("Notificación", "Cuenta de ahorro eliminada", "La cuenta de ahorro ha sido eliminada con éxito", Alert.AlertType.INFORMATION);
                    clearData();
                    deselectSavingAccount();
                } else {
                    showMessage("Error", "Eliminación fallida", "No se pudo eliminar la cuenta de ahorro.", Alert.AlertType.ERROR);
                }
            }
        } else {
            showMessage("Advertencia", "Selección requerida", "Debe seleccionar una cuenta de ahorro para eliminar", Alert.AlertType.WARNING);
        }
    }

    private void updateSavingAccount() {
        if (selectedSavingsAccount != null) {
            SavingsAccount savingsAccountUpdate = buildDataSavingsAccount();
            boolean result = savingsAccountManagementController.updateSavingAccount(selectedSavingsAccount, savingsAccountUpdate);
            if (result) {
                uptadeSavingAccountList(selectedSavingsAccount, savingsAccountUpdate);
                tableManagementAccounts.refresh(); // Refrescar la tabla
                showMessage("Notificación cuenta de ahorro", "Cuenta de ahorro actualizada", "La cuenta de ahorro ha sido actualizada con éxito", Alert.AlertType.INFORMATION);
                clearData();
            } else {
                showMessage("Error", "Actualización fallida", "No se pudo actualizar la cuenta de ahorro.", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Error", "Selección requerida", "Debe seleccionar una cuenta de ahorro.", Alert.AlertType.WARNING);
        }
    }

    private void uptadeSavingAccountList(SavingsAccount selectedSavingsAccount, SavingsAccount savingsAccountUpdate) {
        int index = savingsAccountsList.indexOf(selectedSavingsAccount);
        if (index != -1) {
            savingsAccountsList.set(index, savingsAccountUpdate);
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


    private SavingsAccount buildDataSavingsAccount() {
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setBalance(Double.parseDouble(txtBalance.getText()));
        savingsAccount.setAccountNumber(txtAccountNumber.getText());
        savingsAccount.setOpeningDate(LocalDate.now());
        savingsAccount.setSecurityNumber(Integer.parseInt(txtSecurityNumber.getText()));
        return savingsAccount;
    }

    private boolean validateForm() {
        return !txtBalance.getText().isEmpty()
                && !txtSecurityNumber.getText().isEmpty()
                && !txtAccountNumber.getText().isEmpty();
    }


}