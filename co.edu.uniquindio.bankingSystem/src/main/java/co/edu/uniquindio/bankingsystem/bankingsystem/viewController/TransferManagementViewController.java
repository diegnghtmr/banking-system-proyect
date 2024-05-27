package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.controller.TransferManagementController;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.Transfer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class TransferManagementViewController {
    TransferManagementController transferManagementController;
    ObservableList<Transfer> transferList = FXCollections.observableArrayList();
    FilteredList<Transfer> filteredTransferList;

    Transfer transferSelected;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Transfer> tableManagementTransfer;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnNew;

    @FXML
    private ComboBox<Account> cbAccountOrigin;

    @FXML
    private TableColumn<Transfer, String> tcAccountDestination;

    @FXML
    private TableColumn<Transfer, String> tcAccountOrigin;

    @FXML
    private TableColumn<Transfer, String> tcAmount;

    @FXML
    private TableColumn<Transfer, String> tcDateTransfer;

    @FXML
    private TableColumn<Transfer, String> tcReferenceNumber;

    @FXML
    private TextField txtAccountDestination;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtFilter;

    @FXML
    void onAdd(ActionEvent event) {
        addTransfer();
    }

    @FXML
    void onNew(ActionEvent event) {
        clearData();
        deselectTransfer();
    }

    @FXML
    void initialize() {
        transferManagementController = new TransferManagementController();
        initView();
        setupFilter();
        uploadAccounts();
    }

    private void initView() {
        initDataBinding();
        getTransferList();
        tableManagementTransfer.getItems().clear();
        tableManagementTransfer.setItems(filteredTransferList);
        listenerSelection();
    }

    private void initDataBinding() {
        tcAccountDestination.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAccountDestination().getAccountNumber()));
        tcAccountOrigin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAccount().getAccountNumber()));
        tcAmount.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAmount())));
        tcDateTransfer.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getDate())));
        tcReferenceNumber.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getReferenceNumber())));
    }

    private void getTransferList() {
        transferList.addAll(transferManagementController.getTransferList());
        filteredTransferList = new FilteredList<>(transferList, p -> true);
    }

    private void listenerSelection() {
        tableManagementTransfer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newSelection) -> {
            transferSelected = newSelection;
            showInformationTransfer();
        });
    }

    private void showInformationTransfer() {
        if (transferSelected != null) {
            txtAmount.setText(String.valueOf(transferSelected.getAmount()));
            txtAccountDestination.setText(transferSelected.getAccountDestination().getAccountNumber());
            cbAccountOrigin.setValue(transferSelected.getAccount());
        }
    }

    private void setupFilter() {
        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            List<Transfer> originalList = transferManagementController.getTransferList();
            ObservableList<Transfer> filteredList = filterList(originalList, newValue);
            tableManagementTransfer.setItems(filteredList);
        });
    }

    private ObservableList<Transfer> filterList(List<Transfer> originalList, String searchText) {
        List<Transfer> filteredList = new ArrayList<>();
        for (Transfer transfer : originalList) {
            if (searchFindsTransfer(transfer, searchText)) filteredList.add(transfer);
        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchFindsTransfer(Transfer transfer, String searchText) {
        String referenceNumber = String.valueOf(transfer.getReferenceNumber());
        return (transfer.getAccount().getAccountNumber().toLowerCase().contains(searchText.toLowerCase())) ||
                (transfer.getAccountDestination().getAccountNumber().toLowerCase().contains(searchText.toLowerCase())) ||
                (referenceNumber.contains(searchText.toLowerCase()));
    }

    private void uploadAccounts() {
        cbAccountOrigin.setItems(FXCollections.observableArrayList(transferManagementController.getAccountsList()));
        cbAccountOrigin.setCellFactory(new Callback<ListView<Account>, ListCell<Account>>() {
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
        cbAccountOrigin.setConverter(new StringConverter<Account>() {
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
                return cbAccountOrigin.getItems().stream().filter(ap ->
                        ap.getAccountNumber().equals(accountNumber)).findFirst().orElse(null);
            }
        });
    }

    private void addTransfer() {
        if (validateForm()) {
            Transfer transfer = buildDataTransfer();
            if (transferManagementController.createTransfer(transfer)) {
                transferList.add(transfer);
                showMessage("Notificacion Transferencia", "Transferencia Creada",
                        "La transferencia ha sido creada con exito", Alert.AlertType.INFORMATION);
                clearData();
                deselectTransfer();
            } else {
                showMessage("Error Transferencia", "Creación fallida",
                        "No se pudo crear la transferencia", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Error", "Datos invalidos",
                    "Por favor, ingrese datos validos", Alert.AlertType.ERROR);
        }
    }

    private boolean validateForm() {
        return !txtAmount.getText().isEmpty()
                && !txtAccountDestination.getText().isEmpty()
                && cbAccountOrigin.getValue() != null;
    }

    private Transfer buildDataTransfer() {
        Transfer transfer = transferManagementController.createTransferProduct();
        transfer.setAccount(cbAccountOrigin.getValue());
        transfer.setAmount(Double.parseDouble(txtAmount.getText()));
        transfer.setAccountDestination(transferManagementController.getAccountByAccountNumber(txtAccountDestination.getText()));
        return transfer;
    }

    private void clearData() {
        txtAmount.setText("");
        txtAccountDestination.setText("");
        cbAccountOrigin.setValue(null);
    }

    private void deselectTransfer() {
        tableManagementTransfer.getSelectionModel().clearSelection();
        transferSelected = null;
    }

    private void showMessage(String title, String header, String content, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(title);
        aler.setHeaderText(header);
        aler.setContentText(content);
        aler.showAndWait();
    }
}

