package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class LoanManagementViewController {

    LoanManagementController loanManagementController;
    ObservableList<LoanDto> loanList = FXCollections.observableArrayList();

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

    }

    @FXML
    void onApplicant(ActionEvent event) {

    }

    @FXML
    void onLoanDate(ActionEvent event) {

    }

    @FXML
    void onNew(ActionEvent event) {

    }

    @FXML
    void initialize() {
        loanManagementController = new LoanManagementController();
        initView();
        setupFilter();

    }


    private void initView() {
        initDataBinding();
        getLoanList();
        tblData.getItems().clear();
        tblData.setItems(loanList);
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

    private boolean searchFindsLoanDto(LoanDto loanDto, String searchText) {
        return (loanDto.referenceNumber().toLowerCase().contains(searchText.toLowerCase()));
    }


}
