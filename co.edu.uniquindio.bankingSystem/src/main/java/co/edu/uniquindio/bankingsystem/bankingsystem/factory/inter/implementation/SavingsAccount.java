package co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;

import java.time.LocalDate;

public class SavingsAccount extends Account {
    private double interestRate;
    public SavingsAccount(){
        super();
        this.interestRate = 0.1325;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
