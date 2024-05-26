package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.dto.AccountAssociationDto;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;

import java.util.List;

public class AccountAssociationManagementController {
    ModelFactory modelFactory;

    public  AccountAssociationManagementController() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<AccountAssociationDto> getAccountAssociationList() {
        return modelFactory.getAccountAssociationList();

    }
}
