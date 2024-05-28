package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.controller.DepositManagementController;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.Deposit;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class DepositManagementViewController {
    DepositManagementController depositManagementController;
    ObservableList<Deposit> depositList = FXCollections.observableArrayList();
    FilteredList<Deposit> filteredDepositList;

    Deposit depositSelected;

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
    private TableView<Deposit> tableManagementDeposit;

    @FXML
    private TableColumn<Deposit, String> tcAccount;

    @FXML
    private TableColumn<Deposit, String> tcAmount;

    @FXML
    private TableColumn<Deposit, String> tcDepositDate;

    @FXML
    private TableColumn<Deposit, String> tcReferenceNumber;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtFilter;

    @FXML
    void onAdd(ActionEvent event) {
        addDeposit();
    }

    @FXML
    void onNew(ActionEvent event) {
        clearData();
        deselectDeposit();
    }

    @FXML
    void initialize() {
        depositManagementController = new DepositManagementController();
        initView();
        setupFilter();
        uploadAccounts();
    }

    private void initView() {
        initDataBinding();
        getDepositList();
        tableManagementDeposit.getItems().clear();
        tableManagementDeposit.setItems(filteredDepositList);
        listenerSelection();
    }

    private void initDataBinding() {
        tcAccount.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAccount().getAccountNumber()));
        tcAmount.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAmount())));
        tcDepositDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate().toString()));
        tcReferenceNumber.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getReferenceNumber())));
    }

    private void getDepositList() {
        depositList.addAll(depositManagementController.getEmployeesList());
        filteredDepositList = new FilteredList<>(depositList, p -> true);
    }

    private void setupFilter() {
        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            List<Deposit> originalList = depositManagementController.getDepositList();
            ObservableList<Deposit> filteredList = filterList(originalList, newValue);
            tableManagementDeposit.setItems(filteredList);
        });
    }

    private ObservableList<Deposit> filterList(List<Deposit> originalList, String searchText) {
        List<Deposit> filteredList = new ArrayList<>();
        for (Deposit deposit : originalList) {
            if (searchFindsDeposit(deposit, searchText)) filteredList.add(deposit);
        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchFindsDeposit(Deposit deposit, String searchText) {
        String referenceNumber = String.valueOf(deposit.getReferenceNumber());
        return (deposit.getAccount().getAccountNumber().toLowerCase().contains(searchText.toLowerCase())) ||
                (referenceNumber.contains(searchText.toLowerCase()));
    }

    private void listenerSelection() {
        tableManagementDeposit.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            depositSelected = newSelection;
            showInformationDeposit(depositSelected);
        });
    }

    private void showInformationDeposit(Deposit depositSelected) {
        if (depositSelected != null) {
            txtAmount.setText(String.valueOf(depositSelected.getAmount()));
            cbAccount.setValue(depositSelected.getAccount());
        }
    }

    private void uploadAccounts() {
        cbAccount.setItems(FXCollections.observableArrayList(depositManagementController.getAccountsList()));
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


    private void addDeposit() {
        if (validateForm()) {
            Deposit deposit = buildDataDeposit();
            if (depositManagementController.createDeposit(deposit)) {
                depositList.add(deposit);
                showMessage("Notificación Deposito", "Deposito creado",
                        "El deposito ha sido creado con éxito", Alert.AlertType.INFORMATION);
                clearData();
                deselectDeposit();
            } else {
                showMessage("Error Deposito", "Creación fallida",
                        "No se pudo crear el deposito.", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Error", "Datos invalidos",
                    "Por favor, ingrese datos validos", Alert.AlertType.ERROR);
        }
    }

    private Deposit buildDataDeposit() {
         Deposit deposit= depositManagementController.createDepositProduct();
         deposit.setAmount(Double.parseDouble(txtAmount.getText()));
         deposit.setAccount(cbAccount.getValue());
        return deposit;
    }

    private boolean validateForm() {
        return !txtAmount.getText().isEmpty()
                && cbAccount.getValue() != null;
    }


    private void clearData() {
        txtAmount.setText("");
        cbAccount.setValue(null);
    }

    private void deselectDeposit() {
        tableManagementDeposit.getSelectionModel().clearSelection();
        depositSelected = null;
    }

    private void showMessage(String title, String header, String content, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(title);
        aler.setHeaderText(header);
        aler.setContentText(content);
        aler.showAndWait();
    }

}
