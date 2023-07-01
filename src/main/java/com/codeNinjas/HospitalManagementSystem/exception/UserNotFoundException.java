package com.codeNinjas.HospitalManagementSystem.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(int userId){
        super("Couldn't find the user with ID "+userId);
    }
}
