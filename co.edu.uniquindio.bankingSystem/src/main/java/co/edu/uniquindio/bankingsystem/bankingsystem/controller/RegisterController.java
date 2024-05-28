package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Employee;
import co.edu.uniquindio.bankingsystem.bankingsystem.services.IAuthenticationService;

public class RegisterController implements IAuthenticationService {
    ModelFactory modelFactory;

    public RegisterController(){
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public Employee addEmployee(String identification, String name, String email, String address, String password, String phone) {
        return modelFactory.addEmployee(identification, name, email, address, password, phone);
    }

    @Override
    public Employee validateEmployee(String employee, String password) {
        throw new UnsupportedOperationException();
    }
}
