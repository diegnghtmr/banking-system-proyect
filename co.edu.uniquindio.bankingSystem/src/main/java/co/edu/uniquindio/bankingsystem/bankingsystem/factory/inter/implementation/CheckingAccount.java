package co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;

import java.time.LocalDate;

public class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(){
        super();
        this.overdraftLimit = 1000000.0;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;

    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
