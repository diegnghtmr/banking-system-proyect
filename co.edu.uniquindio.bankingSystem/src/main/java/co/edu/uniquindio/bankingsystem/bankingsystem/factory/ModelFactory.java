package co.edu.uniquindio.bankingsystem.bankingsystem.factory;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Transaction;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.*;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.BankingSystem;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Employee;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.builder.CustomerBuilder;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.builder.EmployeeBuilder;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.enums.TypeEmployee;

import java.time.LocalDate;
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

        Transaction transaction1 = transactionFactory.getTransaction("DEPOSIT");
        Transaction transaction2 = transactionFactory.getTransaction("WITHDRAWAL");
        Transaction transaction3 = transactionFactory.getTransaction("DEPOSIT");
        Transaction transaction4 = transactionFactory.getTransaction("WITHDRAWAL");
        Transaction transaction5 = transactionFactory.getTransaction("DEPOSIT");
        Transaction transaction6 = transactionFactory.getTransaction("WITHDRAWAL");
        Transaction transaction7 = transactionFactory.getTransaction("DEPOSIT");
        Transaction transaction8 = transactionFactory.getTransaction("TRANSFER");
        Transaction transaction9 = transactionFactory.getTransaction("TRANSFER");
        Transaction transaction10 = transactionFactory.getTransaction("TRANSFER");
        Transaction transaction11 = transactionFactory.getTransaction("TRANSFER");
        Transaction transaction12 = transactionFactory.getTransaction("TRANSFER");

        transaction1.setAmount(10500);
        transaction2.setAmount(5006687);
        transaction3.setAmount(20006);
        transaction4.setAmount(1000000);
        transaction5.setAmount(300088);
        transaction6.setAmount(150077);
        transaction7.setAmount(400077);
        transaction8.setAmount(5000);
        transaction9.setAmount(200054);
        transaction10.setAmount(1090000);
        transaction11.setAmount(300076);
        transaction12.setAmount(150000);

        transaction1.setDate(LocalDate.now().minusMonths(5));
        transaction2.setDate(LocalDate.now().minusMonths(1));
        transaction3.setDate(LocalDate.now().minusMonths(2));
        transaction4.setDate(LocalDate.now().minusMonths(15));
        transaction5.setDate(LocalDate.now().minusMonths(9));
        transaction6.setDate(LocalDate.now().minusMonths(8));
        transaction7.setDate(LocalDate.now().minusMonths(7));
        transaction8.setDate(LocalDate.now().minusMonths(6));
        transaction9.setDate(LocalDate.now().minusMonths(5));
        transaction10.setDate(LocalDate.now().minusMonths(4));
        transaction11.setDate(LocalDate.now().minusMonths(3));
        transaction12.setDate(LocalDate.now().minusMonths(2));

        transaction1.setAccount(account1);
        transaction2.setAccount(account2);
        transaction3.setAccount(account3);
        transaction4.setAccount(account4);
        transaction5.setAccount(account5);
        transaction6.setAccount(account6);
        transaction7.setAccount(account7);
        transaction8.setAccount(account1);
        transaction9.setAccount(account2);
        transaction10.setAccount(account3);
        transaction11.setAccount(account4);
        transaction12.setAccount(account5);

        ((Transfer) transaction8).setAccountDestination(account6);
        ((Transfer) transaction9).setAccountDestination(account7);
        ((Transfer) transaction10).setAccountDestination(account7);
        ((Transfer) transaction11).setAccountDestination(account1);
        ((Transfer) transaction12).setAccountDestination(account2);

        account1.getTransactionList().add(transaction1);
        account2.getTransactionList().add(transaction2);
        account3.getTransactionList().add(transaction3);
        account4.getTransactionList().add(transaction4);
        account5.getTransactionList().add(transaction5);
        account6.getTransactionList().add(transaction6);
        account7.getTransactionList().add(transaction7);
        account1.getTransactionList().add(transaction8);
        account2.getTransactionList().add(transaction9);
        account3.getTransactionList().add(transaction10);
        account4.getTransactionList().add(transaction11);
        account5.getTransactionList().add(transaction12);

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

        bankingSystem.addSavingsAccountList((SavingsAccount) account1);
        bankingSystem.addCheckingAccountList((CheckingAccount) account2);
        bankingSystem.addSavingsAccountList((SavingsAccount) account3);
        bankingSystem.addCheckingAccountList((CheckingAccount) account4);
        bankingSystem.addSavingsAccountList((SavingsAccount) account5);
        bankingSystem.addCheckingAccountList((CheckingAccount) account6);
        bankingSystem.addSavingsAccountList((SavingsAccount) account7);
        bankingSystem.addDepositList((Deposit) transaction1);
        bankingSystem.addWithdrawalList((Withdrawal) transaction2);
        bankingSystem.addDepositList((Deposit) transaction3);
        bankingSystem.addWithdrawalList((Withdrawal) transaction4);
        bankingSystem.addDepositList((Deposit) transaction5);
        bankingSystem.addWithdrawalList((Withdrawal) transaction6);
        bankingSystem.addDepositList((Deposit) transaction7);
        bankingSystem.addTransferList((Transfer) transaction8);
        bankingSystem.addTransferList((Transfer) transaction9);
        bankingSystem.addTransferList((Transfer) transaction10);
        bankingSystem.addTransferList((Transfer) transaction11);
        bankingSystem.addTransferList((Transfer) transaction12);
        bankingSystem.addCustomerList(customer1);
        bankingSystem.addCustomerList(customer2);
        bankingSystem.addCustomerList(customer3);
        bankingSystem.addCustomerList(customer4);
        bankingSystem.addCustomerList(customer5);
        bankingSystem.addCustomerList(customer6);
        bankingSystem.addCustomerList(customer7);
    }

    private void initEmployee() {
        Employee employee1 = new EmployeeBuilder()
                .setName("Jhon Oscar")
                .setTypeEmployee(TypeEmployee.MANAGER)
                .setEmail("josalazar@uniquindio.edu.co")
                .setAddress("Calle 13")
                .setDNI("456789123")
                .setPhone("3148613948")
                .setPassword("estovalelaplata")
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

    public List<Deposit> getDepositList() {
        return bankingSystem.getDepositList();
    }

    public List<Deposit>getDeposit() {
        return bankingSystem.getDeposit();
    }

    public List<Account> getAccountsList() {
        return bankingSystem.getAccountsList();
    }

    public Deposit createDepositProduct() {
        return bankingSystem.createDepositProduct();
    }

    public boolean createDeposit(Deposit deposit) {
        return bankingSystem.createDeposit(deposit);
    }

    public List<Transfer> getTransferList() {
        return bankingSystem.getTransferList();
    }

    public Account getAccountByAccountNumber(String accountDestination) {
        return bankingSystem.getAccountByAccountNumber(accountDestination);
    }

    public Transfer createTransferProduct() {
        return bankingSystem.createTransferProduct();
    }

    public boolean createTransfer(Transfer transfer) {
        return bankingSystem.createTransfer(transfer);
    }
}
