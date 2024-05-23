package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;

import java.time.LocalDate;
import java.util.List;

public class CustomerManagementController {
    ModelFactory modelFactory;

    public CustomerManagementController() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<Customer> getCustomerList() {
        return modelFactory.getCustomerList();
    }

    public boolean removeCustomer(Customer selectedCustomer) {
        return modelFactory.removeCustomer(selectedCustomer);
    }

    public boolean createCustomer(Customer customer) {
        return modelFactory.createCustomer(customer);
    }

    public boolean upDateCustomer(Customer selectedCustomer, Customer customerUpdate) {
        return modelFactory.upDateCustomer(selectedCustomer, customerUpdate);
    }

    public List<Customer> getCustomersOfAge(int age) {
        return modelFactory.getCustomersOfAge(age);
    }

    public List<Customer> getCustomersPostRegistration(LocalDate postRegistrationDate) {
        return modelFactory.getCustomersPostRegistration(postRegistrationDate);
    }
}
