package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.Withdrawal;
import javafx.beans.Observable;
import javafx.util.Callback;

import java.util.List;

public class WithdrawalManagementController {
    ModelFactory modelFactory;

    public WithdrawalManagementController(){
        modelFactory = ModelFactory.getInstance();
    }

    public List<Withdrawal> getWithdrawalList() {
        return modelFactory.getWithdrawalList();
    }

    public List<Account> getAccountsList() {
        return modelFactory.getAccountsList();
    }

    public Withdrawal createWithdrawalProduct() {
        return modelFactory.createWithdrawalProduct();
    }

    public boolean createWithdrawal(Withdrawal withdrawal) {
        return modelFactory.createWithdrawal(withdrawal);
    }
}
