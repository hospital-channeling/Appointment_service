package com.codeNinjas.HospitalManagementSystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientDTO {

    @Id
    private int id;
    private String first_name;
    private String last_name;
    private String address;
    private int age;
    private Date birthdate;
    private String gender;
    private String email;
    private String contact;

}

