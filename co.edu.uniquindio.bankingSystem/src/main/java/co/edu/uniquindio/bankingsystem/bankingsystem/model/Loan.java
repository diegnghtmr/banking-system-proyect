package co.edu.uniquindio.bankingsystem.bankingsystem.model;

import java.time.LocalDate;

public class Loan {
    private Customer customer;
    private String referenceNumber;
    private LocalDate loanDate;
    private double amount;

    public Loan(Customer customer, String referenceNumber, LocalDate fechaPrestamo, double monto) {
        this.customer = customer;
        this.referenceNumber = referenceNumber;
        this.loanDate = fechaPrestamo;
        this.amount = monto;
    }

    public Loan() {

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "númeroReferenica "+getReferenceNumber();
    }
}
