package co.edu.uniquindio.bankingsystem.bankingsystem.commands;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.services.ICommand;

public class WithdrawalCommand implements ICommand {
    private Account account;
    private double amount;
    private double commission;

    public WithdrawalCommand(Account account, double amount, double commission) {
        this.account = account;
        this.amount = amount;
        this.commission = commission;
    }

    @Override
    public void execute() {
        double totalAmount = amount + this.commission;
        account.setBalance(account.getBalance() - totalAmount);
    }
}