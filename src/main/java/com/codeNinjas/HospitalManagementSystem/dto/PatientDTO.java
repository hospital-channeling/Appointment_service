package com.codeNinjas.HospitalManagementSystem.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientDTO {

    @Id
    private int id;
    private String first_name;
    private String last_name;
    private String address;
    private String birthdate;
    private String gender;
    private String email;
    private String contact;
    private String password;
}

