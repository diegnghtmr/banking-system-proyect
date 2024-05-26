package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;


import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.controller.CashierManagementController;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Employee;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.builder.EmployeeBuilder;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.enums.TypeEmployee;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CashierManagementViewController {
    CashierManagementController cashierManagementController;
    ObservableList<Employee> cashierList = FXCollections.observableArrayList();
    FilteredList<Employee> filteredCashierList;

    Employee cashierSelected;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btbRemove;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableView<Employee> tblCashier;

    @FXML
    private TableColumn<Employee, String> tcAddress;

    @FXML
    private TableColumn<Employee, String> tcDNI;

    @FXML
    private TableColumn<Employee, String> tcEmail;

    @FXML
    private TableColumn<Employee, String> tcName;

    @FXML
    private TableColumn<Employee, String> tcPassword;

    @FXML
    private TableColumn<Employee, String> tcPhoneNumber;

    @FXML
    private TableColumn<Employee, String> tcRegistrationDate;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtDNI;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFilter;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    void onAdd(ActionEvent event) {
        addCashier();

    }

    @FXML
    void onNew(ActionEvent event) {
        clearData();
        deselectCashier();
    }

    @FXML
    void onRemove(ActionEvent event) {
        removeCashier(cashierSelected);

    }

    @FXML
    void onUpdate(ActionEvent event) {
        updateCashier();

    }

    @FXML
    void initialize() {
        cashierManagementController = new CashierManagementController();
        initView();
        setupFilter();
    }

    private void initView() {
        initDataBinding();
        getCashierList();
        tblCashier.getItems().clear();
        tblCashier.setItems(filteredCashierList);
        listenerSelection();
    }

    private void initDataBinding() {
        tcName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        tcDNI.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDNI()));
        tcEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        tcPhoneNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhone()));
        tcAddress.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress()));
        tcRegistrationDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRegistrationDate().toString()));
        tcPassword.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPassword()));
    }

    private void getCashierList() {
        cashierList.addAll(cashierManagementController.getEmployeesList());
        filteredCashierList = new FilteredList<>(cashierList, p -> true);
    }

    private void setupFilter() {
        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            List<Employee> originalList = cashierManagementController.getEmployeesList();
            ObservableList<Employee> filteredList = filterList(originalList, newValue);
            tblCashier.setItems(filteredList);
        });
    }

    private boolean searchFindsCashier(Employee employee, String searchText){
        return (employee.getDNI().toLowerCase().contains(searchText.toLowerCase())) ||
                (employee.getEmail().toLowerCase().contains(searchText.toLowerCase()));
    }

    private ObservableList<Employee> filterList(List<Employee> list, String searchText){
        List<Employee> filteredList = new ArrayList<>();
        for (Employee employee : list){
            if(searchFindsCashier(employee, searchText)) filteredList.add(employee);
        }
        return FXCollections.observableList(filteredList);
    }

    private void listenerSelection() {
        tblCashier.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            cashierSelected = newSelection;
            showInformationCashier(cashierSelected);
        });
    }

    private void showInformationCashier(Employee cashierSelected) {
        if(cashierSelected != null){
            txtName.setText(cashierSelected.getName());
            txtAddress.setText(cashierSelected.getAddress());
            txtDNI.setText(cashierSelected.getDNI());
            txtEmail.setText(cashierSelected.getEmail());
            txtPassword.setText(cashierSelected.getPassword());
            txtPhoneNumber.setText(cashierSelected.getPhone());
        }
    }

    private void deselectCashier() {
        tblCashier.getSelectionModel().clearSelection();
        cashierSelected = null;
    }

    private void addCashier() {
        if (validateForm()) {
            Employee cashier = buildDataCashier();
            if (cashierManagementController.createCashier(cashier)) {
                cashierList.add(cashier);
                showMessage("Notificación Cajero", "Cajero creado",
                        "El cajero ha sido creado con éxito", Alert.AlertType.INFORMATION);
                clearData();
            } else {
                showMessage("Error", "Creación fallida",
                        "No se pudo crear el cajero.", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Error", "Datos invalidos",
                    "Por favor, ingrese datos validos", Alert.AlertType.ERROR);
        }
    }


    private void removeCashier(Employee cashierSelected) {
        if(cashierSelected!=null){
            if(showConfirmationMessage("¿Está seguro que desea eliminar este cliente?")){
                if(cashierManagementController.removeCashier(cashierSelected)){
                    int index = cashierList.indexOf(cashierSelected);
                    cashierList.remove(index);
                    showMessage("Notificación", "Cajero eliminado", "El cajero ha sido eliminado con éxito", Alert.AlertType.INFORMATION);
                    clearData();
                    deselectCashier();
                } else{
                    showMessage("Error", "Eliminación fallida", "No se pudo eliminar el cajero.", Alert.AlertType.ERROR);
                }
            }
        }else{
            showMessage("Advertencia", "Selección requerida", "Debe seleccionar un cajero para eliminar.", Alert.AlertType.WARNING);
        }


    }

    private void updateCashier() {
        if (cashierSelected != null) {
            Employee cashierUpdate = buildDataCashier();
            boolean result = cashierManagementController.upDateCashier(cashierSelected, cashierUpdate);
            if (result) {
                updateCashierList(cashierSelected, cashierUpdate);
                showMessage("Notificación Cajero", "Cajero actualizado",
                        "El cajero ha sido actualizado con éxito", Alert.AlertType.INFORMATION);
                clearData();
            } else {
                showMessage("Error", "Actualización fallida",
                        "No se pudo actualizar el cajero.", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Error", "Selección requerida",
                    "Debe seleccionar un cajero para actualizar.", Alert.AlertType.WARNING);
        }
    }

    private void updateCashierList(Employee cashierSelected, Employee cashierUpdate) {
        int index = cashierList.indexOf(cashierSelected);
        if (index != -1) {
            cashierList.set(index, cashierUpdate);
        }
    }

    private Employee buildDataCashier() {
        return new EmployeeBuilder()
                .setName(txtName.getText())
                .setDNI(txtDNI.getText())
                .setEmail(txtEmail.getText())
                .setAddress(txtAddress.getText())
                .setPhone(txtPhoneNumber.getText())
                .setPassword(txtPassword.getText())
                .setRegistrationDate(LocalDate.now())
                .setTypeEmployee(TypeEmployee.CASHIER)
                .build();
    }

    private boolean validateForm() {
        return !txtName.getText().isEmpty()
                && !txtDNI.getText().isEmpty()
                && !txtEmail.getText().isEmpty()
                && !txtPhoneNumber.getText().isEmpty()
                && !txtAddress.getText().isEmpty()
                && !txtPassword.getText().isEmpty();
    }

    private void clearData() {
        txtName.setText("");
        txtDNI.setText("");
        txtEmail.setText("");
        txtPhoneNumber.setText("");
        txtAddress.setText("");
        txtPassword.setText("");


    }

    private boolean showConfirmationMessage(String message){
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
}
