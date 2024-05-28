package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.controller.MovementManagementController;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Transaction;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.dto.MovementDto;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Movement;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MovementManagementViewController {
    MovementManagementController movementManagementController;

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
    private DatePicker dpMovementDate;

    @FXML
    private TableView<MovementDto> tblData;

    @FXML
    private TableColumn<MovementDto, String> tcAccount;

    @FXML
    private TableColumn<MovementDto, String> tcAmount;

    @FXML
    private TableColumn<MovementDto, String> tcMovementDate;

    @FXML
    private TableColumn<MovementDto, String> tcReferenceNumber;

    @FXML
    private TableColumn<MovementDto, String> tcStatus;

    @FXML
    private TableColumn<MovementDto, String> tcTransactionType;

    @FXML
    private TextField txtFilter;

    @FXML
    void onAccount(ActionEvent event) {

    }

    @FXML
    void onGetPreviousRecords(ActionEvent event) {

    }

    @FXML
    void onLook(ActionEvent event) {

    }

    @FXML
    void onMovementDate(ActionEvent event) {

    }

    @FXML
    void initialize() {
        movementManagementController = new MovementManagementController();
        initView();
    }

    private void initView() {
        initDataBinding();
        getMovementList();
        tblData.getItems().clear();
        tblData.setItems(movementList);
    }

    private void initDataBinding() {
        tcAccount.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().account()));
        tcAmount.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().amount()));
        tcMovementDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().movementDate()));
        tcReferenceNumber.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().referenceNumber()));
        tcStatus.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().status()));
        tcTransactionType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().tcTransactionType()));
    }

    private void getMovementList() {
        movementList.addAll(movementManagementController.getMovementList());
    }

    private void refreshTables() {
        movementList.clear();
        tblData.setItems(movementList);
        getMovementList();
    }

      private void clearData() {
        cbAccount.getSelectionModel().clearSelection();
        dpMovementDate.setValue(null);
    }
}