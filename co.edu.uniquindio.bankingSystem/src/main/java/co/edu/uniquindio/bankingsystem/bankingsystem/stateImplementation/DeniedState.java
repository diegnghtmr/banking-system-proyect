package co.edu.uniquindio.bankingsystem.bankingsystem.stateImplementation;

import co.edu.uniquindio.bankingsystem.bankingsystem.services.ILoanState;

public class DeniedState implements ILoanState {
    @Override
    public String getState() {
        return "Denegado";
    }
}