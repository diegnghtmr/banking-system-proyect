package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.controller.AccountAssociationManagementController;
import co.edu.uniquindio.bankingsystem.bankingsystem.dto.AccountAssociationDto;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.AccountAssociation;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AccountAssociationManagementViewController {


    AccountAssociationManagementController accountAssociationManagementController;
    ObservableList<AccountAssociationDto> accountAssociationList = FXCollections.observableArrayList();
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
        associateAccount();

    }


    @FXML
    void onCustomers(ActionEvent event) {

    }

    @FXML
    void onDelete(ActionEvent event) {
        deleteAssociation();

    }


    @FXML
    void initialize() {
        accountAssociationManagementController = new AccountAssociationManagementController();
        initView();
        setupFilter();
        loadUnassociatedData();

    }

    private void initView() {
        initDataBinding();
        getAccountAssociationList();
        tblData.getItems().clear();
        tblData.setItems(accountAssociationList);
    }


    private void initDataBinding() {
        tcCustomerName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().name()));
        tcCustomersID.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().dni()));
        tcAccountNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().accountNumber()));
        tcAccountType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().accountType()));
    }

    private void getAccountAssociationList() {
        accountAssociationList.addAll(accountAssociationManagementController.getAccountAssociationList());
    }

    private void setupFilter() {
        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            List<AccountAssociationDto> originalList = accountAssociationManagementController.getAccountAssociationList();
            ObservableList<AccountAssociationDto> filteredList = filteredList(originalList, newValue);
            tblData.setItems(filteredList);
        });
    }

    private ObservableList<AccountAssociationDto> filteredList(List<AccountAssociationDto> originalList, String searchTest) {
        List<AccountAssociationDto> filteredList = new ArrayList<>();
        for (AccountAssociationDto accountAssociationDto : originalList) {
            if (searchFindsAccountAssociationDto(accountAssociationDto, searchTest))
                filteredList.add(accountAssociationDto);

        }
        return FXCollections.observableList(filteredList);
    }

    private boolean searchFindsAccountAssociationDto(AccountAssociationDto accountAssociationDto, String searchTest) {
        return (accountAssociationDto.accountNumber().toLowerCase().contains(searchTest.toLowerCase())) || (accountAssociationDto.dni().toLowerCase().contains(searchTest.toLowerCase()));
    }

    private void loadUnassociatedData() {
        cbCustomers.setItems(FXCollections.observableArrayList(accountAssociationManagementController.getUnassociatedCustomers()));
        cbAccounts.setItems(FXCollections.observableArrayList(accountAssociationManagementController.getUnassociatedAccounts()));
    }

    private void associateAccount() {
        Customer selectedCustomer = cbCustomers.getSelectionModel().getSelectedItem();
        Account selectedAccount = cbAccounts.getSelectionModel().getSelectedItem();


        if (selectedCustomer != null && selectedAccount != null) {
            AccountAssociation newAssociation = new AccountAssociation(selectedCustomer, selectedAccount);
            accountAssociationManagementController.addAssociation(newAssociation);
            refreshTablesAndComboBoxes(); // Actualizar la interfaz de usuario
            // Limpiar selecciones en los ComboBoxes
            cbCustomers.getSelectionModel().clearSelection();
            cbAccounts.getSelectionModel().clearSelection();
        } else {
            showAlert("Error de selección", "Seleccione un cliente y una cuenta antes de asociar.", Alert.AlertType.ERROR);
        }
    }


    private void deleteAssociation() {
        AccountAssociationDto selectedAssociation = tblData.getSelectionModel().getSelectedItem();
        if (selectedAssociation != null) {
            if (showConfirmationMessage("¿Está seguro de eliminar esta asociación?")) {
                String dni = selectedAssociation.dni();
                String accountNumber = selectedAssociation.accountNumber();
                Customer customer = accountAssociationManagementController.getCustomerByDni(dni);
                Account account = accountAssociationManagementController.getAccountByNumber(accountNumber);
                if (customer != null) {
                    if (accountAssociationManagementController.removeAssociation(customer, account)) {
                        accountAssociationList.remove(selectedAssociation);
                        tblData.refresh();
                        showAlert("Notificación", "La asociación ha sido eliminada con éxito", Alert.AlertType.INFORMATION);
                        refreshTablesAndComboBoxes();
                    } else {
                        showAlert("Error", "No se pudo eliminar la asociación.", Alert.AlertType.ERROR);
                    }
                }
            }
        } else {
            showAlert("Advertencia",  "Debe seleccionar una asociación para eliminar", Alert.AlertType.WARNING);
        }
    }




    private void refreshTablesAndComboBoxes() {
        accountAssociationList.clear(); // Limpiar la lista para evitar duplicados
        getAccountAssociationList(); // Volver a obtener la lista actualizada de asociaciones
        tblData.setItems(accountAssociationList); // Actualizar la tabla
        loadUnassociatedData();
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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

}

