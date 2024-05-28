package co.edu.uniquindio.bankingsystem.bankingsystem.services;

import co.edu.uniquindio.bankingsystem.bankingsystem.model.Employee;

public interface IAuthenticationService {
    Employee validateEmployee(String employee, String password);
    Employee addEmployee(String identification, String name, String email, String address, String password, String phone);
}
