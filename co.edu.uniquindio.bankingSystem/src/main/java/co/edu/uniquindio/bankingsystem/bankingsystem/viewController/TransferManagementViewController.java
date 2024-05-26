package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.Transfer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TransferManagementViewController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker dpDateTransfer;

    @FXML
    private TableView<Transfer> TblManagementTransfer;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnNew;

    @FXML
    private ComboBox<Account> cbAccountOrigin;

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
    private TextField txtAmount;

    @FXML
    private TextField txtFilterTransfer;

    @FXML
    private TextField txtTransferNumber;

    @FXML
    void onAccountOrigin(ActionEvent event) {

    }

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