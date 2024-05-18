package co.edu.uniquindio.bankingsystem.bankingsystem.model.builder;

import co.edu.uniquindio.bankingsystem.bankingsystem.model.BankingSystem;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Employee;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.enums.TypeEmployee;
import co.edu.uniquindio.bankingsystem.bankingsystem.services.IBuilder;

import java.time.LocalDate;

public class EmployeeBuilder implements IBuilder {

    private String name;
    private TypeEmployee typeEmployee;
    private String email;
    private String address;
    private String DNI;
    private String phone;
    private String password;
    private LocalDate registrationDate;
    private BankingSystem ownByBankingSystem;

    public EmployeeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public EmployeeBuilder setTypeEmployee(TypeEmployee typeEmployee) {
        this.typeEmployee = typeEmployee;
        return this;
    }

    public EmployeeBuilder setEmail(String email){
        this.email = email;
        return this;
    }

    public EmployeeBuilder setAddress(String address){
        this.address = address;
        return this;
    }

    public EmployeeBuilder setDNI(String DNI){
        this.DNI = DNI;
        return this;
    }

    public EmployeeBuilder setPhone(String phone){
        this.phone = phone;
        return this;
    }

    public EmployeeBuilder setPassword(String password){
        this.password = password;
        return this;
    }

    public EmployeeBuilder setRegistrationDate(LocalDate registrationDate){
        this.registrationDate = registrationDate;
        return this;
    }

    public EmployeeBuilder setOwnByBankingSystem(BankingSystem ownByBankingSystem) {
        this.ownByBankingSystem = ownByBankingSystem;
        return this;
    }

    @Override
    public Employee build() {
        return new Employee(name, typeEmployee, ownByBankingSystem, email, address, phone, password, DNI, registrationDate);
    }
}
