package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Employee;

public class RegisterController {
    ModelFactory modelFactory;

    public RegisterController(){
        modelFactory = ModelFactory.getInstance();
    }

    public Employee addEmployee(String identification, String name, String email, String address, String password, String phone) {
        return modelFactory.addEmployee(identification, name, email, address, password, phone);
    }
}
