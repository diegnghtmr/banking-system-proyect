package co.edu.uniquindio.bankingsystem.bankingsystem.commands;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.services.ICommand;

public class TransferCommand implements ICommand {
    private Account originAccount;
    private Account destinationAccount;
    private double amount;
    private double comission;

    public TransferCommand(Account originAccount, Account destinationAccount, double amount, double comission) {
        this.originAccount = originAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.comission = comission;
    }

    @Override
    public void execute() {
        originAccount.setBalance(originAccount.getBalance() - amount);
        double totalAmount = amount - this.comission;
        destinationAccount.setBalance(destinationAccount.getBalance() + totalAmount);
    }
}
