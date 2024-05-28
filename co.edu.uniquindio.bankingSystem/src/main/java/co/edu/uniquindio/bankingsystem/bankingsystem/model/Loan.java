package co.edu.uniquindio.bankingsystem.bankingsystem.model;

import co.edu.uniquindio.bankingsystem.bankingsystem.services.ILoanState;
import co.edu.uniquindio.bankingsystem.bankingsystem.stateImplementation.ApprovedState;
import co.edu.uniquindio.bankingsystem.bankingsystem.stateImplementation.DeniedState;

import java.time.LocalDate;

public class Loan {
    private Customer customer;
    private String referenceNumber;
    private LocalDate loanDate;
    private double amount;
    private ILoanState state;

    public Loan(Customer customer, String referenceNumber, LocalDate fechaPrestamo, double amount) {
        this.customer = customer;
        this.referenceNumber = referenceNumber;
        this.loanDate = fechaPrestamo;
        this.amount = amount;
        setState(amount);
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
        setState(amount);
    }

    public String getState() {
        return state.getState();
    }

    private void setState(double amount) {
        if (amount > 2000000) {
            this.state = new DeniedState();
        } else if (amount > 200 && amount <= 2000000) {
            this.state = new ApprovedState();
        } else {
            // Si ninguna de las condiciones anteriores se cumple, establecer el estado como DeniedState por defecto
            this.state = new DeniedState();
        }
    }


    @Override
    public String toString() {
        return "númeroReferenica " + getReferenceNumber();
    }
}
