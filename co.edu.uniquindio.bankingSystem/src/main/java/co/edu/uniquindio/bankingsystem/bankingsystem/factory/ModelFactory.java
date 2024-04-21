package co.edu.uniquindio.bankingsystem.bankingsystem.factory;

import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Transaction;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.CheckingAccount;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.Deposit;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.SavingsAccount;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.Withdrawal;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.BankingSystem;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.builder.CustomerBuilder;

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

        account1.getTransactionList().add(transaction1);
        account2.getTransactionList().add(transaction2);
        account3.getTransactionList().add(transaction3);
        account4.getTransactionList().add(transaction4);
        account5.getTransactionList().add(transaction5);
        account6.getTransactionList().add(transaction6);
        account7.getTransactionList().add(transaction7);

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
        bankingSystem.addCustomerList(customer1);
        bankingSystem.addCustomerList(customer2);
        bankingSystem.addCustomerList(customer3);
        bankingSystem.addCustomerList(customer4);
        bankingSystem.addCustomerList(customer5);
        bankingSystem.addCustomerList(customer6);
        bankingSystem.addCustomerList(customer7);
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


    public List<CheckingAccount> getCheckingAccountList() {
        return bankingSystem.getCheckingAccountList();
    }

    public boolean createCheckingAccount(CheckingAccount checkingAccount) {
        return bankingSystem.createCheckingAccount(checkingAccount);
    }
}
