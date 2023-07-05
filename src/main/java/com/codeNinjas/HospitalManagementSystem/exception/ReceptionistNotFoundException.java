package com.codeNinjas.HospitalManagementSystem.exception;

public class ReceptionistNotFoundException extends RuntimeException{

    public ReceptionistNotFoundException(int receptionistId){
        super("Couldn't find the receptionist with ID "+receptionistId);
    }
}
