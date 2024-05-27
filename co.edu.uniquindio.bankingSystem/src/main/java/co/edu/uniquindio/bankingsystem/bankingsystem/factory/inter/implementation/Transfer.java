package co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Transaction;

import java.time.LocalDate;

public class Transfer extends Transaction {
    private final double comission;
    private Account accountDestination;

    public Transfer(){
        super();
        this.comission = 500;
    }

    public double getComission() {
        return comission;
    }

    public Account getAccountDestination() {
        return accountDestination;
    }

    public void setAccountDestination(Account accountDestination) {
        this.accountDestination = accountDestination;
    }
}