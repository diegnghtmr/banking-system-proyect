package co.edu.uniquindio.bankingsystem.bankingsystem.model;

import co.edu.uniquindio.bankingsystem.bankingsystem.services.IMovementState;
import co.edu.uniquindio.bankingsystem.bankingsystem.stateImplementation.ApprovedState;
import co.edu.uniquindio.bankingsystem.bankingsystem.stateImplementation.DeniedState;

import java.time.LocalDate;

public class Movement{
    private Transaction transaction;
    private IMovementState state;

    public Movement(Transaction transaction, String referenceNumber){
        this.transaction = transaction;
        this.referenceNumber = referenceNumber;
        setState(amount);
    }

    public Transaction getTransaction(){
        return transaction;
    }

    public void setTransaction(){
        this.transaction = transaction;
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
}