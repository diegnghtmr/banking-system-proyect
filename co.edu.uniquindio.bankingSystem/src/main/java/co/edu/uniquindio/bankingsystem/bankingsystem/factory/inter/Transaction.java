package co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter;

import java.time.LocalDate;

public abstract class Transaction {
    private LocalDate date;
    private double amount;
    private Account account;
    private int referenceNumber;

    public  Transaction (){
        this.date = LocalDate.now();
        this.referenceNumber = (int) (Math.random() * 999999 + 100000);
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account){
        this.account = account;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public int getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(int referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
