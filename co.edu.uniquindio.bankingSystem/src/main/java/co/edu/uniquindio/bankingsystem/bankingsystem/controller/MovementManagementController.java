package co.edu.uniquindio.bankingsystem.bankingsystem.controller;

import co.edu.uniquindio.bankingsystem.bankingsystem.dto.MovementDto;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.ModelFactory;
import co.edu.uniquindio.bankingsystem.bankingsystem.factory.inter.Transaction;
import co.edu.uniquindio.bankingsystem.bankingsystem.model.Movement;

import java.util.List;

public class MovementManagementController {
    ModelFactory modelFactory;

    public MovementManagementController() {
        modelFactory = ModelFactory.getInstance();
    }

     public List<MovementDto> getMovementList() {
        return modelFactory.getMovementList();
    }
}