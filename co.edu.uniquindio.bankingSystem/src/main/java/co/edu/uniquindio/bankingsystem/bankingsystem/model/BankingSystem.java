package co.edu.uniquindio.bankingsystem.bankingsystem.model;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankingSystem {
    private final String name;
    private List<Employee> employeeList;
    private List<Customer> customerList;
    private List<CheckingAccount> checkingAccountList;
    private List<SavingsAccount> savingsAccountList;
    private List<Deposit> depositList;
    private List<Withdrawal> withdrawalList;
    private List<Transfer> transferList;
    private List<Account> accountList;


    public BankingSystem() {
        this.name = "Bite Bank";
        this.employeeList = new ArrayList<>();
        this.customerList = new ArrayList<>();
        this.checkingAccountList = new ArrayList<>();
        this.savingsAccountList = new ArrayList<>();
        this.depositList = new ArrayList<>();
        this.withdrawalList = new ArrayList<>();
        this.transferList = new ArrayList<>();
        this.accountList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }


    public List<CheckingAccount> getCheckingAccountList() {
        return checkingAccountList;
    }

    public List<SavingsAccount> getSavingsAccountList() {
        return savingsAccountList;
    }

    public List<Deposit> getDepositList() {
        return depositList;
    }

    public List<Withdrawal> getWithdrawalList() {
        return withdrawalList;
    }

    public List<Transfer> getTransferList() {
        return transferList;
    }
    public List<Account> getAccountList() {
        return accountList;
    }


    public void addEmployeeList(Employee employee) {
        employeeList.add(employee);
    }

    public void addCustomerList(Customer customer) {
        customerList.add(customer);
    }

    public void addCheckingAccountList(CheckingAccount checkingAccount) {
        checkingAccountList.add(checkingAccount);
    }

    public void addSavingsAccountList(SavingsAccount savingsAccount) {
        savingsAccountList.add(savingsAccount);
    }

    public void addDepositList(Deposit deposit) {
        depositList.add(deposit);
    }

    public void addWithdrawalList(Withdrawal withdrawal) {
        withdrawalList.add(withdrawal);
    }

    public void addTransferList(Transfer transfer) {
        transferList.add(transfer);
    }

    public void removeEmployeeList(Employee employee) {
        employeeList.remove(employee);
    }

    public void removeCustomerList(Customer customer) {
        customerList.remove(customer);
    }

    public void removeCheckingAccountList(CheckingAccount checkingAccount) {
        checkingAccountList.remove(checkingAccount);
    }

    public void removeSavingsAccountList(SavingsAccount savingsAccount) {
        savingsAccountList.remove(savingsAccount);
    }

    public void removeDepositList(Deposit deposit) {
        depositList.remove(deposit);
    }

    public void removeWithdrawalList(Withdrawal withdrawal) {
        withdrawalList.remove(withdrawal);
    }

    public void removeTransferList(Transfer transfer) {
        transferList.remove(transfer);
    }

    public boolean removeCustomer(Customer selectedCustomer) {
        if (selectedCustomer != null) {
            int index = customerList.indexOf(selectedCustomer);
            if (index != -1) {
                customerList.remove(index);
                return true;
            }
        }
        return false;

    }

    public boolean createCustomer(Customer newCustomer) {
        Customer customerFound = getCustomer(newCustomer.getDNI());

        if (customerFound == null) {
            addCustomerList(newCustomer);
            return true;
        } else {
            return false;
        }
    }

    private Customer getCustomer(String DNI) {
        return getCustomerList().stream()
                .filter(customer -> customer.getDNI().equalsIgnoreCase(DNI))
                .findFirst()
                .orElse(null);
    }


    public boolean updateCustomer(Customer selectedCustomer, Customer customerUpdate) {
        int index = customerList.indexOf(selectedCustomer);
        if (index != -1) {
            customerList.set(index, customerUpdate);
            return true;
        }
        return false;
    }

    public List<Customer> getCustomersOfAge(int age) {
        return customerList.stream()
                .filter(customer -> Period.between(customer.getBirthDate(), LocalDate.now()).getYears() == age)
                .collect(Collectors.toList());
    }

    public List<Customer> getCustomersPostRegistration(LocalDate postRegistrationDate) {
        return customerList.stream()
                .filter(customer -> customer.getRegistrationDate().isAfter(postRegistrationDate))
                .collect(Collectors.toList());
    }


    public boolean createCheckingAccount(CheckingAccount checkingAccount) {
        CheckingAccount checkingAccountFound = searchAccount(checkingAccount.getAccountNumber());

        if(checkingAccountFound==null){
            checkingAccountList.add(checkingAccount);
            return true;
        }
        return false;
    }

    private CheckingAccount searchAccount(String accountNumber) {
        for(CheckingAccount checkingAccount: checkingAccountList){
            if(checkingAccount.getAccountNumber().equalsIgnoreCase(accountNumber)){
                return checkingAccount;
            }
        }
        return null;
    }

}