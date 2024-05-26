package co.edu.uniquindio.bankingsystem.bankingsystem.model;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;

public class AccountAssociation {
    Customer customer;
    Account account;

    public AccountAssociation(Customer customer, Account account) {
        this.customer = customer;
        this.account = account;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
