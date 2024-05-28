package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Transaction;

import java.time.LocalDate;
import java.util.List;

public class MovementManagementController {
    ModelFactory modelFactory;

    public MovementManagementController(){
        modelFactory = ModelFactory.getInstance();
    }

    public List<Transaction> getTransactionList() {
        return modelFactory.getTransactionList();
    }

    public List<Account> getAccountsList() {
        return modelFactory.getAccountsList();
    }

    public List<Transaction> getPreviousRecords(LocalDate date, Account account) {
        return modelFactory.getPreviousRecords(date, account);
    }

    public Transaction lookByAccount(Account account) {
        return modelFactory.lookByAccount(account);
    }
}
