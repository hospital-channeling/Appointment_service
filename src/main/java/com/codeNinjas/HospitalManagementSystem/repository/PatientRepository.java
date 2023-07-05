package com.codeNinjas.HospitalManagementSystem.repository;

import com.codeNinjas.HospitalManagementSystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    @Query(value="SELECT * FROM patient WHERE Id = ?1", nativeQuery = true)
    Patient getUserByID(int userID);

}
