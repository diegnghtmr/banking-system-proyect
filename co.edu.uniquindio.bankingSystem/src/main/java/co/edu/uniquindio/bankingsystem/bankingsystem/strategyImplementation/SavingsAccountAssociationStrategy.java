//package co.edu.uniquindio.bankingsystem.bankingsystem.strategyImplementation;
//
//import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Account;
//import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.implementation.SavingsAccount;
//import co.edu.uniquindio.bankingsystem.bankingsystem.model.Customer;
//import co.edu.uniquindio.bankingsystem.bankingsystem.services.IAccountAssociationStrategy;
//
//public class SavingsAccountAssociationStrategy implements IAccountAssociationStrategy {
//
//    @Override
//    public void associateAccount(Customer customer, Account account){
//        if (account instanceof SavingsAccount) {
//            SavingsAccount savingsAccount = (SavingsAccount) account;
//            if (customer.getSavingsAccount() == null) {
//                customer.setSavingsAccount(savingsAccount);
//                savingsAccount.addHolder(customer);
//                System.out.println("La cuenta de ahorros ha sido asociada al cliente " + customer.getName());
//            } else {
//                System.out.println("El cliente " + customer.getName() + " ya tiene asociada una cuenta de ahorros");
//            }
//        } else {
//            System.out.println("Error: Se esperaba una cuenta de ahorros");
//        }
//    }
//
//    }
//}
