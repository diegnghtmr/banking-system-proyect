package co.edu.uniquindio.bankingsystem.bankingsystem.dto;

public record LoanDto(
        String idCustomer,
        String referenceNumber,
        String loanDate,
        double amount,
        String state) {
}
