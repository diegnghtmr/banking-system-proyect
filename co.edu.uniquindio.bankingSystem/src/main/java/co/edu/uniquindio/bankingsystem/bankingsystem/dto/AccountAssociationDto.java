package co.edu.uniquindio.bankingsystem.bankingsystem.dto;

public record AccountAssociationDto(
        String name,
        String dni,
        String accountNumber,
        String accountType
) {
}