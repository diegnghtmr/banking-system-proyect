package co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation;

import co.edu.uniquindio.bankingsystem.bankingsystem.commands.DepositCommand;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Transaction;
import co.edu.uniquindio.bankingsystem.bankingsystem.services.ICommand;

import java.time.LocalDate;

public class Deposit extends Transaction{
    private ICommand depositCommand;
    public Deposit(){
        super();
    }

    public void executeDeposit(Account account, double amount){
        this.depositCommand = new DepositCommand(account, amount);
        this.depositCommand.execute();
        this.setAccount(account);
        this.setAmount(amount);
    }

}

