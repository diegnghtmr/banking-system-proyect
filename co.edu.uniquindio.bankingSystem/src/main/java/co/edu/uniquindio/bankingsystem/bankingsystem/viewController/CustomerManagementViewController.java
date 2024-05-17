package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import co.edu.uniquindio.bankingsystem.bankingsystem.controller.CustomerManagementController;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.builder.CustomerBuilder;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class CustomerManagementViewController {
    CustomerManagementController customerManagementController;
    ObservableList<Customer> customerList = FXCollections.observableArrayList();

    FilteredList<Customer> filteredCustomerList;

    Customer selectedCustomer;

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
    private Button btnGetAge;

    @FXML
    private Button btnGetPostRegistration;

    @FXML
    private DatePicker dpBirthDate;

    @FXML
    private DatePicker dpGetPostRegistration;

    @FXML
    private TableView<Customer> tblCustomer;

    @FXML
    private TableColumn<Customer, String> tcBirthDate;

    @FXML
    private TableColumn<Customer, String> tcRegistrationDate;

    @FXML
    private TableColumn<Customer, String> tcAddress;

    @FXML
    private TableColumn<Customer, String> tcDNI;

    @FXML
    private TableColumn<Customer, String> tcEmail;

    @FXML
    private TableColumn<Customer, String> tcName;

    @FXML
    private TableColumn<Customer, String> tcPhoneNumber;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtGetAge;

    @FXML
    private TextField txtDNI;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhoneNumber;

    @FXML
    private TextField txtFilter;

    @FXML
    void onAdd(ActionEvent event) {
        addCustomer();
    }

    @FXML
    void onNew(ActionEvent event) {
        clearData();
        deselectCustomer();
    }

    @FXML
    void onRemove(ActionEvent event) {
        removeCustomer(selectedCustomer);
    }



    @FXML
    void onUpdate(ActionEvent event) {
        updateCustomer();
    }

    @FXML
    void initialize() {
        customerManagementController = new CustomerManagementController();
        initView();
        setupFilter();
    }

    private void initView() {
        initDataBinding();
        getCustomerList();
        tblCustomer.getItems().clear();
        tblCustomer.setItems(filteredCustomerList);
        listenerSelection();
    }

    private void initDataBinding() {
        tcName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        tcDNI.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDNI()));
        tcEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        tcPhoneNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhoneNumber()));
        tcAddress.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress()));
        tcBirthDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBirthDate().toString()));
        tcRegistrationDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRegistrationDate().toString()));
    }

    public void getCustomerList() {
        customerList.addAll(customerManagementController.getCustomerList());
        filteredCustomerList = new FilteredList<>(customerList, p -> true);
    }

    private void setupFilter() {
        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            List<Customer> originalList = customerManagementController.getCustomerList();
            ObservableList<Customer> filteredList = filterList(originalList, newValue);
            tblCustomer.setItems(filteredList);
        });
    }

    private boolean searchFindsCustomer(Customer customer, String searchText){
    return (customer.getDNI().toLowerCase().contains(searchText.toLowerCase())) ||
            (customer.getEmail().toLowerCase().contains(searchText.toLowerCase()));
}

    private ObservableList<Customer> filterList(List<Customer> list, String searchText){
        List<Customer> filteredList = new ArrayList<>();
        for (Customer customer : list){
            if(searchFindsCustomer(customer, searchText)) filteredList.add(customer);
        }
        return FXCollections.observableList(filteredList);
    }

    private void listenerSelection() {
        tblCustomer.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCustomer = newSelection;
            showInformationCustomer(selectedCustomer);
        });
    }

    private void showInformationCustomer(Customer selectedCustomer) {
        if(selectedCustomer!=null){
            txtName.setText(selectedCustomer.getName());
            txtDNI.setText(selectedCustomer.getDNI());
            txtEmail.setText(selectedCustomer.getEmail());
            txtPhoneNumber.setText(selectedCustomer.getPhoneNumber());
            txtAddress.setText(selectedCustomer.getAddress());
            dpBirthDate.setValue(selectedCustomer.getBirthDate());
        }
    }

    private void deselectCustomer() {
        tblCustomer.getSelectionModel().clearSelection();
        selectedCustomer = null;
    }

    private void addCustomer() {
        if (validateForm()) {
            Customer customer = buildDataCustomer();
            if (customerManagementController.createCustomer(customer)) {
                customerList.add(customer);
                showMessage("Notificación Cliente", "Cliente creado",
                        "El cliente ha sido creado con éxito", Alert.AlertType.INFORMATION);
                clearData();
            } else {
                showMessage("Error", "Creación fallida",
                        "No se pudo crear el cliente.", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Error", "Datos invalidos",
                    "Por favor, ingrese datos validos", Alert.AlertType.ERROR);
        }
    }

    private void clearData() {
        txtName.setText("");
        txtDNI.setText("");
        txtEmail.setText("");
        txtPhoneNumber.setText("");
        txtAddress.setText("");
        dpBirthDate.setValue(null);
    }

    private boolean validateForm() {
        return !txtName.getText().isEmpty()
                && !txtDNI.getText().isEmpty()
                && !txtEmail.getText().isEmpty()
                && !txtPhoneNumber.getText().isEmpty()
                && !txtAddress.getText().isEmpty()
                && dpBirthDate.getValue() != null;
    }

    private Customer buildDataCustomer() {
        return new CustomerBuilder()
                .setName(txtName.getText())
                .setDNI(txtDNI.getText())
                .setAdress(txtAddress.getText())
                .setEmail(txtEmail.getText())
                .setPhoneNumber(txtPhoneNumber.getText())
                .setBirthDate(dpBirthDate.getValue())
                .setRegistrationDate(LocalDate.now())
                .build();
    }

    private void removeCustomer(Customer selectedCustomer) {
        if(selectedCustomer!=null){
            if(showConfirmationMessage("¿Está seguro que desea eliminar este cliente?")){
                if(customerManagementController.removeCustomer(selectedCustomer)){
                    int index = customerList.indexOf(selectedCustomer);
                    customerList.remove(index);

                    showMessage("Notificación", "Cliente eliminado", "El cliente ha sido eliminado con éxito", Alert.AlertType.INFORMATION);
                    clearData();
                    deselectCustomer();
                }else{
                    showMessage("Error", "Eliminación fallida", "No se pudo eliminar el cliente.", Alert.AlertType.ERROR);
                }
            }
        }else{
            showMessage("Advertencia", "Selección requerida", "Debe seleccionar un cliente para eliminar.", Alert.AlertType.WARNING);
        }
    }

    private void updateCustomer() {
        if (selectedCustomer != null) {
            Customer customerUpdate = buildDataCustomer();
            boolean result = customerManagementController.upDateCustomer(selectedCustomer, customerUpdate);
            if (result) {
                updateClientList(selectedCustomer, customerUpdate);
                showMessage("Notificación Cliente", "Cliente actualizado",
                        "El cliente ha sido actualizado con éxito", Alert.AlertType.INFORMATION);
                clearData();
            } else {
                showMessage("Error", "Actualización fallida",
                        "No se pudo actualizar el cliente.", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Error", "Selección requerida",
                    "Debe seleccionar un cliente para actualizar.", Alert.AlertType.WARNING);
        }
    }

    private void updateClientList(Customer selectedCustomer, Customer customerUpdate) {
        int index = customerList.indexOf(selectedCustomer);
        if (index != -1) {
            customerList.set(index, customerUpdate);
        }
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
