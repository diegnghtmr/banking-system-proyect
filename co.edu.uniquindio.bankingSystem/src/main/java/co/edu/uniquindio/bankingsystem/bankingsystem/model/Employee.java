package co.edu.uniquindio.bankingsystem.bankingsystem.model;

import co.edu.uniquindio.bankingsystem.bankingsystem.model.enums.TypeEmployee;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.time.LocalDate;

public class Employee {
    private String name;
    private TypeEmployee typeEmployee;
    private String email;
    private String address;
    private String DNI;
    private String phone;
    private String password;
    private LocalDate registrationDate;
    private BankingSystem ownByBankingSystem;

    public Employee(String name, TypeEmployee typeEmployee, BankingSystem ownByBankingSystem, String email, String address, String phone, String password, String DNI, LocalDate registrationDate) {
        this.name = name;
        this.typeEmployee = typeEmployee;
        this.email = email;
        this.address = address;
        this.DNI = DNI;
        this.phone = phone;
        this.password = password;
        this.ownByBankingSystem = ownByBankingSystem;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public TypeEmployee getTypeEmployee() {
        return typeEmployee;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDNI() {
        return DNI;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public BankingSystem getOwnByBankingSystem() {
        return ownByBankingSystem;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

}