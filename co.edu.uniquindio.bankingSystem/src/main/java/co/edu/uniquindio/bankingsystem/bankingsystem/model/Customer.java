package co.edu.uniquindio.bankingsystem.bankingsystem.model;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private  String name;
    private  String DNI;
    private  String address;
    private  String email;
    private  String phoneNumber;
    private Account associatedAccount;
    private BankingSystem ownByBankingSystem;
    private LocalDate birthDate;
    private LocalDate registrationDate;

    public Customer(String name, String DNI, String address, String email, String phoneNumber,
                    Account associatedAccount, BankingSystem ownByBankingSystem,
                    LocalDate birthDate, LocalDate registrationDate){
        this.name = name;
        this.DNI = DNI;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.associatedAccount = associatedAccount;
        this.ownByBankingSystem = ownByBankingSystem;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
    }

    public String getName(){
        return name;
    }

    public String getDNI(){
        return DNI;
    }

    public String getAddress(){
        return address;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return  phoneNumber;
    }

    public Account getAssociatedAccount() {
        return associatedAccount;
    }

    public BankingSystem getBankingSystem() {
        return ownByBankingSystem;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public LocalDate getRegistrationDate(){
        return registrationDate;
    }

    public void setAssociatedAccount(Account associatedAccount) {
        this.associatedAccount = associatedAccount;
    }
    @Override
    public String toString() {
        return getDNI();
    }
}
