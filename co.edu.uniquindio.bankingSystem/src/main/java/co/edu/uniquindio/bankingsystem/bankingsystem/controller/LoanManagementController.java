package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.dto.LoanDto;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Loan;

import java.util.List;

public class LoanManagementController {
    ModelFactory modelFactory;

    public LoanManagementController() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<LoanDto> getLoanList() {
        return modelFactory.getLoanList();
    }

    public List<Customer> getUnassociatedLoans() {
        return modelFactory.getUnassociatedLoans();
    }

    public boolean addLoan(Loan newLoan) {
        return modelFactory.addLoan(newLoan);
    }
}

