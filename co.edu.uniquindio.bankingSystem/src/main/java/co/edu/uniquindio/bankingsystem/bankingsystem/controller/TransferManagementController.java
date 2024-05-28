package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.Transfer;

import java.util.List;

public class TransferManagementController {
    ModelFactory modelFactory;

    public TransferManagementController(){
        modelFactory = ModelFactory.getInstance();
    }

    public List<Transfer> getTransferList() {
        return modelFactory.getTransferList();
    }

    public List<Account> getAccountsList() {
        return modelFactory.getAccountsList();
    }

    public Account getAccountByAccountNumber(String accountDestination) {
        return modelFactory.getAccountByAccountNumber(accountDestination);
    }

    public Transfer createTransferProduct() {
        return modelFactory.createTransferProduct();
    }

    public boolean createTransfer(Transfer transfer) {
        return modelFactory.createTransfer(transfer);
    }
}
