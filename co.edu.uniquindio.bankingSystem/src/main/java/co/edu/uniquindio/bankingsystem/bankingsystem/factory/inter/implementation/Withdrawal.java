package co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation;

import co.edu.uniquindio.bankingsystem.bankingsystem.commands.WithdrawalCommand;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Transaction;
import co.edu.uniquindio.bankingsystem.bankingsystem.services.ICommand;

import java.time.LocalDate;

public class Withdrawal extends Transaction {
    private double withdrawalLimit;
    private double commission;
    private ICommand withdrawalCommand;

    public Withdrawal() {
        super();
        this.withdrawalLimit = 80000;
        this.commission = 150;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public double getCommission() {
        return commission;
    }

    public void executeWithdrawal(Account account, double amount) {
        this.withdrawalCommand = new WithdrawalCommand(account, amount, this.commission);
        this.withdrawalCommand.execute();
        this.setAccount(account);
        this.setAmount(amount - this.commission);
    }
}
