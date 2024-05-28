package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.model.Employee;
import co.edu.uniquindio.bankingsystem.bankingsystem.services.IAuthenticationService;

public class AuthenticationProxy implements IAuthenticationService {
    private IAuthenticationService loginController;
    private IAuthenticationService registerController;

    public AuthenticationProxy() {
        this.loginController = new LoginController();
        this.registerController = new RegisterController();
    }

    @Override
    public Employee validateEmployee(String employee, String password) {
        return loginController.validateEmployee(employee, password);
    }

    @Override
    public Employee addEmployee(String identification, String name, String email, String address, String password, String phone) {
        return registerController.addEmployee(identification, name, email, address, password, phone);
    }
}