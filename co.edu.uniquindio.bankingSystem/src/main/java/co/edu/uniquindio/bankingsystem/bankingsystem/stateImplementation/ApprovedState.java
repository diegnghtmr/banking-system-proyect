package co.edu.uniquindio.bankingsystem.bankingsystem.stateImplementation;

import co.edu.uniquindio.bankingsystem.bankingsystem.services.ILoanState;

public class ApprovedState implements ILoanState {
    @Override
    public String getState() {
        return "Aprobado";
    }
}