package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.dto.AccountAssociationDto;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.AccountAssociation;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;

import java.util.List;

public class AccountAssociationManagementController {
    ModelFactory modelFactory;

    public  AccountAssociationManagementController() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<AccountAssociationDto> getAccountAssociationList() {
        return modelFactory.getAccountAssociationList();

    }

    public List<Customer> getUnassociatedCustomers() {
        return modelFactory.getUnassociatedCustomers();
    }

    public List<Account> getUnassociatedAccounts() {
        return modelFactory.getUnassociatedAccounts();
    }


    public void addAssociation(AccountAssociation newAssociation) {
        modelFactory.addAssociation(newAssociation);
    }


    public Customer getCustomerByDni(String dni) {
        return modelFactory.getCustomerByDni(dni);
    }

    public Account getAccountByNumber(String accountNumber) {
        return modelFactory.getAccountByNumber(accountNumber);
    }

    public boolean removeAssociation(Customer customer, Account account) {
        return modelFactory.removeAssociation(customer, account);
    }
}
