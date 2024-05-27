package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.dto.LoanDto;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;

import java.util.List;

public class LoanManagementController {
    ModelFactory modelFactory;

    public LoanManagementController() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<LoanDto> getLoanList() {
        return modelFactory.getLoanList();
    }
}
