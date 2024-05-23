package co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter;

import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;

import java.time.LocalDate;
import java.util.*;

public abstract class Account {
    private String accountNumber;
    private double balance;
    private int securityNumber;
    private LocalDate openingDate;
    private Customer customer;
    private List<Transaction> transactionList;

    public Account(){
        this.accountNumber = Integer.toString((int) (Math.random() * 90000000 + 10000000));
        this.balance = 0;
        this.securityNumber = (int) (Math.random() * 99999 + 10000);;
        this.openingDate = LocalDate.now();
        this.transactionList = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getSecurityNumber() {
        return securityNumber;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public Customer getCustomer(){
        return customer;
    }

   public List<Transaction> getTransactionList(){
        return transactionList;
   }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setSecurityNumber(int securityNumber) {
        this.securityNumber = securityNumber;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}