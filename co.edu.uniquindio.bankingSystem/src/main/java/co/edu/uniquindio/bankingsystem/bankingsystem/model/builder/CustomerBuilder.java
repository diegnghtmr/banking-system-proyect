package co.edu.uniquindio.bankingsystem.bankingsystem.model.builder;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.BankingSystem;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;
import co.edu.uniquindio.bankingsystem.bankingsystem.services.IBuilder;

import java.time.LocalDate;

public class CustomerBuilder implements IBuilder {
    private  String name;
    private  String DNI;
    private  String adress;
    private  String email;
    private  String phoneNumber;
    private Account associatedAccount;
    private BankingSystem ownByBankingSystem;
    private LocalDate birthDate;
    private LocalDate registrationDate;

    public CustomerBuilder setName(String name){
        this.name = name;
        return this;
    }

    public CustomerBuilder setDNI(String DNI){
        this.DNI = DNI;
        return this;
    }

    public CustomerBuilder setAdress(String adress){
        this.adress = adress;
        return this;
    }

    public CustomerBuilder setEmail(String email){
        this.email = email;
        return this;
    }

    public CustomerBuilder setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CustomerBuilder setAssociatedAccount(Account associatedAccount){
        this.associatedAccount = associatedAccount;
        return this;
    }

    public CustomerBuilder setOwnByBankingSystem(BankingSystem ownByBankingSystem){
        this.ownByBankingSystem = ownByBankingSystem;
        return  this;
    }

    public CustomerBuilder setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
        return this;
    }

    public CustomerBuilder setRegistrationDate(LocalDate registrationDate){
        this.registrationDate = registrationDate;
        return this;
    }

    @Override
    public Customer build(){
        return new Customer(name, DNI, adress, email,
                phoneNumber,associatedAccount, ownByBankingSystem,
                birthDate, registrationDate) ;
    }
}