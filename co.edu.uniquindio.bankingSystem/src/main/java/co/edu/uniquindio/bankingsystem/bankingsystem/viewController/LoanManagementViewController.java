package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.controller.LoanManagementController;
import co.edu.uniquindio.bankingsystem.bankingsystem.dto.LoanDto;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Loan;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoanManagementViewController {

    LoanManagementController loanManagementController;
    ObservableList<LoanDto> loanList = FXCollections.observableArrayList();
    LoanDto loanSelected;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnNew;

    @FXML
    private ComboBox<Customer> cbApplicant;

    @FXML
    private DatePicker dpLoanDate;

    @FXML
    private TableView<LoanDto> tblData;

    @FXML
    private TableColumn<LoanDto, String> tcAmount;

    @FXML
    private TableColumn<LoanDto, String> tcApplicant;

    @FXML
    private TableColumn<LoanDto, String> tcLoanDate;

    @FXML
    private TableColumn<LoanDto, String> tcReferenceNumber;

    @FXML
    private TableColumn<LoanDto, String> tcState;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtFilter;

    @FXML
    private TextField txtReferenceNumber;

    @FXML
    void onAdd(ActionEvent event) {
        addLoan();

    }


    @FXML
    void onApplicant(ActionEvent event) {

    }

    @FXML
    void onLoanDate(ActionEvent event) {

    }

    @FXML
    void onNew(ActionEvent event) {
        clearData();

    }

    @FXML
    void initialize() {
        loanManagementController = new LoanManagementController();
        initView();
        setupFilter();
        loadUnassociatedData();

    }




    private void initView() {
        initDataBinding();
        getLoanList();
        tblData.getItems().clear();
        tblData.setItems(loanList);
        listenerSelection();
    }



    private void initDataBinding() {
        tcApplicant.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().idCustomer()));
        tcReferenceNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().referenceNumber()));
        tcAmount.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().amount())));
        tcLoanDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().loanDate()));
        tcState.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().state()));
    }

    private void getLoanList() {
        loanList.addAll(loanManagementController.getLoanList());
    }

    private void setupFilter() {
        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            List<LoanDto> originalList = loanManagementController.getLoanList();
            ObservableList<LoanDto> filteredList = filteredList(originalList, newValue);
            tblData.setItems(filteredList);
        });
    }

    private ObservableList<LoanDto> filteredList(List<LoanDto> originalList, String searchText) {
        List<LoanDto> filteredList = new ArrayList<>();
        for (LoanDto loanDto : originalList) {
            if (searchFindsLoanDto(loanDto, searchText))
                filteredList.add(loanDto);


        }
        return FXCollections.observableList(filteredList);
    }

    private void listenerSelection() {
        tblData.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)->{
            loanSelected = newSelection;
            showInformation(loanSelected);


        });
    }

    private void showInformation(LoanDto loanSelected) {
        if (loanSelected != null) {
            txtReferenceNumber.setText(loanSelected.referenceNumber());
            txtAmount.setText(String.valueOf(loanSelected.amount()));
            dpLoanDate.setValue(LocalDate.parse(loanSelected.loanDate()));
            

        }
    }


    private boolean searchFindsLoanDto(LoanDto loanDto, String searchText) {
        return (loanDto.referenceNumber().toLowerCase().contains(searchText.toLowerCase()));
    }

    private void loadUnassociatedData() {
        cbApplicant.setItems(FXCollections.observableList(loanManagementController.getUnassociatedLoans()));
    }


    private void addLoan() {
        if (validateForm()) {
            Loan newLoan = buildDataLoan();
            boolean success = loanManagementController.addLoan(newLoan);
            if (success) {
                showMessage("Éxito", "Préstamo Agregado", "El préstamo se ha agregado exitosamente.", Alert.AlertType.INFORMATION);
                clearData();
                refreshTables(); // Actualiza la tabla después de agregar el préstamo
            } else {
                showMessage("Error", "Préstamo no Agregado", "Error al agregar el préstamo.", Alert.AlertType.ERROR);
            }
        } else {
            showMessage("Error", "Datos Inválidos", "Por favor complete todos los campos requeridos con datos válidos.", Alert.AlertType.ERROR);
        }
    }

    private void refreshTables() {
        loanList.clear();
        tblData.setItems(loanList);
        loadUnassociatedData();
        getLoanList();
    }

    private boolean validateForm() {
        if (cbApplicant.getSelectionModel().getSelectedItem() == null ||
                txtReferenceNumber.getText().isEmpty() ||
                dpLoanDate.getValue() == null ||
                txtAmount.getText().isEmpty()) {
            return false;
        }
        try {
            Double.parseDouble(txtAmount.getText());
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private Loan buildDataLoan() {
        Customer selectedCustomer = cbApplicant.getSelectionModel().getSelectedItem();
        String referenceNumber = txtReferenceNumber.getText();
        LocalDate loanDate = dpLoanDate.getValue();
        double amount = Double.parseDouble(txtAmount.getText());
        return new Loan(selectedCustomer, referenceNumber, loanDate, amount);
    }

    private void clearData() {
        cbApplicant.getSelectionModel().clearSelection();
        txtReferenceNumber.setText("");
        dpLoanDate.setValue(null);
        txtAmount.setText("");
    }

    private void showMessage(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}
