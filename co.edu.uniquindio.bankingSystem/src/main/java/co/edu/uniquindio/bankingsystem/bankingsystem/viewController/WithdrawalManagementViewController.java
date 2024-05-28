package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.controller.WithdrawalManagementController;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.Withdrawal;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class WithdrawalManagementViewController {
    WithdrawalManagementController withdrawalManagementController;
    ObservableList<Withdrawal> withdrawalList = FXCollections.observableArrayList();
    FilteredList<Withdrawal> filteredWithdrawalList;

    Withdrawal withdrawalSelected;

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
    private TableView<Withdrawal> tableManagementWithdrawal;

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
    void onAdd(ActionEvent event) {
        addWithdrawal();
    }


    @FXML
    void onNew(ActionEvent event) {
        clearData();
        deselectWithdrawal();
    }

    @FXML
    void initialize() {
        withdrawalManagementController = new WithdrawalManagementController();
        initView();
        setupFilter();
        uploadAccounts();
    }

    private void initView() {
        initDataBinding();
        getWithdrawalList();
        tableManagementWithdrawal.getItems().clear();
        tableManagementWithdrawal.setItems(filteredWithdrawalList);
        listenerSelection();
    }

    private void initDataBinding() {
        tcAccount.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAccount().getAccountNumber()));
        tcAmount.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAmount())));
        tcWithdrawalDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
        tcReferenceNumber.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getReferenceNumber())));
    }

    private void getWithdrawalList() {
        withdrawalList.addAll(withdrawalManagementController.getWithdrawalList());
        filteredWithdrawalList = new FilteredList<>(withdrawalList, p -> true);
    }

    private void listenerSelection() {
        tableManagementWithdrawal.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newSelection) -> {
            withdrawalSelected = newSelection;
            showInformationWithdrawal();
        });
    }

    private void showInformationWithdrawal() {
        if (withdrawalSelected != null) {
            txtAmount.setText(String.valueOf(withdrawalSelected.getAmount()));
            cbAccount.setValue(withdrawalSelected.getAccount());
        }
    }


    private void setupFilter() {
        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            List<Withdrawal> originalList = withdrawalManagementController.getWithdrawalList();
            ObservableList<Withdrawal> filteredList = filterList(originalList, newValue);
            tableManagementWithdrawal.setItems(filteredList);
        });
    }

    private ObservableList<Withdrawal> filterList(List<Withdrawal> originalList, String searchText) {
        List<Withdrawal> filteredList = new ArrayList<>();
        for (Withdrawal withdrawal : originalList) {
            if (searchFindsWithdrawal(withdrawal, searchText)) filteredList.add(withdrawal);
        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchFindsWithdrawal(Withdrawal withdrawal, String searchText) {
        String referenceNumber = String.valueOf(withdrawal.getReferenceNumber());
        return (withdrawal.getAccount().getAccountNumber().toLowerCase().contains(searchText.toLowerCase())) ||
                (referenceNumber.contains(searchText.toLowerCase()));
    }

    private void uploadAccounts() {
        cbAccount.setItems(FXCollections.observableArrayList(withdrawalManagementController.getAccountsList()));
        cbAccount.setCellFactory(new Callback<ListView<Account>, ListCell<Account>>() {
            @Override
            public ListCell<Account> call(ListView<Account> param) {
                return new ListCell<Account>() {
                    @Override
                    protected void updateItem(Account item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText(item.getAccountNumber());
                        }
                    }
                };
            }
        });
        cbAccount.setConverter(new StringConverter<Account>() {
            @Override
            public String toString(Account account) {
                if (account == null) {
                    return null;
                } else {
                    return account.getAccountNumber();
                }
            }
            @Override
            public Account fromString(String accountNumber) {
                return cbAccount.getItems().stream().filter(ap ->
                        ap.getAccountNumber().equals(accountNumber)).findFirst().orElse(null);
            }
        });
    }

    private void addWithdrawal() {
        if (validateForm()) {
            Withdrawal withdrawal = buildDataWithdrawal();
            if (withdrawalManagementController.createWithdrawal(withdrawal)) {
                withdrawalList.add(withdrawal);
                showMessage("Notificación Retiro", "Retiro creado",
                        "El retiro ha sido creado con éxito", Alert.AlertType.INFORMATION);
                clearData();
                deselectWithdrawal();
            } else {
                showMessage("Error Retiro", "Creación fallida",
                        "No se pudo crear el retiro.", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Error", "Datos invalidos",
                    "Por favor, ingrese datos validos", Alert.AlertType.ERROR);
        }
    }

    private boolean validateForm() {
        return !txtAmount.getText().isEmpty()
                && cbAccount.getValue() != null;
    }

    private Withdrawal buildDataWithdrawal() {
        Withdrawal withdrawal = withdrawalManagementController.createWithdrawalProduct();
        withdrawal.setAccount(cbAccount.getValue());
        withdrawal.setAmount(Double.parseDouble(txtAmount.getText()));
        return withdrawal;
    }

    private void clearData() {
        txtAmount.clear();
        cbAccount.setValue(null);
    }

    private void deselectWithdrawal() {
        tableManagementWithdrawal.getSelectionModel().clearSelection();
        withdrawalSelected = null;
    }

    private void showMessage(String title, String header, String content, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(title);
        aler.setHeaderText(header);
        aler.setContentText(content);
        aler.showAndWait();
    }
}
