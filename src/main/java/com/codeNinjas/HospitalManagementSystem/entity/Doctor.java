package com.codeNinjas.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor

@AllArgsConstructor
@Data
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_ID")
    private int id;
    @Column(name = "first_name", nullable = false)
    private String first_name;
    @Column(name = "last_name", nullable = false)
    private String last_name;
    @Column(name = "specialization", nullable = false)
    private String specialization;
    @Column(name = "service_start_date", nullable = false)
    private String service_start_date;
    @Column(name = "available_days_of_week", nullable = false)
    private String available_days_of_week;
    @Column(name = "available_time", nullable = false)
    private String available_time;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "contact", nullable = false)
    private String contact;
    @Column(name = "password", nullable = false)
    private String password;
}

