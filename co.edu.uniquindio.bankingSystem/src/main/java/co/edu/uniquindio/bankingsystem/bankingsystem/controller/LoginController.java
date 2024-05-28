package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Employee;
import co.edu.uniquindio.bankingsystem.bankingsystem.services.IAuthenticationService;

public class LoginController implements IAuthenticationService {
    ModelFactory modelFactory;

    public LoginController(){
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public Employee validateEmployee(String employee, String password) {
        return modelFactory.validateEmployee(employee, password);
    }

    @Override
    public Employee addEmployee(String identification, String name, String email, String address, String password, String phone) {
        throw new UnsupportedOperationException();
    }

}
