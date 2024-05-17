package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TransactionManagementViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnApproved;

    @FXML
    private Button btnRefuse;

    @FXML
    private TableView<?> tblData;

    @FXML
    private TableColumn<?, String> tcAmount;

    @FXML
    private TableColumn<?, String> tcApplicant;

    @FXML
    private TableColumn<?, String> tcReferenceNumber;

    @FXML
    private TableColumn<?, String> tcState;

    @FXML
    private TableColumn<?, String> tcTransactionDate;

    @FXML
    private TableColumn<?, String> tcTrasactionType;

    @FXML
    private TextField txtFilter;

    @FXML
    void onApproved(ActionEvent event) {

    }

    @FXML
    void onRefuse(ActionEvent event) {

    }

    @FXML
    void initialize() {

    }

}