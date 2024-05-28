package co.edu.uniquindio.bankingsystem.bankingsystem.dto;

public record MovementDto(
        String account,
        double amount,
        String movementDate,
        String referenceNumber,
        String status,
        String transactionType) {
}