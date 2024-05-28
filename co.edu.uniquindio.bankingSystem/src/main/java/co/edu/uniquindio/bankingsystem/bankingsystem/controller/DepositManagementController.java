package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.Deposit;

import java.util.List;

public class DepositManagementController {
    ModelFactory modelFactory;

    public DepositManagementController(){
        modelFactory = ModelFactory.getInstance();
    }

    public List<Deposit> getDepositList() {
        return modelFactory.getDepositList();
    }

    public List<Deposit> getEmployeesList() {
        return modelFactory.getDeposit();
    }

    public List<Account> getAccountsList() {
        return modelFactory.getAccountsList();
    }

    public Deposit createDepositProduct() {
        return modelFactory.createDepositProduct();
    }

    public boolean createDeposit(Deposit deposit) {
        return modelFactory.createDeposit(deposit);
    }
}
