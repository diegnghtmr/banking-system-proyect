package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.CheckingAccount;

import java.util.List;

public class CheckingAccountManagementController {

    ModelFactory modelFactory;

    public CheckingAccountManagementController() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<CheckingAccount> getCheckingAccountList() {
        return modelFactory.getCheckingAccountList();

    }

    public boolean createCheckingAccount(CheckingAccount checkingAccount) {
        return modelFactory.createCheckingAccount(checkingAccount);
    }

    public boolean updateCheckingAccount(CheckingAccount selectedChekingAccount, CheckingAccount checkingAccountUpdate) {
        return modelFactory.updateCheckingAccount(selectedChekingAccount, checkingAccountUpdate);
    }

    public boolean removeCheckingAccount(CheckingAccount selectedChekingAccount) {
        return modelFactory.removeCheckingAccount(selectedChekingAccount);
    }
}
