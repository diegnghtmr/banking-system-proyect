package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.controller.MovementManagementController;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Transaction;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class MovementManagementViewController {
    MovementManagementController movementManagementController;
    ObservableList<Transaction> transactionList = FXCollections.observableArrayList();
    FilteredList<Transaction> filteredTransactionList;

    Transaction transactionSelected;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGetPreviousRecords;

    @FXML
    private Button btnLook;

    @FXML
    private ComboBox<Account> cbAccount;

    @FXML
    private DatePicker dpMovement;

    @FXML
    private TableView<Transaction> tblMovement;

    @FXML
    private TableColumn<Transaction, String> tcAccount;

    @FXML
    private TableColumn<Transaction, String> tcAmount;

    @FXML
    private TableColumn<Transaction, String> tcMovementDate;

    @FXML
    private TableColumn<Transaction, String> tcReferenceNumber;

    @FXML
    private TableColumn<Transaction, String> tcTransactionType;

    @FXML
    private TextField txtFilter;

    @FXML
    void onGetPreviousRecords(ActionEvent event) {
        getPreviousRecords();
    }

    @FXML
    void onLook(ActionEvent event) {
        lookByAccount();
    }

    @FXML
    void initialize() {
        movementManagementController = new MovementManagementController();
        initView();
        setupFilter();
        uploadAccounts();
    }

    private void initView() {
        initDataBinding();
        getTransactionList();
        tblMovement.getItems().clear();
        tblMovement.setItems(filteredTransactionList);
        listenerSelection();
    }

    private void initDataBinding() {
        tcAccount.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAccount().getAccountNumber()));
        tcAmount.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAmount())));
        tcMovementDate.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDate())));
        tcReferenceNumber.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getReferenceNumber())));
        tcTransactionType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTransactionType()));
    }

    private void getTransactionList() {
        transactionList.addAll(movementManagementController.getTransactionList());
        filteredTransactionList = new FilteredList<>(transactionList, p -> true);
    }

    private void listenerSelection() {
        tblMovement.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            transactionSelected = newSelection;
            showInformationTransaction();
        });
    }

    private void showInformationTransaction() {
        if (transactionSelected != null) {
            cbAccount.setValue(transactionSelected.getAccount());
            dpMovement.setValue(transactionSelected.getDate());
        }
    }

    private void setupFilter() {
        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            List<Transaction> originalList = movementManagementController.getTransactionList();
            ObservableList<Transaction> filteredList = filterList(originalList, newValue);
            tblMovement.setItems(filteredList);
        });
    }

    private ObservableList<Transaction> filterList(List<Transaction> originalList, String searchText) {
        List<Transaction> filteredList = new ArrayList<>();
        for (Transaction transaction : originalList) {
            if (searchFindsTransaction(transaction, searchText)) filteredList.add(transaction);
        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchFindsTransaction(Transaction transaction, String searchText) {
        String referenceNumber = String.valueOf(transaction.getReferenceNumber());
        return (transaction.getAccount().getAccountNumber().toLowerCase().contains(searchText.toLowerCase())) ||
                (referenceNumber.contains(searchText.toLowerCase()));
    }

    private void uploadAccounts() {
        cbAccount.setItems(FXCollections.observableArrayList(movementManagementController.getAccountsList()));
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

    private void getPreviousRecords() {
        LocalDate date = dpMovement.getValue();
        Account account = cbAccount.getValue();
        if (date != null && account != null) {
            transactionList.clear();
            transactionList.addAll(movementManagementController.getPreviousRecords(date, account));
        }
    }

    private void lookByAccount() {
        Account account = cbAccount.getValue();
        if (account != null) {
            transactionList.clear();
            transactionList.addAll(movementManagementController.lookByAccount(account));
        }
    }
}
