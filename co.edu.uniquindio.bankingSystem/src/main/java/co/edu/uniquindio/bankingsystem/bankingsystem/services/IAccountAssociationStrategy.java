package co.edu.uniquindio.bankingsystem.bankingsystem.services;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;

public interface IAccountAssociationStrategy {
    void associateAccount(Customer customer, Account account);
}
