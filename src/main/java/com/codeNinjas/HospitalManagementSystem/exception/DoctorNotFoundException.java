package com.codeNinjas.HospitalManagementSystem.exception;

public class DoctorNotFoundException extends RuntimeException{

    public DoctorNotFoundException(int doctorId){
        super("Couldn't find the doctor with ID "+doctorId);
    }
}
