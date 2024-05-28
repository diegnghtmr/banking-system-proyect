package co.edu.uniquindio.bankingsystem.bankingsystem.commands;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.services.ICommand;

public class DepositCommand implements ICommand {
    private Account account;
    private double amount;

    public DepositCommand(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.setBalance(account.getBalance() + amount);
    }
}