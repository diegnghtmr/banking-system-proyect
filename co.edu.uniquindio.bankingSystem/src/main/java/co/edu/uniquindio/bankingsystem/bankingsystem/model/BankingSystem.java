package co.edu.uniquindio.bankingsystem.bankingsystem.model;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.TransactionFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.*;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.builder.EmployeeBuilder;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.enums.TypeEmployee;

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
    private List<AccountAssociation> accountAssociationList;
    private List<Loan> loanList;
    private List<Movement> movementList;


    public BankingSystem() {
        this.name = "Byte Bank";
        this.employeeList = new ArrayList<>();
        this.customerList = new ArrayList<>();
        this.checkingAccountList = new ArrayList<>();
        this.savingsAccountList = new ArrayList<>();
        this.depositList = new ArrayList<>();
        this.withdrawalList = new ArrayList<>();
        this.transferList = new ArrayList<>();
        this.accountAssociationList = new ArrayList<>();
        this.loanList = new ArrayList<>();
        this.movementList = new ArrayList<>();
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
    public List<AccountAssociation> getAccountAssociationList() {
        return accountAssociationList;
    }

    public List<Loan> getLoanList() {
        return loanList;
    }

    public List<Movement> getMovementList() {
        return movementList;
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

    public List<Employee> getEmployeesList() {
        return employeeList;

    }

    public boolean createCashier(Employee cashier) {
        Employee employeeFound = getEmployee(cashier.getDNI());

        if (employeeFound == null) {
            addEmployeeList(cashier);
            return true;
        } else {
            return false;
        }
    }

    private Employee getEmployee(String dni) {
        return getEmployeeList().stream()
                        .filter(employee -> employee.getDNI().equalsIgnoreCase(dni))
                        .findFirst()
                        .orElse(null);
    }

    public boolean removeCashier(Employee cashierSelected) {
        if (cashierSelected != null) {
            int index = employeeList.indexOf(cashierSelected);
            if (index != -1) {
                employeeList.remove(index);
                return true;
            }
        }
        return false;
    }

    public boolean upDateCashier(Employee cashierSelected, Employee cashierUpdate) {
        int index = employeeList.indexOf(cashierSelected);
        if (index != -1) {
            employeeList.set(index, cashierUpdate);
            return true;
        }
        return false;

    }

    public Employee validateEmployee(String employee, String password) {
        return employeeList.stream()
                .filter(currentEmployee -> currentEmployee.getDNI().equalsIgnoreCase(employee) && currentEmployee.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public Employee addEmployee(String identification, String name, String email, String address, String password, String phone) {
        Employee employee = new EmployeeBuilder()
                .setDNI(identification)
                .setName(name)
                .setEmail(email)
                .setAddress(address)
                .setPassword(password)
                .setPhone(phone)
                .setTypeEmployee(TypeEmployee.MANAGER)
                .setRegistrationDate(LocalDate.now())
                .build();

        addEmployeeList(employee);
        return employee;
    }


    public boolean createSavingsAccount(SavingsAccount savingsAccount) {
        String savingsAccountFound = searchSavingsAccount(savingsAccount.getAccountNumber());
        if (savingsAccountFound == null){
            savingsAccountList.add(savingsAccount);
            return true;
        }
        return false;
    }

    private String searchSavingsAccount(String accountNumber) {
        for (SavingsAccount savingsAccount : getSavingsAccountList()) {
            if(savingsAccount.getAccountNumber().equalsIgnoreCase(accountNumber)){
                return savingsAccount.toString();
            }
        }
        return null;
    }

    public boolean removeSavingAccount(SavingsAccount selectedSavingsAccount) {
        if (selectedSavingsAccount != null){
            int index = savingsAccountList.indexOf(selectedSavingsAccount);
            if (index != -1) {
                savingsAccountList.remove(index);
                return true;
            }
        }
        return false;

        }

    public boolean updateSavingAccount(SavingsAccount selectedSavingsAccount, SavingsAccount savingsAccountUpdate) {
        int index = savingsAccountList.indexOf(selectedSavingsAccount);
        if (index != -1) {
            savingsAccountList.set(index, savingsAccountUpdate);
            return true;
        }
        return false;
    }

    public boolean createCheckingAccount(CheckingAccount checkingAccount) {
        String chekingAccountSave = searchCheckingAccount(checkingAccount.getAccountNumber());
        if(chekingAccountSave == null ) {
            checkingAccountList.add(checkingAccount);
            return true;
        }
        return false;
    }

    private String searchCheckingAccount(String accountNumber) {
        for (CheckingAccount checkingAccount : getCheckingAccountList()){
            if(checkingAccount.getAccountNumber().equalsIgnoreCase(accountNumber)){
                return checkingAccount.toString();
            }
        }
        return null;
    }

    public boolean updateCheckingAccount(CheckingAccount selectedChekingAccount, CheckingAccount checkingAccountUpdate) {
        int index = checkingAccountList.indexOf(selectedChekingAccount);
        if (index != -1) {
            checkingAccountList.set (index, checkingAccountUpdate);
            return true;

        }
        return false;
    }

    public boolean removeCheckingAccount(CheckingAccount selectedChekingAccount) {
        if (selectedChekingAccount != null) {
            int index = checkingAccountList.indexOf(selectedChekingAccount);
            if (index != -1){
                checkingAccountList.remove(index);
                return true;
            }
        }
        return false;
    }

    public List<Deposit> getDeposit() {
        return depositList;
    }

    public List<Account> getAccountsList() {
        List<Account> accountsList = new ArrayList<>();
        accountsList.addAll(checkingAccountList);
        accountsList.addAll(savingsAccountList);
        return accountsList;
    }

    public Deposit createDepositProduct() {
        TransactionFactory transactionFactory = new TransactionFactory();
        return (Deposit) transactionFactory.getTransaction("DEPOSIT");
    }

    public boolean createDeposit(Deposit deposit) {
        Deposit depositReference = getDepositReference(deposit.getReferenceNumber());

        if (depositReference == null) {
            depositList.add(deposit);
            return true;
        } else {
            deposit.setReferenceNumber(deposit.getReferenceNumber() + 1);
            return createDeposit(deposit); // llamada recursiva
        }
    }

    private Deposit getDepositReference(int referenceNumber) {
        return depositList.stream()
                .filter(deposit -> deposit.getReferenceNumber() == referenceNumber)
                .findFirst()
                .orElse(null);
    }

    public Account getAccountByAccountNumber(String accountDestination) {
        return getAccountsList().stream()
                .filter(account -> account.getAccountNumber().equalsIgnoreCase(accountDestination))
                .findFirst()
                .orElse(null);
    }

    public Transfer createTransferProduct() {
        TransactionFactory transactionFactory = new TransactionFactory();
        return (Transfer) transactionFactory.getTransaction("TRANSFER");
    }

    public boolean createTransfer(Transfer transfer) {
        Account originAccount = transfer.getAccount();
        Account destinationAccount = transfer.getAccountDestination();
        double amount = transfer.getAmount();

        // Validación: la cuenta de origen y destino no pueden ser la misma
        if (originAccount.equals(destinationAccount) || amount == 0) {
            return false;
        }

        Transfer transferReference = getTransferReference(transfer.getReferenceNumber());

        if (transferReference == null) {
            transferList.add(transfer);
            return true;
        } else {
            transfer.setReferenceNumber(transfer.getReferenceNumber() + 1);
            return createTransfer(transfer); // llamada recursiva
        }
    }

    private Transfer getTransferReference(int referenceNumber) {
        return transferList.stream()
                .filter(transfer -> transfer.getReferenceNumber() == referenceNumber)
                .findFirst()
                .orElse(null);
    }

    public Withdrawal createWithdrawalProduct() {
        TransactionFactory transactionFactory = new TransactionFactory();
        return (Withdrawal) transactionFactory.getTransaction("WITHDRAWAL");
    }

    public boolean createWithdrawal(Withdrawal withdrawal) {
        Withdrawal withdrawalReference = getWithdrawalReference(withdrawal.getReferenceNumber());

        if (withdrawalReference == null) {
            withdrawalList.add(withdrawal);
            return true;
        } else {
            withdrawal.setReferenceNumber(withdrawal.getReferenceNumber() + 1);
            return createWithdrawal(withdrawal); // llamada recursiva
        }
    }

    private Withdrawal getWithdrawalReference(int referenceNumber) {
        return withdrawalList.stream()
                .filter(withdrawal -> withdrawal.getReferenceNumber() == referenceNumber)
                .findFirst()
                .orElse(null);
    }


    public List<Customer> getUnassociatedCustomers() {
        List<Customer> unassociatedCustomers = new ArrayList<>();
        for (Customer customer : getCustomerList()) {
            if (!isCustomerAssociated(customer)) {
                unassociatedCustomers.add(customer);
            }
        }
        return unassociatedCustomers;
    }

    private boolean isCustomerAssociated(Customer customer) {
        for (AccountAssociation association : getAccountAssociationList()) {
            if (association.getCustomer().equals(customer)) {
                return true;
            }
        }
        return false;
    }

    public boolean isAccountAssociated(Account account) {
        for (AccountAssociation accountAssociation : getAccountAssociationList()) {
            if (accountAssociation.getAccount().equals(account)) {
                return true;
            }
        }
        return false;
    }

    public List<Account> getUnassociatedAccounts() {
        List<Account> unassociatedAccounts = new ArrayList<>();
        for (SavingsAccount savingsAccount : getSavingsAccountList()) {
            if (!isAccountAssociated(savingsAccount)) {
                unassociatedAccounts.add(savingsAccount);
            }
        }
        for (CheckingAccount checkingAccount : getCheckingAccountList()) {
            if (!isAccountAssociated(checkingAccount)) {
                unassociatedAccounts.add(checkingAccount);
            }
        }
        return unassociatedAccounts;
    }

    public void addAssociation(AccountAssociation newAssociation) {
        getAccountAssociationList().add(newAssociation);
        newAssociation.getCustomer().setAssociatedAccount(newAssociation.getAccount());
    }

    public Customer getCustomerByDni(String dni) {
        for (AccountAssociation association : getAccountAssociationList()) {
            if (association.getCustomer().getDNI().equals(dni)) {
                return association.getCustomer();
            }
        }
        return null;
    }

    public Account getAccountByNumber(String accountNumber) {
        for (AccountAssociation association : getAccountAssociationList()) {
            if (association.getAccount().getAccountNumber().equals(accountNumber)) {
                return association.getAccount();
            }
        }
        return null;
    }

    public boolean removeAssociation(Customer customer, Account account) {
        for (int i = 0; i < getAccountAssociationList().size(); i++) {
            AccountAssociation association = getAccountAssociationList().get(i);
            if (association.getCustomer().getDNI().equals(customer.getDNI()) && association.getAccount().getAccountNumber().equals(account.getAccountNumber())) {
                getAccountAssociationList().remove(i);
                return true;
            }
        }
        return false;
    }


    public List<Customer> getUnassociatedLoans() {
        List<Customer> unassociatedCustomerList = new ArrayList<>();
        for (Customer customer : getCustomerList()) {
            if (!isCustomerAssociatedLoan(customer)) {
                unassociatedCustomerList.add(customer);

            }

        }
        return unassociatedCustomerList;
    }

    private boolean isCustomerAssociatedLoan(Customer customer) {
        for (Loan loan : getLoanList()) {
            if (loan.getCustomer().equals(customer)) {
                return true;
            }

        }
        return false;
    }

    public boolean addLoan(Loan newLoan) {
        if (newLoan != null && !loanExists(newLoan.getReferenceNumber())) {
            loanList.add(newLoan);
            return true;
        }
        return false;
    }

    private boolean loanExists(String referenceNumber) {
        for (Loan loan : loanList) {
            if (loan.getReferenceNumber().equalsIgnoreCase(referenceNumber)) {
                return true;
            }
        }
        return false;
    }
}