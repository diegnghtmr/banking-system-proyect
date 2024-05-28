package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.SavingsAccount;

import java.util.List;

public class SavingsAccountManagementController {
    ModelFactory modelFactory;

    public SavingsAccountManagementController(){
        modelFactory = ModelFactory.getInstance();
    }

    public List<SavingsAccount> getSavingAccountList() {
        return modelFactory.getSavingAccountList();
    }

    public boolean createSavingsAccount(SavingsAccount savingsAccount) {
        return modelFactory.createSavingsAccount(savingsAccount);
    }

    public boolean removeSavingAccount(SavingsAccount selectedSavingsAccount) {
        return modelFactory.removeSavingAccount(selectedSavingsAccount);
    }

    public boolean updateSavingAccount(SavingsAccount selectedSavingsAccount, SavingsAccount savingsAccountUpdate) {
        return modelFactory.updateSavingAccount(selectedSavingsAccount, savingsAccountUpdate);
    }
}
