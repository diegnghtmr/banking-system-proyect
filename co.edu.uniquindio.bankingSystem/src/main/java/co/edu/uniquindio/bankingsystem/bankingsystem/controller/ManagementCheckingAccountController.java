package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.CheckingAccount;

import java.util.List;

public class ManagementCheckingAccountController {
    ModelFactory modelFactory;

    public ManagementCheckingAccountController(){
        modelFactory = ModelFactory.getInstance();
    }



    public List<CheckingAccount> getCheckingAccountList() {
       return modelFactory.getCheckingAccountList();
    }

    public boolean createCheckingAccount(CheckingAccount checkingAccount) {
        return modelFactory.createCheckingAccount(checkingAccount);
    }
}
