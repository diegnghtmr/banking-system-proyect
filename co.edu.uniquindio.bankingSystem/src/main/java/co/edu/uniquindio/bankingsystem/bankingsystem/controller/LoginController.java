package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Employee;

public class LoginController {
    ModelFactory modelFactory;

    public LoginController(){
        modelFactory = ModelFactory.getInstance();
    }

    public Employee validateEmployee(String employee, String password) {
        return modelFactory.validateEmployee(employee, password);
    }
}
