package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Employee;

import java.util.List;

public class CashierManagementController {
    ModelFactory modelFactory;

    public CashierManagementController(){
        modelFactory = ModelFactory.getInstance();
    }

    public List<Employee> getEmployeesList() {
        return modelFactory.getEmployeesList();
    }

    public boolean createCashier(Employee cashier) {
        return modelFactory.createCashier(cashier);
    }

    public boolean removeCashier(Employee cashierSelected) {
        return  modelFactory.removeCashier(cashierSelected);
    }

    public boolean upDateCashier(Employee cashierSelected, Employee cashierUpdate) {
        return modelFactory.upDateCashier(cashierSelected, cashierUpdate);
    }
}
