package co.edu.uniquindio.bankingsystem.bankingsystem.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.bankingsystem.bankingsystem.model.Loan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class LoanManagementViewController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnNew;

    @FXML
    private ComboBox<?> cbApplicant;

    @FXML
    private DatePicker dpLoanDate;

    @FXML
    private TableView<Loan> tblData;

    @FXML
    private TableColumn<Loan, String> tcAmount;

    @FXML
    private TableColumn<Loan, String> tcApplicant;

    @FXML
    private TableColumn<Loan, String> tcLoanDate;

    @FXML
    private TableColumn<Loan, String> tcReferenceNumber;

    @FXML
    private TableColumn<Loan, String> tcState;

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

    }

}
