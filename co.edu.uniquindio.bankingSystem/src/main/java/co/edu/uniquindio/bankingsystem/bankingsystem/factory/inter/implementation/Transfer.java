package co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation;

import co.edu.uniquindio.bankingsystem.bankingsystem.commands.TransferCommand;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Transaction;
import co.edu.uniquindio.bankingsystem.bankingsystem.services.ICommand;

public class Transfer extends Transaction {
    private final double commission;
    private Account accountDestination;
    private ICommand transferCommand;

    public Transfer(){
        super();
        this.commission = 100;
    }

    public double getCommission() {
        return commission;
    }

    public Account getAccountDestination() {
        return accountDestination;
    }

    public void setAccountDestination(Account accountDestination) {
        this.accountDestination = accountDestination;
    }

    public void executeTransfer(Account originAccount,
                                Account destinationAccount, double amount) {
        this.transferCommand = new TransferCommand(originAccount,
                destinationAccount, amount, this.commission);
        this.transferCommand.execute();
        this.setAccount(originAccount);
        this.setAmount(amount - this.commission);
        this.setAccountDestination(destinationAccount);
    }

}