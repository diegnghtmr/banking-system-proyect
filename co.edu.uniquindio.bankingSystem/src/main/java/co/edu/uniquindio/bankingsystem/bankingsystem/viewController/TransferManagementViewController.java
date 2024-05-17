package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.Transfer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TransferManagementViewController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker DPDateTransfer;

    @FXML
    private TableView<Transfer> TblManagementTransfer;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnNew;

    @FXML
    private TableColumn<Transfer, String> tbAccountDestination;

    @FXML
    private TableColumn<Transfer, String> tbAccountOrigin;

    @FXML
    private TableColumn<Transfer, String> tbAmount;

    @FXML
    private TableColumn<Transfer, String> tbDateTransfer;

    @FXML
    private TableColumn<Transfer, String> tbTransferNumber;

    @FXML
    private TextField txtAccountDestination;

    @FXML
    private TextField txtAccountOrigin;

    @FXML
    private TextField txtAmount;

    @FXML
    private TextField txtFilterTransfer;

    @FXML
    private TextField txtTransferNumber;

    @FXML
    void onAdd(ActionEvent event) {

    }

    @FXML
    void onNew(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}