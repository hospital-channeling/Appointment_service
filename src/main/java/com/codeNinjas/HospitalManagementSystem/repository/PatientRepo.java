package com.codeNinjas.HospitalManagementSystem.repository;

import com.codeNinjas.HospitalManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepo extends JpaRepository<Patient, Integer> {

    @Query(value="SELECT * FROM Patient WHERE Id = ?1", nativeQuery = true)
    Patient getPatientByID(String patientID);

}
