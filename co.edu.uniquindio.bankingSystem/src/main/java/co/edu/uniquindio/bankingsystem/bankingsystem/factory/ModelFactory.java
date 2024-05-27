package co.edu.uniquindio.bankingsystem.bankingsystem.factory;

import co.edu.uniquindio.bankingsystem.bankingsystem.dto.AccountAssociationDto;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Transaction;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.CheckingAccount;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.Deposit;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.SavingsAccount;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.Withdrawal;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.AccountAssociation;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.BankingSystem;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Employee;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.builder.CustomerBuilder;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.builder.EmployeeBuilder;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.enums.TypeEmployee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ModelFactory {
    private static ModelFactory modelFactory;
    private BankingSystem bankingSystem;

    private ModelFactory() {
        bankingSystem = new BankingSystem();
        initializeData();
    }

    public static ModelFactory getInstance() {
        if (modelFactory == null) {
            modelFactory = new ModelFactory();
        }
        return modelFactory;
    }

    private void initializeData() {
        initCustomer();
        initEmployee();
        initAccountAssociation();
    }




    private void initCustomer() {
        AccountFactory accountFactory = new AccountFactory();
        TransactionFactory transactionFactory = new TransactionFactory();

        Account account1 = accountFactory.getAccount("SAVINGS");
        Account account2 = accountFactory.getAccount("CHECKING");
        Account account3 = accountFactory.getAccount("SAVINGS");
        Account account4 = accountFactory.getAccount("CHECKING");
        Account account5 = accountFactory.getAccount("SAVINGS");
        Account account6 = accountFactory.getAccount("CHECKING");
        Account account7 = accountFactory.getAccount("SAVINGS");
        Account account8 = accountFactory.getAccount("CHECKING");
        Account account9 = accountFactory.getAccount("SAVINGS");
        Account account10 = accountFactory.getAccount("CHECKING");
        Account account11 = accountFactory.getAccount("SAVINGS");
        Account account12 = accountFactory.getAccount("CHECKING");
        Account account13 = accountFactory.getAccount("SAVINGS");
        Account account14 = accountFactory.getAccount("CHECKING");


        Transaction transaction1 = transactionFactory.getTransaction("DEPOSIT");
        Transaction transaction2 = transactionFactory.getTransaction("WITHDRAWAL");
        Transaction transaction3 = transactionFactory.getTransaction("DEPOSIT");
        Transaction transaction4 = transactionFactory.getTransaction("WITHDRAWAL");
        Transaction transaction5 = transactionFactory.getTransaction("DEPOSIT");
        Transaction transaction6 = transactionFactory.getTransaction("WITHDRAWAL");
        Transaction transaction7 = transactionFactory.getTransaction("DEPOSIT");
        Transaction transaction8 = transactionFactory.getTransaction("DEPOSIT");
        Transaction transaction9 = transactionFactory.getTransaction("WITHDRAWAL");
        Transaction transaction10 = transactionFactory.getTransaction("DEPOSIT");
        Transaction transaction11 = transactionFactory.getTransaction("WITHDRAWAL");


        account1.getTransactionList().add(transaction1);
        account2.getTransactionList().add(transaction2);
        account3.getTransactionList().add(transaction3);
        account4.getTransactionList().add(transaction4);
        account5.getTransactionList().add(transaction5);
        account6.getTransactionList().add(transaction6);
        account7.getTransactionList().add(transaction7);
        account8.getTransactionList().add(transaction8);
        account9.getTransactionList().add(transaction9);
        account10.getTransactionList().add(transaction10);
        account11.getTransactionList().add(transaction11);

        Customer customer1 = new CustomerBuilder()
                .setName("John Doe")
                .setDNI("123456789")
                .setAdress("123 Main St")
                .setEmail("johndoe@example.com")
                .setPhoneNumber("123-456-7890")
                .setAssociatedAccount(account1)
                .setOwnByBankingSystem(bankingSystem)
                .setBirthDate(LocalDate.of(1990, 1, 1))
                .setRegistrationDate(LocalDate.now().minusMonths(3))
                .build();

        Customer customer2 = new CustomerBuilder()
                .setName("Jane Doe")
                .setDNI("987654321")
                .setAdress("456 Elm St")
                .setEmail("janedoe@example.com")
                .setPhoneNumber("098-765-4321")
                .setAssociatedAccount(account2)
                .setOwnByBankingSystem(bankingSystem)
                .setBirthDate(LocalDate.of(1995, 10, 7))
                .setRegistrationDate(LocalDate.now().minusMonths(10))
                .build();

        Customer customer3 = new CustomerBuilder()
                .setName("Alice Smith")
                .setDNI("111222333")
                .setAdress("789 Oak St")
                .setEmail("alicesmith@example.com")
                .setPhoneNumber("111-222-3333")
                .setAssociatedAccount(account3)
                .setOwnByBankingSystem(bankingSystem)
                .setBirthDate(LocalDate.of(1985, 5, 15))
                .setRegistrationDate(LocalDate.now().minusYears(5))
                .build();

        Customer customer4 = new CustomerBuilder()
                .setName("Bob Johnson")
                .setDNI("444555666")
                .setAdress("321 Pine St")
                .setEmail("bobjohnson@example.com")
                .setPhoneNumber("444-555-6666")
                .setAssociatedAccount(account4)
                .setOwnByBankingSystem(bankingSystem)
                .setBirthDate(LocalDate.of(1990, 6, 20))
                .setRegistrationDate(LocalDate.now().minusYears(10))
                .build();

        Customer customer5 = new CustomerBuilder()
                .setName("Charlie Brown")
                .setDNI("777888999")
                .setAdress("654 Maple St")
                .setEmail("charliebrown@example.com")
                .setPhoneNumber("777-888-9999")
                .setAssociatedAccount(account5)
                .setOwnByBankingSystem(bankingSystem)
                .setBirthDate(LocalDate.of(1980, 7, 25))
                .setRegistrationDate(LocalDate.now().minusMonths(3))
                .build();

        Customer customer6 = new CustomerBuilder()
                .setName("Diana Ross")
                .setDNI("000111222")
                .setAdress("987 Cedar St")
                .setEmail("dianaross@example.com")
                .setPhoneNumber("000-111-2222")
                .setAssociatedAccount(account6)
                .setOwnByBankingSystem(bankingSystem)
                .setBirthDate(LocalDate.of(1975, 8, 30))
                .setRegistrationDate(LocalDate.now().minusMonths(4))
                .build();

        Customer customer7 = new CustomerBuilder()
                .setName("Edward Norton")
                .setDNI("333444555")
                .setAdress("123 Birch St")
                .setEmail("edwardnorton@example.com")
                .setPhoneNumber("333-444-5555")
                .setAssociatedAccount(account7)
                .setOwnByBankingSystem(bankingSystem)
                .setBirthDate(LocalDate.of(1970, 9, 5))
                .setRegistrationDate(LocalDate.now().minusYears(7))
                .build();

        Customer customer8 = new CustomerBuilder()
                .setName("Eva Green")
                .setDNI("888999000")
                .setAdress("789 Maple St")
                .setEmail("evagreen@example.com")
                .setPhoneNumber("888-999-0000")
                .setAssociatedAccount(account8)
                .setOwnByBankingSystem(bankingSystem)
                .setBirthDate(LocalDate.of(1987, 9, 12))
                .setRegistrationDate(LocalDate.now().minusYears(2))
                .build();

        Customer customer9 = new CustomerBuilder()
                .setName("Frank Smith")
                .setDNI("999000111")
                .setAdress("987 Pine St")
                .setEmail("franksmith@example.com")
                .setPhoneNumber("999-000-1111")
                .setAssociatedAccount(account9)
                .setOwnByBankingSystem(bankingSystem)
                .setBirthDate(LocalDate.of(1995, 3, 25))
                .setRegistrationDate(LocalDate.now().minusMonths(6))
                .build();

        Customer customer10 = new CustomerBuilder()
                .setName("José Martínez")
                .setDNI("999000112")
                .setAdress("123 Avenida Central")
                .setEmail("jose.martinez@example.com")
                .setPhoneNumber("999-000-1122")
                .setAssociatedAccount(account10)
                .setOwnByBankingSystem(bankingSystem)
                .setBirthDate(LocalDate.of(1987, 5, 17))
                .setRegistrationDate(LocalDate.now().minusMonths(5))
                .build();

        Customer customer11 = new CustomerBuilder()
                .setName("María López")
                .setDNI("999000113")
                .setAdress("456 Calle de la Rosa")
                .setEmail("maria.lopez@example.com")
                .setPhoneNumber("999-000-1133")
                .setAssociatedAccount(account11)
                .setOwnByBankingSystem(bankingSystem)
                .setBirthDate(LocalDate.of(1990, 7, 23))
                .setRegistrationDate(LocalDate.now().minusMonths(7))
                .build();

        Customer customer12 = new CustomerBuilder()
                .setName("Carlos García")
                .setDNI("999000114")
                .setAdress("789 Plaza Mayor")
                .setEmail("carlos.garcia@example.com")
                .setPhoneNumber("999-000-1144")
                .setAssociatedAccount(account12)
                .setOwnByBankingSystem(bankingSystem)
                .setBirthDate(LocalDate.of(1985, 9, 30))
                .setRegistrationDate(LocalDate.now().minusMonths(3))
                .build();

        Customer customer13 = new CustomerBuilder()
                .setName("Ana Fernández")
                .setDNI("999000115")
                .setAdress("321 Camino Real")
                .setEmail("ana.fernandez@example.com")
                .setPhoneNumber("999-000-1155")
                .setAssociatedAccount(account13)
                .setOwnByBankingSystem(bankingSystem)
                .setBirthDate(LocalDate.of(1992, 11, 12))
                .setRegistrationDate(LocalDate.now().minusMonths(9))
                .build();

        Customer customer14 = new CustomerBuilder()
                .setName("Luis Rodríguez")
                .setDNI("999000116")
                .setAdress("654 Avenida del Sol")
                .setEmail("luis.rodriguez@example.com")
                .setPhoneNumber("999-000-1166")
                .setAssociatedAccount(account14)
                .setOwnByBankingSystem(bankingSystem)
                .setBirthDate(LocalDate.of(1980, 1, 5))
                .setRegistrationDate(LocalDate.now().minusMonths(2))
                .build();


        bankingSystem.addSavingsAccountList((SavingsAccount) account1);
        bankingSystem.addCheckingAccountList((CheckingAccount) account2);
        bankingSystem.addSavingsAccountList((SavingsAccount) account3);
        bankingSystem.addCheckingAccountList((CheckingAccount) account4);
        bankingSystem.addSavingsAccountList((SavingsAccount) account5);
        bankingSystem.addCheckingAccountList((CheckingAccount) account6);
        bankingSystem.addSavingsAccountList((SavingsAccount) account7);
        bankingSystem.addCheckingAccountList((CheckingAccount) account8);
        bankingSystem.addSavingsAccountList((SavingsAccount) account9);
        bankingSystem.addCheckingAccountList((CheckingAccount)account10);
        bankingSystem.addSavingsAccountList((SavingsAccount) account11);
        bankingSystem.addCheckingAccountList((CheckingAccount)account12);
        bankingSystem.addSavingsAccountList((SavingsAccount) account13);
        bankingSystem.addCheckingAccountList((CheckingAccount)account14);
        bankingSystem.addDepositList((Deposit) transaction1);
        bankingSystem.addWithdrawalList((Withdrawal) transaction2);
        bankingSystem.addDepositList((Deposit) transaction3);
        bankingSystem.addWithdrawalList((Withdrawal) transaction4);
        bankingSystem.addDepositList((Deposit) transaction5);
        bankingSystem.addWithdrawalList((Withdrawal) transaction6);
        bankingSystem.addDepositList((Deposit) transaction7);
        bankingSystem.addCustomerList(customer1);
        bankingSystem.addCustomerList(customer2);
        bankingSystem.addCustomerList(customer3);
        bankingSystem.addCustomerList(customer4);
        bankingSystem.addCustomerList(customer5);
        bankingSystem.addCustomerList(customer6);
        bankingSystem.addCustomerList(customer7);
        bankingSystem.addCustomerList(customer8);
        bankingSystem.addCustomerList(customer9);
        bankingSystem.addCustomerList(customer10);
        bankingSystem.addCustomerList(customer11);
        bankingSystem.addCustomerList(customer12);
        bankingSystem.addCustomerList(customer13);
        bankingSystem.addCustomerList(customer14);
    }

    private void initEmployee() {
        Employee employee1 = new EmployeeBuilder()
                .setName("Jhon Oscar")
                .setTypeEmployee(TypeEmployee.MANAGER)
                .setEmail("josalazar@uniquindio.edu.co")
                .setAddress("Calle 13")
                .setDNI("456789123")
                .setPhone("3148613948")
                .setPassword("456789123")
                .setRegistrationDate(LocalDate.now())
                .build();

        Employee employee2 = new EmployeeBuilder()
                .setName("Carlos Perez")
                .setTypeEmployee(TypeEmployee.CASHIER)
                .setEmail("carlos.perez@uniquindio.edu.co")
                .setAddress("Calle 14")
                .setDNI("789123456")
                .setPhone("3188613999")
                .setPassword("contraseniaxd")
                .setRegistrationDate(LocalDate.now())
                .build();

        Employee employee3 = new EmployeeBuilder()
                .setName("Ana Gomez")
                .setTypeEmployee(TypeEmployee.CASHIER)
                .setEmail("ana.gomez@uniquindio.edu.co")
                .setAddress("Calle 15")
                .setDNI("654987321")
                .setPhone("3008613950")
                .setPassword("ajoconcebolla")
                .setRegistrationDate(LocalDate.now())
                .build();

        Employee employee4 = new EmployeeBuilder()
                .setName("Luis Morales")
                .setTypeEmployee(TypeEmployee.CASHIER)
                .setEmail("luis.morales@uniquindio.edu.co")
                .setAddress("Calle 16")
                .setDNI("987321654")
                .setPhone("3158613951")
                .setPassword("holamundouwu")
                .setRegistrationDate(LocalDate.now())
                .build();

        Employee employee5 = new EmployeeBuilder()
                .setName("Maria Rodriguez")
                .setTypeEmployee(TypeEmployee.CASHIER)
                .setEmail("maria.rodriguez@uniquindio.edu.co")
                .setAddress("Calle 17")
                .setDNI("421654987")
                .setPhone("3148677952")
                .setPassword("unavacasincola")
                .setRegistrationDate(LocalDate.now())
                .build();

        bankingSystem.addEmployeeList(employee1);
        bankingSystem.addEmployeeList(employee2);
        bankingSystem.addEmployeeList(employee3);
        bankingSystem.addEmployeeList(employee4);
        bankingSystem.addEmployeeList(employee5);
    }

    private void initAccountAssociation() {
        AccountAssociation accountAssociation1 = new AccountAssociation(bankingSystem.getCustomerList().get(0), bankingSystem.getSavingsAccountList().get(0));
        AccountAssociation accountAssociation2 = new AccountAssociation(bankingSystem.getCustomerList().get(1), bankingSystem.getSavingsAccountList().get(1));
        AccountAssociation accountAssociation3 = new AccountAssociation(bankingSystem.getCustomerList().get(2), bankingSystem.getSavingsAccountList().get(2));
        AccountAssociation accountAssociation4 = new AccountAssociation(bankingSystem.getCustomerList().get(3), bankingSystem.getSavingsAccountList().get(3));
        AccountAssociation accountAssociation5 = new AccountAssociation(bankingSystem.getCustomerList().get(4), bankingSystem.getCheckingAccountList().get(0));
        AccountAssociation accountAssociation6 = new AccountAssociation(bankingSystem.getCustomerList().get(5), bankingSystem.getCheckingAccountList().get(1));
        AccountAssociation accountAssociation7 = new AccountAssociation(bankingSystem.getCustomerList().get(6), bankingSystem.getCheckingAccountList().get(2));


        bankingSystem.getAccountAssociationList().add(accountAssociation1);
        bankingSystem.getAccountAssociationList().add(accountAssociation2);
        bankingSystem.getAccountAssociationList().add(accountAssociation3);
        bankingSystem.getAccountAssociationList().add(accountAssociation4);
        bankingSystem.getAccountAssociationList().add(accountAssociation5);
        bankingSystem.getAccountAssociationList().add(accountAssociation6);
        bankingSystem.getAccountAssociationList().add(accountAssociation7);


    }

    public List<Customer> getCustomerList() {
        return bankingSystem.getCustomerList();
    }

    public boolean removeCustomer(Customer selectedCustomer) {
        return bankingSystem.removeCustomer(selectedCustomer);
    }

    public boolean createCustomer(Customer customer) {
        return bankingSystem.createCustomer(customer);
    }

    public boolean upDateCustomer(Customer selectedCustomer, Customer customerUpdate) {
        return bankingSystem.updateCustomer(selectedCustomer, customerUpdate);
    }

    public List<Customer> getCustomersOfAge(int age) {
        return bankingSystem.getCustomersOfAge(age);
    }

    public List<Customer> getCustomersPostRegistration(LocalDate postRegistrationDate) {
        return bankingSystem.getCustomersPostRegistration(postRegistrationDate);
    }

    public List<Employee> getEmployeesList() {
        return bankingSystem.getEmployeesList();
    }

    public boolean createCashier(Employee cashier) {
return bankingSystem.createCashier(cashier);
    }

    public boolean removeCashier(Employee cashierSelected) {
        return bankingSystem.removeCashier(cashierSelected);
    }

    public boolean upDateCashier(Employee cashierSelected, Employee cashierUpdate) {
        return bankingSystem.upDateCashier(cashierSelected, cashierUpdate);
    }

    public Employee validateEmployee(String employee, String password) {
        return bankingSystem.validateEmployee(employee, password);
    }

    public Employee addEmployee(String identification, String name, String email, String address, String password, String phone) {
        return bankingSystem.addEmployee(identification, name, email, address, password, phone);
    }

    public List<SavingsAccount> getSavingAccountList() {
        return bankingSystem.getSavingsAccountList();
    }

    public boolean createSavingsAccount(SavingsAccount savingsAccount) {
        return bankingSystem.createSavingsAccount(savingsAccount);
    }

    public boolean removeSavingAccount(SavingsAccount selectedSavingsAccount) {
        return bankingSystem.removeSavingAccount(selectedSavingsAccount);
    }

    public boolean updateSavingAccount(SavingsAccount selectedSavingsAccount, SavingsAccount savingsAccountUpdate) {
        return bankingSystem.updateSavingAccount(selectedSavingsAccount, savingsAccountUpdate);
    }

    public List<CheckingAccount> getCheckingAccountList() {
        return bankingSystem.getCheckingAccountList();
    }

    public boolean createCheckingAccount(CheckingAccount checkingAccount) {
        return bankingSystem.createCheckingAccount(checkingAccount);
    }

    public boolean updateCheckingAccount(CheckingAccount selectedChekingAccount, CheckingAccount checkingAccountUpdate) {
        return bankingSystem.updateCheckingAccount(selectedChekingAccount, checkingAccountUpdate);
    }

    public boolean removeCheckingAccount(CheckingAccount selectedChekingAccount) {
        return  bankingSystem.removeCheckingAccount(selectedChekingAccount);
    }

    public List<AccountAssociationDto> getAccountAssociationList() {
        List<AccountAssociation> accountAssociationList = bankingSystem.getAccountAssociationList();
        List<AccountAssociationDto> accountAssociationDtoList = new ArrayList<>();

        for(AccountAssociation accountAssociation : accountAssociationList) {
            accountAssociationDtoList.add(buildAccountAssociationDto(accountAssociation));
        }

        return  accountAssociationDtoList;
    }

    private AccountAssociationDto buildAccountAssociationDto(AccountAssociation accountAssociation) {
        String accountType = "";
        if (accountAssociation.getAccount() instanceof SavingsAccount) {
            accountType = "Ahorro";
        } else if (accountAssociation.getAccount() instanceof CheckingAccount) {
            accountType = "Corriente";
        }

        return new AccountAssociationDto(
                accountAssociation.getCustomer().getName(),
                accountAssociation.getCustomer().getDNI(),
                accountAssociation.getAccount().getAccountNumber(),
                accountType
        );
    }

    public List<Customer> getUnassociatedCustomers() {
       return bankingSystem.getUnassociatedCustomers();
    }




    public List<Account> getUnassociatedAccounts() {
       return bankingSystem.getUnassociatedAccounts();
    }


    public void addAssociation(AccountAssociation newAssociation) {
        bankingSystem.addAssociation(newAssociation);
    }


    public Customer getCustomerByDni(String dni) {
       return bankingSystem.getCustomerByDni(dni);
    }

    public Account getAccountByNumber(String accountNumber) {
        return bankingSystem.getAccountByNumber(accountNumber);
    }

    public boolean removeAssociation(Customer customer, Account account) {
        return bankingSystem.removeAssociation(customer, account);
    }
}
